package BOJ.BinarySearch;

import java.util.Scanner;

// A[i][j] 에서, i 행에 속한 숫자들은 i * j 이므로 모두 i의 배수이다.
// 그러므로 min(mid/i , N) 이 i번쨰 행에서 mid 보다 작은 숫자들의 갯수가 된다.
// O(NlogK)
public class _1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int left = 1;
        int right = k;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = 0;
            // mid 보다 작은 수의 갯수
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n);
//                System.out.print(Math.min(mid / i, n) + " ");
            }

            // 갯수가 k보다 작으면 mid 의 값을 올린다.
            if (cnt < k) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        System.out.println(res);
    }
}
/*
n = 5
k = 2

mid = 1
1 0 0 0 0 // 1

mid = 2
2 1 0 0 0 // 3

1 2 3 4 5
2 4 6 8 10
3 6 9 12 15
4 8 12 16 20
5 10 15 20 25
 */