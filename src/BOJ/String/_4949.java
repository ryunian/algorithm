package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack;
        while (true) {
            stack = new Stack<>();
            boolean balance = true;
            String str = br.readLine();
            if (str.charAt(0) == '.') break;
            for (int i = 0; i < str.length(); i++) {
                char x = str.charAt(i);
                if (x == '[' || x == '(') {
                    stack.push(x);
                } else if (x == ']' || x == ')') {
                    if(stack.isEmpty()){
                        balance = false;
                        break;
                    }else if(x == ']' && stack.peek() == '['){
                        stack.pop();
                    }else if(x == ')' && stack.peek() == '('){
                        stack.pop();
                    }else{
                        balance = false;
                        break;
                    }
                }
            }

            if (balance && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
