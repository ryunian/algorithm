package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 나무재테크
public class _16235_2 {
    static int n, m, k;
    static int[][] arr, org;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static ArrayDeque<Node> deque;
    static List<Node> death = new ArrayList<>();
    static ArrayList<Node> tree5;

    static class Node {
        int x, y, age;

        public Node(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        org = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = 5;
                org[i][j] = val;
            }
        }
        deque = new ArrayDeque<>();
        tree5 = new ArrayList<>();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            tree5.add(new Node(a, b, c));
        }
        tree5.sort(Comparator.comparingInt(o -> o.age));
        deque.addAll(tree5);
        tree5.clear();
        solve();
    }


    private static void solve() {
        while (k-- > 0) {
            // 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
            // 각각의 나무는 나무가 있는 1×1 크기의 칸에 있는 양분만 먹을 수 있다.
            // 하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다.
            // 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
            spring();

            // 여름에는 봄에 죽은 나무가 양분으로 변하게 된다.
            // 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다.
            // 소수점 아래는 버린다.
            summer();

            // 가을에는 나무가 번식한다.
            // 번식하는 나무는 나이가 5의 배수이어야 하며,
            // 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
            // 어떤 칸 (r, c)와 인접한 칸은
            // (r-1, c-1), (r-1, c), (r-1, c+1), (r, c-1), (r, c+1), (r+1, c-1), (r+1, c), (r+1, c+1) 이다.
            // 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
            fall();

            // 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다.
            // 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
            winter();
        }
        System.out.println(deque.size());
    }

    private static void spring() {
        int size = deque.size();
        while (size-- > 0) {
            Node cur = deque.poll();
            if (arr[cur.x][cur.y] >= cur.age) {
                arr[cur.x][cur.y] -= cur.age;
                cur.age++;
                deque.addLast(cur);
                if (cur.age % 5 == 0) tree5.add(cur);
            } else {
                death.add(cur);
            }
        }
    }

    private static void summer() {
        for (Node node : death) {
            int x = node.x;
            int y = node.y;
            arr[x][y] += node.age / 2;
        }
        death.clear();
    }

    private static void fall() {
        for (Node node : tree5) {
            for (int i = 0; i < 8; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                deque.addFirst(new Node(nx, ny, 1));
            }
        }
        tree5.clear();
    }

    private static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] += org[i][j];
            }
        }
    }
}
