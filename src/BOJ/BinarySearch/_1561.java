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

//        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = 30;
//            arr[i] = Integer.parseInt(st.nextToken());
        }

        long left = 0;
        long right = 2000000000L * 30; // n의 최대값과 운행시간의 곱
        long sum = 0; // 놀이기구를 탄 사람 수
        long cnt = 0; // n 번째 탄 사람의 시간
        while (left < right) {
            long mid = (left + right) / 2;
            long tmp = 0;
            // tmp : mid 일떄 놀이기구를 탄 수
            for (int i = 0; i < m; i++) {
                tmp += (mid / arr[i]) + 1; // 0 초일떄는 전부 다 탈수 있으므로 +1 한다.
            }
            System.out.println(left+" "+mid+" "+right);
            // 같은 tmp가 나올수가 있으므로
            // tmp가 같을경우 가장 작은 cnt 를 찾는다 (lowerBound)
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
        System.out.println(sum + " " + cnt);
        // 놀이기구를 탄 사람 수랑 같으므로
        // 뒤에서부터 현 시간에 탑승 가능한 놀이기구 탐색
        if (n == sum) {
            for (int i = m - 1; i >= 0; i--) {
                if (cnt % arr[i] == 0) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
        // 앞에서 부터 탐색
        // 탑승가능한 놀이기구일때 탑승인원을 늘리면서 n 값이랑 같으면 종료
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
