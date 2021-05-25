package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _17413 {
    static String str;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        solve(0);
    }

    private static void solve(int idx) {
        if (idx >= str.length()) {
            System.out.println(sb.toString());
            return;
        }
        char c = str.charAt(idx);
        if (c == '<') {
            idx = tag(idx);

        } else if (c == ' ') {
            sb.append(c);

        } else {
            idx = reverse(idx);
        }
        solve(idx + 1);
    }

    private static int reverse(int idx) {
        Stack<Character> stack = new Stack<>();
        while (idx < str.length()) {
            char c = str.charAt(idx);
            if (c == ' ' || c == '<') {
                break;
            }
            stack.push(c);
            idx++;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return idx - 1;
    }


    private static int tag(int idx) {
        while (true) {
            sb.append(str.charAt(idx));
            if (str.charAt(idx) == '>') {
                break;
            }
            idx++;
        }
        return idx;
    }
}
