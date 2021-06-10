package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class _18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }


        Deque<Integer> deque = new LinkedList<>();
        int num = 1;
        while (!stack.isEmpty()){
            int x = stack.pop();
            switch (x){
                case 1:
                    deque.addFirst(num++);
                    break;
                case 2:
                    int tmp = deque.pollFirst();
                    deque.addFirst(num++);
                    deque.addFirst(tmp);
                    break;
                case 3:
                    deque.addLast(num++);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int x : deque){
            sb.append(x+" ");
        }
        System.out.println(sb.toString());
    }
}
