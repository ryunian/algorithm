package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
//        System.out.println(queue);
        int cnt = 1;
        while(!queue.isEmpty()){
            int a = queue.poll();
            if(cnt == m){
                sb.append(queue.isEmpty() ? a : a+", ");
                cnt = 1;
            }else{
                queue.add(a);
                cnt++;
            }
//            System.out.println(queue);
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}
