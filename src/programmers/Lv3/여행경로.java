package programmers.Lv3;

import java.util.Arrays;
import java.util.Stack;

public class 여행경로 {
    public static void main(String[] args) {
        여행경로 test = new 여행경로();
        test.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        test.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
    }

    private int max;
    private boolean isFinish;
    private boolean[] visit;
    private String[][] tickets;

    public String[] solution(String[][] tickets) {
        max = tickets.length;
        isFinish = false;
        visit = new boolean[tickets.length];
        this.tickets = tickets;

        Arrays.sort(tickets, (o1, o2) ->
                o1[0].compareTo(o2[0]) == 0 ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]));

        Stack<String> stack = new Stack<>();
        stack.push("ICN");
        dfs(stack, 0);

//        String[] ans = stack.stream().toArray(String[]::new);
//        System.out.println(Arrays.toString(ans));
        return stack.stream().toArray(String[]::new);
    }

    private void dfs(Stack<String> stack, int cnt) {
        if (max == cnt) {
            isFinish = true;
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(stack.peek()) && !visit[i]) {
                visit[i] = true;
                stack.push(tickets[i][1]);
                dfs(stack, cnt + 1);
                if (isFinish) return;
                visit[i] = false;
            }
        }
        stack.pop();
    }
}
