package BOJ.Implementation;

import java.io.*;
import java.util.*;

// 상어 초등학교
public class _21608 {
    static int n, num;
    static int[][] arr;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        list = new List[n * n + 1];
        for (int i = 1; i <= n * n; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            list[num].add(Integer.parseInt(st.nextToken()));
            list[num].add(Integer.parseInt(st.nextToken()));
            list[num].add(Integer.parseInt(st.nextToken()));
            list[num].add(Integer.parseInt(st.nextToken()));
            solve();
        }
        calc();
    }

    private static void calc() {
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    for (int hope : list[arr[i][j]]) {
                        if (arr[nx][ny] == hope) {
                            cnt++;
                            break;
                        }
                    }
                }
                if (cnt == 1) res += 1;
                if (cnt == 2) res += 10;
                if (cnt == 3) res += 100;
                if (cnt == 4) res += 1000;
            }
        }
        System.out.println(res);
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    private static void solve() {
        ArrayList<Node> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) continue;
                int empty = 0;
                int favor = 0;
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x < 0 || y < 0 || x >= n || y >= n) continue;
                    if (arr[x][y] == 0) empty++;
                    for (int hope : list[num]) {
                        if (arr[x][y] == hope) {
                            favor++;
                            break;
                        }
                    }
                }
                tmp.add(new Node(0, i, j, favor, empty));
            }
        }
        tmp.sort(null);
        Node node = tmp.get(0);
        arr[node.x][node.y] = num;
    }

    static class Node implements Comparable<Node> {
        int num, x, y, favor, empty;

        public Node(int num, int x, int y, int favor, int empty) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.favor = favor;
            this.empty = empty;
        }

        @Override
        public int compareTo(Node o) {
            if (num != o.num) return num - o.num;
            if (favor != o.favor) return o.favor - favor;
            if (empty != o.empty) return o.empty - empty;
            if (x != o.x) return x - o.x;
            return y - o.y;
        }
    }
}
