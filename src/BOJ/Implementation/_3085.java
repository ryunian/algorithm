package BOJ.Implementation;

import java.util.LinkedList;
import java.util.Scanner;

public class _3085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        list.add(arr[n - 1]);
        int x = 0;
        boolean check = false;
        for (int i = n - 2; i >= 0; i--) {
            if (!check) {
                list.add(arr[i]);
                if (arr[i] > arr[i + 1]) {
                    check = true;
                    x = arr[i];
                }
            } else {
                sb.insert(0, arr[i] + " ");
            }

        }
        if (!check) {
            System.out.println(-1);
        } else {
            list.sort((o1, o2) -> o2 - o1);
            int idx = list.indexOf(x);
            sb.append(list.remove(idx + 1) + " ");

            while (!list.isEmpty()) {
                sb.append(list.remove(0) + " ");
            }
            System.out.print(sb.toString());
        }
    }
}