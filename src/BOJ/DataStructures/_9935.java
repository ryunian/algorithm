package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9935 {
    private static class Pair{
        char str;
        int cnt;

        public Pair(char str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] x = br.readLine().toCharArray();
        char[] y = br.readLine().toCharArray();

        solve(x,y);
    }

    private static void solve(char[] x, char[] y) {
        Stack<Pair> stack = new Stack<>();
        // 이전의 y값과 일치한 횟수
        int idx = 0;
        for (int i = 0; i < x.length; i++) {
            // 일치할경우 idx값 증가
            if (x[i] == y[idx]){
                idx++;
            }
            // 첫번쨰 값과 일치할경우 1로 초기화
            else if(x[i] == y[0]){
                idx = 1;
            }
            // 일치한게 없을 경우 0으로 초기화
            else{
                idx = 0;
            }
            stack.push(new Pair(x[i], idx));

            // idx값이 y의 길이만큼 있으면 해당 값만큼 stack에서 pop한다.
            if(idx == y.length){
                for (int j = 0; j < y.length; j++) {
                    stack.pop();
                }
                // idx값은 stack의 cnt값으로 초기화
                idx = stack.isEmpty() ? 0 : stack.peek().cnt;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(stack.empty()){
            sb.append("FRULA");
        }else{
            for(Pair a : stack){
                sb.append(a.str);
            }
        }
        System.out.println(sb.toString());
    }
}
