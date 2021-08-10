package programmers.Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 수식최대화 {
    public static void main(String[] args) {
        수식최대화 test = new 수식최대화();
        test.solution("100-200*300-500+20");
        test.solution("50*6-3*2");
    }

    boolean[] visit;
    long answer;

    public long solution(String expression) {
        answer = 0;
        List<String> list = parse(expression);
        visit = new boolean[3];
        for (int i = 0; i < 3; i++) {
            visit[i] = true;
            solve(i, list);
            visit[i] = false;
        }
        return answer;
    }

    private void solve(int idx, List<String> list) {
        List<String> tmp = new ArrayList<>(list);
        int i = 1;
        while (i < tmp.size()) {
            if (tmp.get(i).equals("*") && idx == 0) {
                long a = Long.parseLong(tmp.get(i - 1));
                long b = Long.parseLong(tmp.get(i + 1));
                tmp.set(--i, (a * b) + "");
                tmp.remove(i + 1);
                tmp.remove(i + 1);
            } else if (tmp.get(i).equals("+") && idx == 1) {
                long a = Long.parseLong(tmp.get(i - 1));
                long b = Long.parseLong(tmp.get(i + 1));
                tmp.set(--i, (a + b) + "");
                tmp.remove(i + 1);
                tmp.remove(i + 1);
            } else if (tmp.get(i).equals("-") && idx == 2) {
                long a = Long.parseLong(tmp.get(i - 1));
                long b = Long.parseLong(tmp.get(i + 1));
                tmp.set(--i, (a - b) + "");
                tmp.remove(i + 1);
                tmp.remove(i + 1);
            }
            i++;
        }
        if (tmp.size() == 1) {
            answer = Math.max(answer, Math.abs(Long.parseLong(tmp.get(0))));
        }

        for (int j = 0; j < 3; j++) {
            if (!visit[j]) {
                visit[j] = true;
                solve(j, tmp);
                visit[j] = false;
            }
        }
    }

    private List<String> parse(String expression) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("[\\+\\-*]");
        Matcher matcher = pattern.matcher(expression);

        int left = 0;
        while (matcher.find()) {
            list.add(expression.substring(left, matcher.start()));
            list.add(matcher.group());
            left = matcher.end();
        }
        list.add(expression.substring(left));

        return list;
    }
}
