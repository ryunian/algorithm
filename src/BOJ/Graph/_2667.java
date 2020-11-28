package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class _2667 {
    static int n;
    static int[][] map;
    static boolean[][] check;
    // 북 동 남 서
    static int[][] pos = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static PriorityQueue<Integer> priorityQueue = new PriorityQueue();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = chars[j] - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                check[i][j] = true;
                if (map[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }

//        for (int[] i : map) {
//            for (int j : i) {
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }
        System.out.println(priorityQueue.size());
        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }

    private static void dfs(int a, int b) {
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{a, b});

        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] x = queue.poll();
            for(int[] arr : pos){
                int a2 = arr[0] + x[0];
                int b2 = arr[1] + x[1];
                if(a2 == -1 || a2 == n || b2 == -1 || b2 == n) continue;
                if(map[a2][b2]== 1 && !check[a2][b2]){
                    queue.add(new int[]{a2,b2});
                    check[a2][b2] = true;
                    map[a2][b2] = ++cnt;
                }
            }
        }
//        System.out.println(cnt);
        priorityQueue.add(cnt);
    }
}
