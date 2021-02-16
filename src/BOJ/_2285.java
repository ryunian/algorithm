package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _2285 {
    private static class Pair{
        int idx;
        int cnt;

        public Pair(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Pair> list = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Pair(a,b));
            sum += b;
        }
        list.sort(Comparator.comparingInt(o -> o.idx));
        long tmp =0;
        long res = 0;
        for(Pair pair : list){
            tmp += pair.cnt;
            if(tmp >= (sum+1) / 2){
                res = pair.idx;
                break;
            }
        }
        System.out.println(res);

    }
}
