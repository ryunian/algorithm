package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _21610 {
    static int n, m;
    static int[][][] arr;

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static List<Node> cloud;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j][0] = Integer.parseInt(st.nextToken());
            }
        }
        cloud = new ArrayList<>();
        cloud.add(new Node(n - 1, 0));
        cloud.add(new Node(n - 1, 1));
        cloud.add(new Node(n - 2, 0));
        cloud.add(new Node(n - 2, 1));


        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());
            solve(a, b);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += arr[i][j][0];
            }
        }
        System.out.println(res);

    }

    private static void solve(int dir, int speed) {
        for (int i = 0; i < cloud.size(); i++) {
            Node node = cloud.get(i);

            int x = node.x + dx[dir] * speed;
            int y = node.y + dy[dir] * speed;

            x = (x + n * 50) % n;
            y = (y + n * 50) % n;
            node.x = x;
            node.y = y;
            arr[x][y][0]++;
            arr[x][y][1] = 1;
        }
        for (int i = 0; i < cloud.size(); i++) {
            Node node = cloud.get(i);
            int x = node.x;
            int y = node.y;
            int cnt = 0;
            for (int j = 1; j < dx.length; j += 2) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (arr[nx][ny][0] == 0) continue;
                cnt++;
            }
            arr[x][y][0] += cnt;
        }

//        print();
        cloud.clear();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j][1] == 0 && arr[i][j][0] >= 2) {
                    cloud.add(new Node(i, j));
                    arr[i][j][0] -= 2;
                } else {
                    arr[i][j][1] = 0;
                }
            }
        }
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j][0] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
