package BOJ.DataStructures.Stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// 오큰수
public class _17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n - 1]);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        int max = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int x = arr[i];
            if (max > x) {
                while (!stack.isEmpty() && stack.peek() <= x) {
                    stack.pop();
                }
            } else {
                stack.clear();
            }
            if (stack.isEmpty()) {
                list.add(-1);
            } else {
                list.add(stack.peek());
            }
            if (i != 0 && arr[i - 1] < x) {
                stack.push(x);
            }
            max = Math.max(max, x);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i) + " ");
        }
        System.out.print(sb.toString());
    }
}
