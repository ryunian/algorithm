package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _2141 {
    private static class Pair {
        long idx;
        long human;

        public Pair(long idx, long human) {
            this.idx = idx;
            this.human = human;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Pair> list = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            list.add(new Pair(a, b));
            sum += b;
        }
        list.sort(Comparator.comparing(o-> o.idx));

        long tmp = 0;
        long res = 0;
        for (Pair pair : list) {
            tmp += pair.human;
            if (tmp >= (sum + 1) / 2) {
                res = pair.idx;
                break;
            }
        }
        System.out.println(res);

    }
}
