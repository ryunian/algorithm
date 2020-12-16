package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int j = i;
            int val = arr[i];
            while (j < n && j - i < cnt) {
                if (i != j) val += arr[j];
                if (val < target) {
                    j++;
                } else {
                    cnt = Math.min(cnt, j - i);
//                    System.out.println(i+ " "+j);
                    break;
                }
            }
        }
        if (cnt == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(cnt + 1);
        }
    }
}
