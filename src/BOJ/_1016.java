package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] arr = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long start = min % pow == 0 ? (min / pow) : (min / pow) + 1;

            for (long j = start; j * pow <= max; j++) {
                arr[(int) ((j * pow) - min)] = true;
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                res++;
            }
        }
        System.out.println(res);

    }
}
