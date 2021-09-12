package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 배열 돌리기 4
public class _17406 {
    static int n, m, k, res = Integer.MAX_VALUE;
    static int[] visit;
    static int[][] arr;
    static ArrayList<Node> list;

    static class Node {
        int row, col, size;

        public Node(int row, int col, int size) {
            this.row = row;
            this.col = col;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new int[k];
        list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            list.add(new Node(a, b, c));
        }
        solve(1);
        System.out.println(res);
    }

    private static void solve(int cnt) {
        if (cnt == k + 1) {
            int[][] tmp = new int[n][m];
            for (int i = 0; i < n; i++) {
                tmp[i] = Arrays.copyOf(arr[i], m);
            }
            for (int i = 0; i < k; i++) {
                Node node = list.get(visit[i] - 1);
                tmp = move(node.row, node.col, node.size, tmp);
            }

            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += tmp[i][j];
                }
                res = Math.min(sum, res);
            }
            return;
        }
        for (int i = 0; i < k; i++) {
            if (visit[i] == 0) {
                visit[i] = cnt;
                solve(cnt + 1);
                visit[i] = 0;
            }
        }
    }


    static int[][] move(int row, int col, int scope, int[][] array) {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            tmp[i] = Arrays.copyOf(array[i], m);
        }
        for (int i = 1, z = 2; i <= scope; i++, z += 2) {
            int x = row - i;
            int y = col - i;
            for (int j = 0; j < z; j++) {
                tmp[x][y + 1] = array[x][y];
                y++;
            }
            for (int j = 0; j < z; j++) {
                tmp[x + 1][y] = array[x][y];
                x++;
            }
            for (int j = 0; j < z; j++) {
                tmp[x][y - 1] = array[x][y];
                y--;
            }
            for (int j = 0; j < z; j++) {
                tmp[x - 1][y] = array[x][y];
                x--;
            }
        }
        return tmp;
    }
}
