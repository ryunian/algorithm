package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _14502 {
    static int[][] mapOrigin, mapCopy;
    static boolean[][] check;
    static int[][] pos = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int n, m;
    static Queue<int[]> queue = new LinkedList<>();
    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 세로
        n = Integer.parseInt(st.nextToken());
        // 가로
        m = Integer.parseInt(st.nextToken());


        mapOrigin = new int[n][m];
        mapCopy = new int[n][m];

        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int state = Integer.parseInt(st.nextToken());
                mapOrigin[i][j] = state;
//                mapCopy[i][j] = state;
                if (state == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        solution();
    }

    private static void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mapOrigin[i][j] == 0) {
                    mapOrigin[i][j] = 3;
                    dfs(1);
                    mapOrigin[i][j] = 0;
                }
            }
        }
        System.out.println(priorityQueue.peek());
    }

    // 벽을 세운다
    private static void dfs(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mapOrigin[i][j] == 0) {
                    mapOrigin[i][j] = 3;
                    dfs(cnt + 1);
                    mapOrigin[i][j] = 0;
                }
            }
        }
    }

    // 바이러스를 퍼트린다
    private static void bfs() {
        Queue<int[]> cpQueue = new LinkedList<>(queue);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mapCopy[i][j] = mapOrigin[i][j];
            }
        }

        while (!cpQueue.isEmpty()) {
            int[] value = cpQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = value[0] + pos[i][0];
                int ny = value[1] + pos[i][1];
                if (nx > -1 && nx < n && ny > -1 && ny < m && mapCopy[nx][ny] == 0) {
                    mapCopy[nx][ny] = 2;
                    cpQueue.add(new int[]{nx, ny});
                }
            }
        }

        int sum = 0;
        for (int[] x : mapCopy) {
            for (int y : x) {
                if (y == 0) sum++;
            }
        }

        priorityQueue.add(sum);
    }

    private static void print(int[][] arr) {
        for (int[] x : arr) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

