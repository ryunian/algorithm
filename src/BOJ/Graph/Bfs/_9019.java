package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _9019 {
    static int n, m, MOD = 10000;
    static boolean[] visit;

    private static class Node {
        int n;
        String str;

        public Node(int n, String str) {
            this.n = n;
            this.str = str;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (test-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            visit = new boolean[MOD];
            solve();
        }
    }

    private static void solve() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, ""));
        visit[n] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.n == m) {
                System.out.println(cur.str);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextNum = cur.n;
                String nextStr = cur.str;
                switch (i) {
                    case 0:
                        nextNum = (nextNum * 2) % MOD;
                        nextStr += "D";
                        break;
                    case 1:
                        nextNum = nextNum == 0 ? 9999 : nextNum - 1;
                        nextStr += "S";
                        break;
                    case 2:
                        nextNum = (nextNum % 1000) * 10 + nextNum / 1000;
                        nextStr += "L";
                        break;
                    case 3:
                        nextNum = (nextNum % 10) * 1000 + nextNum / 10;
                        nextStr += "R";
                        break;
                }
                if (!visit[nextNum]) {
                    visit[nextNum] = true;
                    queue.add(new Node(nextNum, nextStr));
                }
            }
        }

    }
}
