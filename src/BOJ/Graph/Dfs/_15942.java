package BOJ.Graph.Dfs;

import java.util.HashSet;
import java.util.Scanner;

public class _15942 {
    static int n, num1, num2;
    static int[] arr;
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt();
        int p = sc.nextInt();
        num1 = k;
        num2 = k;
        arr = new int[n + 1];
        arr[p] = k;
        set.add(k);
        child(p * 2);
        child(p * 2 + 1);
        parent(p / 2);

        int v = (int) (Math.log(p) / Math.log(2));
        if (k - 1 < v || n < num2) {
            System.out.println(-1);
            return;
        }
        int num = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(arr[i] != 0){
                sb.append(arr[i] +"\n");
            }else {
                while (set.contains(num)) num++;
                sb.append(num++ +"\n");
            }
        }
        System.out.print(sb.toString());
    }

    private static void child(int idx) {
        if (idx > n) return;

        arr[idx] = ++num2;
        set.add(num2);
        child(idx * 2);
        child(idx * 2 + 1);
    }

    private static void parent(int idx) {
        if (idx == 0) return;
        arr[idx] = --num1;
        set.add(num1);
        parent(idx / 2);
    }
}
