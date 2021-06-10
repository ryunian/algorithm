package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = b * 100 / a;
        long max = 1000000001;
        long left = 0;
        long right = max;
        while (left < right) {
            long mid = (left + right) / 2;
            long na = mid + a;
            long nb = (mid + b) * 100;
            long avg = nb / na;

            if (avg <= c) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(right == max ? -1 : right);
    }

}
