package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// upperBound , lowerBound 이용
public class _7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        long[] arrA = new long[n];
        long[] arrB = new long[n];
        long[] arrC = new long[n];
        long[] arrD = new long[n];

        long[] arrAB = new long[n * n];
        long[] arrCD = new long[n * n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arrA[i] = Long.parseLong(st.nextToken());
            arrB[i] = Long.parseLong(st.nextToken());
            arrC[i] = Long.parseLong(st.nextToken());
            arrD[i] = Long.parseLong(st.nextToken());
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrAB[idx] = arrA[i] + arrB[j];
                arrCD[idx] = arrC[i] + arrD[j];
                idx++;
            }
        }

        Arrays.sort(arrAB);
        Arrays.sort(arrCD);

        long cnt = 0;
        for (int i = 0; i < arrAB.length; i++) {
            cnt += upperBound(0, arrCD.length, -arrAB[i], arrCD) - lowerBound(0, arrCD.length, -arrAB[i], arrCD);
        }
        System.out.println(cnt);
    }

    private static long upperBound(int left, int right, long val, long[] arr) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private static long lowerBound(int left, int right, long val, long[] arr) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
