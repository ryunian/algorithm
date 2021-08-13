package BOJ.DataStructures.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 키로거
public class _5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            char[] cmd = br.readLine().toCharArray();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            for (int i = 0; i < cmd.length; i++) {
                char c = cmd[i];
                if (c == '<') {
                    if(left.isEmpty()) continue;
                    right.push(left.pop());
                } else if (c == '>') {
                    if(right.isEmpty()) continue;
                    left.push(right.pop());
                } else if (c == '-') {
                    if(left.isEmpty()) continue;
                    left.pop();
                } else {
                    left.push(c);
                }
            }
            while (!left.isEmpty()){
                right.push(left.pop());
            }
            while (!right.isEmpty()){
                sb.append(right.pop());
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
