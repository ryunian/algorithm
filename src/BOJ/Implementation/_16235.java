package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16235 {
    private static class Tree {
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    static int n, m, k;
    static int[][] energy;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0, -1, 1, 1, -1};
    static int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};
    static PriorityQueue<Tree> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.age));
    static ArrayList<Tree> deathTree = new ArrayList<>();
    static Queue<Tree> breedTree = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 땅의 크기 = n*n
        n = Integer.parseInt(st.nextToken());
        // 한 자리에 나무를 심은 개수
        m = Integer.parseInt(st.nextToken());
        // 지난 년도 수
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        energy = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = 5;
                energy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            queue.add(new Tree(a, b, c));
        }
        solve(0);
    }

    private static void solve(int year) {
        if (year == k || queue.isEmpty()) {
            System.out.println(queue.size());
            return;
        }

        // 봄
        // 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
        // 나이가 어린 나무부터 양분을 먹는다. 양분을 먹을 수 없는 나무는 죽는다.
        grow();

        // 여름
        // 죽은 나무가 양분으로 변하게 된다.
        // 나이를 2로 나눈 값이 양분으로 추가된다.
        treeToEnergy();

        // 가을
        // 가을에는 나무가 번식한다. 번식하는 나무는 나이가 5의 배수이어야 하며,
        // 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
        breeding();

        if (year == k - 1) {
            System.out.println(queue.size());
            return;
        }

        // 겨울
        // 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다.
        insertEnergy();

        solve(year + 1);
    }

    private static void grow() {
        PriorityQueue<Tree> tmp = new PriorityQueue<>(Comparator.comparing(o -> o.age));

        while (!queue.isEmpty()) {
            Tree tree = queue.poll();
            int x = tree.x;
            int y = tree.y;
            int age = tree.age;
            if (map[x][y] < age) {
                deathTree.add(tree);
            } else {
                tmp.add(new Tree(x, y, age + 1));
                map[x][y] -= age;
                if ((age + 1) % 5 == 0) breedTree.add(tree);
            }
        }
        queue = tmp;
    }

    private static void treeToEnergy() {
        for (Tree tree : deathTree) {
            int x = tree.x;
            int y = tree.y;
            int val = tree.age / 2;
            map[x][y] += val;
        }
        deathTree.clear();
    }

    private static void breeding() {
        while (!breedTree.isEmpty()) {
            Tree tree = breedTree.poll();
            for (int i = 0; i < 8; i++) {
                int nx = tree.x + dx[i];
                int ny = tree.y + dy[i];
                if (nx == 0 || ny == 0 || nx > n || ny > n) continue;
                queue.add(new Tree(nx, ny, 1));
            }
        }
    }

    private static void insertEnergy() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] += energy[i][j];
            }
        }
    }
}
