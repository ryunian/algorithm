package BOJ.BitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9328 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int x, y, result, key, max ;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            result = 0; key = 0; max = 0;
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map = new char[x + 2][y + 2];
            boolean[][] visit = new boolean[x + 2][y + 2];
            for (char[] i : map) {
                Arrays.fill(i, '.');
            }

            for (int i = 1; i <= x; i++) {
                String str = br.readLine();
                for (int j = 1; j <= y; j++) {
                    char z = str.charAt(j - 1);
                    map[i][j] = z;
                    if (z == '$') max++;
                }
            }
            char[] keystr = br.readLine().toCharArray();
            for (int i = 0; i < keystr.length; i++) {
                if (keystr[0] == '0') break;
                int a = keystr[i] - 'a';
                key = key | (1 << a);
            }
            bfs(0, 0, visit);


//            System.out.println();
//            for (char[] a : map) {
//                for (char b : a) {
//                    System.out.print(b + " ");
//                }
//                System.out.println();
//            }
//
//            System.out.println(Integer.toBinaryString(key));
            System.out.println(result);
        }
    }

    private static void bfs(int a, int b, boolean[][] visited) {
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(a, b));
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (map[node.x][node.y] == '$') {
                result++;
                map[node.x][node.y] = '.';
            }
//            if (result > max) return;
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= x + 2 || ny >= y + 2) continue;
                if (map[nx][ny] == '*' || visited[nx][ny]) continue;
                // 기존에 없던 열쇠일 경우
                if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z' && (key & (1 << map[nx][ny] - 'a')) == 0) {
                    // 방문정보 초기화
                    visited = new boolean[x + 2][y + 2];
                    int bit = 1 << (map[nx][ny] - 'a');
                    key |= bit;
                    bfs(nx, ny, visited);
                }
                // 문일 경우
                else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {
                    // 문이 열릴 경우
                    int bit = 1 << (map[nx][ny] - 'A');
                    if ((key & bit) > 0) {
                        map[nx][ny] = '.';
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny));
                    } else {
                        continue;
                    }
                } else {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }

            }
        }
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
