package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }
        Arrays.sort(arr, (o1, o2) -> o2 - o1);

        long res = 0;
        for (int i = 0; i < n; i++) {
            int tip = arr[i] - i;
            if(tip < 0) break;

            res += tip;
        }
        System.out.println(res);

    }
}
