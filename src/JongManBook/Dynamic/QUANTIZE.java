package JongManBook.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

// 8.9 Quantization
public class QUANTIZE {
    static int n, m, INF = 987654321;
    static int[] arr, pSum, pSqSum;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new int[101];
            pSum = new int[101];
            pSqSum = new int[101];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            dp = new int[101][11];
            for (int i = 0; i < 101; i++) {
                Arrays.fill(dp[i], -1);
            }

            precalc();
            System.out.println(quantize(0, m));
        }
    }

    private static void precalc() {
        Arrays.sort(arr, 0 , n);
        pSum[0] = arr[0];
        pSqSum[0] = arr[0] * arr[0];
        for (int i = 1; i < n; i++) {
            pSum[i] = pSum[i - 1] + arr[i];
            pSqSum[i] = pSqSum[i - 1] + arr[i] * arr[i];
        }
    }

    private static int minError(int lo, int hi) {
        // 부분합을 이용해 A[lo] ~ A[hi] 까지의 합을 구한다.
        int sum = pSum[hi] - (lo == 0 ? 0 : pSum[lo - 1]);
        int sqSum = pSqSum[hi] - (lo == 0 ? 0 : pSqSum[lo - 1]);
        // 평균을 반올림한 값으로 이 값들을 표현한다.
        int m = (int) Math.round((double) sum / (hi - lo + 1));

        int ret = sqSum - 2 * m * sum + m * m * (hi - lo + 1);
        return ret;
    }

    private static int quantize(int from, int parts) {
        if (from == n) return 0;
        if (parts == 0) return INF;
        int ret = dp[from][parts];
        if (ret != -1) return ret;
        ret = INF;
        for (int partSize = 1; from + partSize <= n; partSize++) {
            ret = Math.min(ret, minError(from, from + partSize - 1) + quantize(from + partSize, parts - 1));
        }

        return dp[from][parts] = ret;
    }
}

