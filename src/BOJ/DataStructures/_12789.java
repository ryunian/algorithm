package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _12789 {
    static Queue<Integer> queue = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();
    static boolean isPossible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (n-- > 0) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        solve(1);
        if(isPossible){
            System.out.println("Nice");
        }else{
            System.out.println("Sad");
        }
    }



    private static void solve(int count) {
        if (queue.isEmpty() && stack.isEmpty()) {
            isPossible = true;
            return;
        }
        if (!queue.isEmpty() && queue.peek() == count) {
            queue.poll();
            solve(count + 1);
        } else if (!stack.isEmpty() && stack.peek() == count) {
            stack.pop();
            solve(count + 1);
        } else if (!queue.isEmpty()) {
            stack.push(queue.poll());
            solve(count);
        }
    }
}
