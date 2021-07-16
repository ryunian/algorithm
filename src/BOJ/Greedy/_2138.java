package BOJ.Greedy;

import java.util.Scanner;

public class _2138 {
    private static int INF = 987654321;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        int[] arr2 = new int[n];
        int[] target = new int[n];

        String a = sc.nextLine();
        String b = sc.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = a.charAt(i) == '0' ? -1 : 1;
            arr2[i] = a.charAt(i) == '0' ? -1 : 1;
            target[i] = b.charAt(i) == '0' ? -1 : 1;
        }

        int x = solve(n, arr, target, 0);
        arr2[0] *= -1;
        arr2[1] *= -1;
        int y = solve(n, arr2, target, 1);

        int res = Math.min(x, y);
        if(res == INF){
            System.out.println(-1);
        }else {
            System.out.println(res);
        }
    }

    private static int solve(int n, int[] arr, int[] target, int cnt) {
        int res = cnt;
        for (int i = 1; i < n; i++) {
            if (i == n - 1) {
                if (arr[i - 1] == target[i - 1]) continue;
                arr[i - 1] *= -1;
                arr[i] *= -1;
                res++;
            } else {
                if (arr[i - 1] == target[i - 1]) continue;
                arr[i - 1] *= -1;
                arr[i] *= -1;
                arr[i + 1] *= -1;
                res++;
            }
        }

        if (arr[n - 1] != target[n - 1]) {
            return INF;
        } else {
            return res;
        }
    }
}
