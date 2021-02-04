package BOJ.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1965 {
    static int n, res = 0;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, -1);

//        solve(n - 1);
//        System.out.println(res);


//        for (int i = 0; i < n; i++) {
//            res = Math.max(res, solve2(i));
//        }
//        System.out.println(res);


        solve3();

    }

    // dp
    private static int solve(int idx) {
        if (idx < 0) return 0;

        int ret = dp[idx];
        if (ret != -1) return ret;
        ret = 1;
        for (int i = 0; i < idx; i++) {
            if (arr[i] < arr[idx]) {
                ret = Math.max(ret, solve(i) + 1);
            } else {
                res = Math.max(res, solve(i));
            }
        }
        res = Math.max(res, ret);
        return dp[idx] = ret;
    }

    // dp
    // n의 개수만큼 solve2 호출
    private static int solve2(int start) {
        int ret = dp[start];
        if (ret != -1) return ret;

        ret = 1;
        for (int next = start + 1; next < n; next++) {
            if (arr[next] > arr[start]) {
                ret = Math.max(ret, solve2(next) + 1);
            }
        }
        return dp[start] = ret;
    }

    // dp + lowerBound
    // nlogn
    // 위치 추적은 _2568.java 참조
    private static void solve3() {
        int[] lis = new int[n];

        lis[0] = arr[0];
        int idx = 0;

        for (int i = 1; i < n; i++) {
            // idx 에 있는 값보다 arr 의 값보다 클경우
            // idx + 1 에 저장
            if (lis[idx] < arr[i]) {
                lis[++idx] = arr[i];
            } else {
                // lowerBound
                int start = 0, end = idx;

                while (start < end) {
                    int mid = (start + end) / 2;
                    if (lis[mid] >= arr[i]) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                }
                int lowerBound = end;

                lis[lowerBound] = arr[i];
            }
        }
//        System.out.println(Arrays.toString(lis));
        System.out.println(idx + 1);
    }

}
