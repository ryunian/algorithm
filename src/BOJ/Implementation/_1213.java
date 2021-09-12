package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 펠린드롬 만들기
public class _1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] alpha = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int x = str.charAt(i) - 'A';
            alpha[x]++;
        }
        int cnt = 0;
        int idx = -1;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 == 1) {
                cnt++;
                idx = i;
            }
        }
        if (cnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] == 0) continue;
            int length = alpha[i] / 2;
            if (i == idx) {
                length = (alpha[i] - 1) / 2;
            }
            for (int j = 0; j < length; j++) {
                char c = (char) (i + 'A');
                sb.append(c);
                stack.push(c);
            }
        }
        if (idx != -1) {
            char x = (char) (idx + 'A');
            sb.append(x);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
