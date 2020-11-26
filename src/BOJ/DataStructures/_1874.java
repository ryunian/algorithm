package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int cnt = 1;

        for (int i = 0; i < n; i++) {
            while(cnt <= arr[i]){
                stack.push(cnt++);
                sb.append("+\n");
            }
//            System.out.println(stack);

            if(!stack.isEmpty() && arr[i] == stack.peek()){
                stack.pop();
                sb.append("-\n");
            }
        }
        if(stack.isEmpty()){
            System.out.println(sb.toString());
        }else{
            System.out.println("NO");
        }
    }
}


