package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.peek() < arr[i] && cnt != m){
                stack.pop();
                cnt++;
            }
            stack.push(arr[i]);
            if(n-i+cnt == m){
                stack.pop();
                cnt++;
            }
//            System.out.println(stack);
        }
        StringBuilder sb = new StringBuilder();
        for(char x : stack){
            sb.append(x);
            // 출력문이 계속 출력되는 것보다
            // Stringbuilder 에 담아서 하는것이 좋다
//            System.out.println(x);
        }
        System.out.println(sb);
    }
}
