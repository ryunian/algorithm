package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 원판 돌리기
public class _17822 {
    static boolean chk;
    static int n, m;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = val;
            }
        }

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            move(x, d, k);
            chk = false;
            remove();
            if (!chk) {
                remove2();
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res += arr[i][j];
            }
        }
        System.out.println(res);
    }

    private static void remove() {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean isOk = true;
                int val = arr[i][j];
                if (val == 0) continue;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    ny = (ny + m) % m;
                    if (nx < 0 || nx >= n) continue;

                    if (val == arr[nx][ny]) {
                        isOk = false;
                        chk = true;
                        break;
                    }
                }
                if (isOk) {
                    tmp[i][j] = val;
                }
            }
        }
        arr = tmp;
    }

    private static void remove2() {
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = arr[i][j];
                if (tmp != 0) {
                    sum += tmp;
                    cnt++;
                }
            }
        }
        double avg = (double) sum / cnt;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = arr[i][j];
                if (tmp == 0) continue;
                if (tmp > avg) {
                    arr[i][j]--;
                } else if (tmp < avg) {
                    arr[i][j]++;
                }
            }
        }
    }


    private static void move(int a, int b, int c) {
        for (int i = a - 1; i < n; i += a) {
            LinkedList<Integer> tmp = new LinkedList();
            for (int j = 0; j < m; j++) {
                tmp.add(arr[i][j]);
            }
            if (b == 0) {
                for (int j = 0; j < c; j++) {
                    tmp.addFirst(tmp.removeLast());
                }
            } else {
                for (int j = 0; j < c; j++) {
                    tmp.addLast(tmp.removeFirst());
                }
            }
            int idx = 0;
            for (int x : tmp) {
                arr[i][idx++] = x;
            }
        }
    }
}
