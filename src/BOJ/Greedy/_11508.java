package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(arr, (o1, o2) -> o2 - o1);

        long res = 0;
        int idx = 0;
        while (idx + 2 < n){
            res += arr[idx]+arr[idx+1];
            idx += 3;
        }
        for (int i = idx; i < n; i++) {
            res += arr[i];
        }
        System.out.println(res);
    }
}
