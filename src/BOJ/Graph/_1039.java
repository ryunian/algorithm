package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1039 {
    static int n, k, res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (solve()) {
            System.out.println(res);
        } else {
            System.out.println(-1);
        }

    }

    private static boolean solve() {
        // 자릿수
        int size = String.valueOf(n).length();

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));
        boolean[][] visit = new boolean[10 + 1][1000001];
        visit[0][n] = true;

        // K번 연산이 가능한지 체크
        boolean isPossible = false;
        // 바꾼수가 0으로 시작되는지 체크하기 위한 값
        int maxDigit = (int) Math.pow(10, size-1);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.cnt == k) {
                isPossible = true;
                res = Math.max(res, cur.num);
            }

            // digit : 자릿수
            // num : 일의 자리수
            for (int i = 0; i < size - 1; i++) {
                int digitA = (int) Math.pow(10, i);
                int numA = cur.num / digitA % 10;


                for (int j = i + 1; j < size; j++) {
                    int digitB = (int) Math.pow(10, j);
                    int numB = cur.num / digitB % 10;

                    int next = cur.num
                            - (digitA * numA) - (digitB * numB)
                            + (digitA * numB) + (digitB * numA);

                    // 바꾼 숫자가 0부터 시작될경우 최대 자릿수가 바뀌므로
                    // 나눈 값이 0이 나오면 안된다.
                    if(next / maxDigit == 0) continue;

                    if (cur.cnt < k && !visit[cur.cnt + 1][next]) {
                        visit[cur.cnt + 1][next] = true;
                        queue.add(new Node(next, cur.cnt + 1));
                    }
                }
            }
        }

        return isPossible;
    }

    private static class Node {
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
