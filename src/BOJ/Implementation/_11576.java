package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// Base Conversion
public class _11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = k - 1; i >= 0; i--) {
            int x = Integer.parseInt(st.nextToken());
            sum += (int) Math.pow(n , i) * x;
        }
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        while (sum > 0){
            stack.push(sum % m);
            sum /= m;
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        System.out.println(sb);
    }
}
