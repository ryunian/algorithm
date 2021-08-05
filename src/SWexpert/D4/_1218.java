package SWexpert.D4;

import java.util.Scanner;
import java.util.Stack;

public class _1218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(sc.nextLine());
            String str = sc.nextLine();
            Stack<Character> stack = new Stack<>();

            boolean isOk = true;
            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);
                if (c == '(' || c == '[' || c == '{' || c == '<') {
                    stack.push(c);
                } else if (!stack.isEmpty()) {
                    if (stack.peek() == '(' && c == ')') {
                        stack.pop();
                    } else if (stack.peek() == '[' && c == ']') {
                        stack.pop();
                    } else if (stack.peek() == '{' && c == '}') {
                        stack.pop();
                    } else if (stack.peek() == '<' && c == '>') {
                        stack.pop();
                    } else {
                        isOk = false;
                        break;
                    }
                } else {
                    isOk = false;
                    break;
                }
            }
            int res = isOk ? 1 : 0;
            System.out.println("#" + tc + " " + res);
        }
    }
}
