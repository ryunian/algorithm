package programmers.Lv2;

import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {
        올바른괄호 test = new 올바른괄호();
        test.solution("()()");
        test.solution(")()(");
    }

    boolean solution(String s) {
        if (s.length() == 0) return true;
        if (s.charAt(0) == ')') return false;

        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x == '(') stack.push(x);
            else {
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
            }
        }
        System.out.println(stack.isEmpty());

        return stack.isEmpty();
    }
}
