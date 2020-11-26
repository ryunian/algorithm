package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");

            Queue<print> queue = new LinkedList<>();
            List<Integer> list = new LinkedList<>();

            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                queue.add(new print(j, value));
                list.add(value);
            }
            list.sort(Collections.reverseOrder());

            int k = 0;
            loop:
            while(!queue.isEmpty()){
                print value = queue.poll();
                if(value.priority == list.get(k)){
                    k++;
                    if(value.num == m){
                        System.out.println(k);
                        break loop;
                    }
                }else{
                    queue.add(value);
                }
            }
        }
    }
    private static class print{

        int num;
        int priority;

        public print(int num, int priority){
            this.num = num;
            this.priority = priority;
        }
    }
}
