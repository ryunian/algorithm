package programmers.Lv2;

import java.util.LinkedList;
import java.util.Stack;

public class 괄호회전하기 {
    public static void main(String[] args) {
        괄호회전하기 test = new 괄호회전하기();
        test.solution("[](){}");
        test.solution("}]()[{");
        test.solution("[)(]");
        test.solution("}}}");
    }

    LinkedList<Character> list;

    // 시간복잡도를 더 줄이는 방법
    // 기본상태를 체크하고, 위치/완성갯수/현재갯수에 대한 정보를 저장
    // 회전 할때마다, 회전된 부분만 체크한다.
    public int solution(String s) {
        list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }

        int size = s.length();
        int answer = 0;
        for (int i = 0; i < size; i++) {
            char c = list.get(size - 1);
            if (c != '[' && c != '{' && c != '(' && check()) {
                answer++;
            }
            list.add(list.removeFirst());
        }
        return answer;
    }

    private boolean check() {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '[' && c == ']') {
                        stack.pop();
                    } else if (stack.peek() == '(' && c == ')') {
                        stack.pop();
                    } else if (stack.peek() == '{' && c == '}') {
                        stack.pop();
                    }
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
