package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// n의 갯수를 보고 logN 알고리즘을 써야된다고 생각
public class _1561 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long left = 0;
        long right = 2000000000L * 30; // n의 최대값과 운행시간의 곱
        long sum = 0;
        long cnt = 0;
        while (left < right) {
            long mid = (left + right) / 2;
            long tmp = 0;
            for (int i = 0; i < m; i++) {
                tmp += (mid / arr[i]) + 1;
            }
            // 같은 tmp가 나올수가 있으므로
            // tmp가 같을경우 가장 작은 cnt를 찾는다 (lowerBound)
            if (tmp < n) {
                sum = tmp;
                cnt = mid + 1;
                left = mid + 1;
            } else if (tmp >= n) {
                if (tmp == n) {
                    sum = tmp;
                    cnt = mid;
                }
                right = mid;
            }
        }
        if (n == sum) {
            // 뒤에서 부터 탐색
            for (int i = m - 1; i >= 0; i--) {
                if (cnt % arr[i] == 0) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
        // 앞에서 부터 탐색
        for (int i = 0; i < m; i++) {
            if (cnt % arr[i] == 0) {
                sum++;
                if (sum == n) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
    }
}
/*
22 5
1 2 3 4 5
0 : 1 2 3 4 5
1 : 1
2 : 1 2
3 : 1 3
4 : 1 2 4
5 : 1 5
6 : 1 2 3
7 : 1
8 : 1 2 4
 */