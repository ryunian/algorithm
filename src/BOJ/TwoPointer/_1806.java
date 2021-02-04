package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1806 {
    static int n, target, cnt = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        long start = System.currentTimeMillis();
        solve();
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int sum = arr[i];
            if (sum >= target) {
                cnt = 1;
                break;
            }
//            System.out.print(arr[i] + " || ");
            while (j < n && j - i + 1 < cnt) {
//                System.out.print(arr[j]+" ");
                sum += arr[j];
                if (sum < target) {
                    j++;
                } else {
                    cnt = Math.min(cnt, j - i + 1);
                    break;
                }
            }
//            System.out.println();
        }
        if (cnt == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(cnt);
        }
    }
}
