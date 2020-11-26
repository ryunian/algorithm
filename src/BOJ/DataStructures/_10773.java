package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack();
        for (int i = 0; i < n; i++) {
            String x = br.readLine();
            if(x.equals("0")){
                stack.pop();
            }else{
                stack.push(x);
            }
        }
        int sum = 0;
        for(String x : stack){
            sum += Integer.parseInt(x);
        }
        System.out.println(sum);
    }
}
