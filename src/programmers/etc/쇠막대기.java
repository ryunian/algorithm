package programmers.etc;

import java.util.Stack;

public class 쇠막대기 {
    public int solution(String arrangement) {
        int answer = 0;
        String[] arr = arrangement.split("");
        Stack<String> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("(")){
                stack.add(arr[i]);
            }else if(arr[i].equals(")") && arr[i-1].equals("(")){
                stack.pop();
                answer += stack.size();
//                System.out.println(stack.size());
            }else if(arr[i].equals(")") && arr[i-1].equals(")")){
                stack.pop();
                answer++;
//                System.out.println(1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";

        쇠막대기 main = new 쇠막대기();
        int result = main.solution(arrangement);
        System.out.println(result); // 17
    }
}
