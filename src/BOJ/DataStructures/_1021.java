package BOJ.DataStructures;

import java.io.*;
import java.util.*;

public class _1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            while (true){
                int idx = 0;
                for (Integer integer : deque) {
                    if (integer == x) break;
                    idx++;
                }

                if(idx == 0){
                    deque.poll();
                    break;
                }else if(deque.size()/2 < idx){
                    deque.addFirst(deque.removeLast());
                    cnt++;
                }else{
                    deque.addLast(deque.removeFirst());
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
