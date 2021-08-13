package programmers.Lv2;

import java.util.ArrayList;
import java.util.Stack;

public class N진수게임 {
    public static void main(String[] args) {
        N진수게임 test = new N진수게임();
        test.solution(2, 4, 2, 1);
        test.solution(16, 16, 2, 1);
        test.solution(16, 16, 2, 2);
    }

    ArrayList<Character> list;
    char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public String solution(int n, int t, int m, int p) {
        list = new ArrayList<>();
        list.add('0');
        solve(n, t * m);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int idx = p - 1;
        while (cnt < t) {
            sb.append(list.get(idx));
            idx += m;
            cnt++;
        }
        return sb.toString();
    }

    private void solve(int radix, int limit) {
        Stack<Character> stack = new Stack<>();
        int num = 0;
        while (list.size() <= limit) {
            int x = num;
            while (x > 0) {
                int tmp = x % radix;
                stack.push(arr[tmp]);
                x /= radix;
            }
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            num++;
        }
    }
}
