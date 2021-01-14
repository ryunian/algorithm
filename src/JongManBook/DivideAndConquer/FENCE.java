package JongManBook.DivideAndConquer;

import java.util.Scanner;

// 7.4 울타리 잘라내기
public class FENCE {
    private static int n;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            n = sc.nextInt();
            arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solve(0, n - 1));
        }
    }

    private static int solve(int left, int right) {
        // 판자가 하나밖에 없을 경우
        if (left == right) return arr[left];

        // 왼쪽과 오른쪽 구간으로 나눠서 계산한다.
        int mid = (left + right) / 2;
        int ret = Math.max(solve(left, mid), solve(mid + 1, right));

        // 왼쪽과 오른쪽 두 구간에 걸치는 판자
        int lo = mid;
        int hi = mid + 1;
        int height = Math.min(arr[lo], arr[hi]);
        ret = Math.max(ret, height * 2);

        // 걸치는 판자를 점점 늘린다.
        while (left < lo || hi < right) {
            if (hi < right && (lo == left || arr[lo - 1] < arr[hi + 1])) {
                hi++;
                height = Math.min(height, arr[hi]);
            } else {
                lo--;
                height = Math.min(height, arr[lo]);
            }
            ret = Math.max(ret, height * (hi - lo + 1));
        }
        return ret;
    }
}
/*
3
7
7 1 5 9 6 7 3
7
1 4 4 4 4 1 1
4
1 8 2 2
 */