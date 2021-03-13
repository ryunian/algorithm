package programmers.Lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    public static void main(String[] args) {
        단어변환 test = new 단어변환();
        test.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        test.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});
    }

    public int solution(String begin, String target, String[] words) {
        boolean[] visit = new boolean[words.length];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(begin)) visit[i] = true;
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.str.equals(target)) {
                System.out.println(cur.cnt);
                return cur.cnt;
            }
            for (int i = 0; i < words.length; i++) {
                if (visit[i]) continue;

                int diffCnt = 0;
                for (int j = 0; j < cur.str.length(); j++) {
                    if (cur.str.charAt(j) != words[i].charAt(j)) diffCnt++;
                }
                if (diffCnt == 1) {
                    queue.add(new Node(words[i], cur.cnt + 1));
                    visit[i] = true;
                }
            }
        }
        System.out.println("not found");
        return 0;
    }

    private class Node {
        String str;
        int cnt;

        public Node(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
}
