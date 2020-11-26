package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
//        System.out.println(Arrays.toString(arr));
        Stack<String> stack = new Stack<>();

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if("(".equals(arr[i])){
                stack.push(arr[i]);
                if(!stack.isEmpty() && ")".equals(arr[i+1])){
                    stack.pop();
                    cnt += stack.size();
                    i++;
                }
            }else{
                stack.pop();
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
