package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] x = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char y : x) {
            switch (y) {
                case '+':
                case '-':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.push(y);
                    break;

                case '*':
                case '/':
                    while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        char p = stack.pop();
                        if (p != '(') sb.append(p);
                    }
                    stack.push(y);
                    break;

                case '(':
                    stack.push(y);
                    break;

                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;

                default:
                    sb.append(y);
            }
        }
        while (!stack.isEmpty()) {
            char a = stack.pop();
            if (a != '(') sb.append(a);
        }

        System.out.println(sb.toString());
    }

}
