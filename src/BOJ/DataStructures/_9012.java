package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<String> stack;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stack = new Stack<>();
            String[] ps = br.readLine().split("");
            stack.push(ps[0]);
            boolean success = true;
            for (int j = 1; j < ps.length; j++) {
                if(ps[j].equals("(")){
                    stack.push(ps[j]);
                }else{
                    if(!stack.isEmpty() && !stack.peek().equals(ps[j])){
                        stack.pop();
                    }else{
                        success = false;
                    }
                }
            }
            if(!stack.isEmpty() || !success){
                sb.append("NO\n");
            }else{
                sb.append("YES\n");
            }
        }
        System.out.println(sb.toString());
    }
}
