package BOJ.DataStructures;

import java.util.Scanner;
import java.util.Stack;

public class _2504 {
    static String[] str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine().split("");

        solve();
    }

    private static void solve() {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("(") || str[i].equals("[")) stack.push(str[i]);
            else {
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                } else if (str[i].equals("]") && stack.peek().equals("(")) {
                    System.out.println(0);
                    return;
                } else if (str[i].equals(")") && stack.peek().equals("[")) {
                    System.out.println(0);
                    return;
                } else if (str[i].equals(")") && stack.peek().equals("(")) {
                    stack.pop();
                    stack.push("2");
                } else if (str[i].equals("]") && stack.peek().equals("[")) {
                    stack.pop();
                    stack.push("3");
                } else {
                    if(str[i].equals("]")){
                        int tmp = 0;
                        while (!stack.peek().equals("[")){
                            if(stack.peek().equals("(")){
                                System.out.println(0);
                                return;
                            }

                            tmp += Integer.parseInt(stack.pop());
                            if(stack.isEmpty()){
                                System.out.println(0);
                                return;
                            }
                        }
                        stack.pop();
                        stack.push(String.valueOf(tmp * 3));
                    }else{
                        int tmp = 0;
                        while (!stack.peek().equals("(")){
                            if(stack.peek().equals("[")){
                                System.out.println(0);
                                return;
                            }

                            tmp += Integer.parseInt(stack.pop());
                            if(stack.isEmpty() ){
                                System.out.println(0);
                                return;
                            }
                        }
                        stack.pop();
                        stack.push(String.valueOf(tmp * 2));
                    }
                }
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            if(stack.peek().equals("(") || stack.peek().equals("[")){
                System.out.println(0);
                return;
            }
            res += Integer.parseInt(stack.pop());
        }
        System.out.println(res);
    }
}
