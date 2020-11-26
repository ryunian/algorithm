package BOJ.DataStructures;

import java.util.Scanner;
import java.util.Stack;

public class _10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] x = sc.nextLine().split(" ");
            switch (x[0]){
                case "push" :
                    stack.push(Integer.parseInt(x[1]));
                    break;
                case "pop" :
                    sb.append(stack.isEmpty() ? -1 : stack.pop());
                    break;
                case "size" :
                    sb.append(stack.size());
                    break;
                case "empty" :
                    sb.append(stack.isEmpty() ? 1 : 0);
                    break;
                case "top" :
                    sb.append(stack.isEmpty() ? -1 : stack.peek());
                    break;
            }
            if(!x[0].equals("push")) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
