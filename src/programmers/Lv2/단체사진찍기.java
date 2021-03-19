package programmers.Lv2;

import java.util.HashMap;

public class 단체사진찍기 {
    public static void main(String[] args) {
        단체사진찍기 test = new 단체사진찍기();
        test.solution(2, new String[]{"N~F=0", "R~T>2"});
    }

    char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    boolean[] visit;
    int answer;

    public int solution(int n, String[] data) {
        visit = new boolean[friends.length];
        answer = 0;

        solve("", data);

        System.out.println(answer);

        return answer;
    }

    private void solve(String str, String[] data) {
        if (str.length() == friends.length) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < friends.length; i++) {
                map.put(str.charAt(i), i);
            }

            boolean isPossible = true;

            for (String x : data) {
                int idxA = map.get(x.charAt(0));
                int idxB = map.get(x.charAt(2));
                int ab = Math.abs(idxA - idxB);
                char flag = x.charAt(3);
                int dis = x.charAt(4) - '0' + 1;

                if (flag == '=' && ab != dis) {
                    isPossible = false;
                } else if (flag == '<' && ab >= dis) {
                    isPossible = false;
                } else if (flag == '>' && ab <= dis) {
                    isPossible = false;
                }

            }
            if (isPossible) answer++;
        }

        for (int i = 0; i < friends.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                solve(str + friends[i], data);
                visit[i] = false;
            }
        }
    }
}
