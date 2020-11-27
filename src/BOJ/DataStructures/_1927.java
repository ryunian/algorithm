package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class _1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue queue = new PriorityQueue();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(!queue.isEmpty()){
                    sb.append(queue.poll()+"\n");
                }else{
                    sb.append("0\n");
                }
            }else{
                queue.add(x);
            }
        }
        System.out.println(sb.toString());

    }
}
