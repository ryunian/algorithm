package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _13975 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        solve1();
    }

    private static void solve1() throws IOException {
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> queue = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                long tmp = Integer.parseInt(st.nextToken());
                queue.add(tmp);
            }
            long res = 0;
            while (queue.size() > 1) {
                long sum = queue.poll() + queue.poll();
                res += sum;
                queue.add(sum);
            }
            System.out.println(res);
        }
    }
}
