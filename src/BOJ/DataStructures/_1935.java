package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            // 사칙연산
            if(x == '*'){
                stack.push(stack.pop() * stack.pop());
            }else if(x == '/'){
                double a = stack.pop();
                double b = stack.pop();
                stack.push(b / a);
            }else if(x == '+'){
                stack.push(stack.pop() + stack.pop());
            }else if(x == '-'){
                double a = stack.pop();
                double b = stack.pop();
                stack.push(b - a);
            }
            // 숫자
            else{
                stack.add(arr[x-'A']);
            }
        }
        System.out.printf("%.2f",stack.peek());
    }
}
