package programmers.Lv2;

import java.util.Comparator;
import java.util.LinkedList;

public class 복서정렬하기 {
    public static void main(String[] args) {
        복서정렬하기 test = new 복서정렬하기();
        test.solution(new int[]{50, 82, 75, 120}, new String[]{"NLWL", "WNLL", "LWNW", "WWLN"});
    }

    public int[] solution(int[] weights, String[] head2head) {
        LinkedList<Node> list = new LinkedList<>();
        for (int i = 0; i < head2head.length; i++) {
            String str = head2head[i];
            double win = 0;
            int winThenW = 0;
            int sum = 0;
            for (int j = 0; j < str.length(); j++) {
                if (i == j) continue;
                char c = str.charAt(j);
                if (c == 'W') {
                    win++;
                    winThenW += weights[i] < weights[j] ? 1 : 0;
                    sum++;
                } else if (c == 'L') {
                    sum++;
                }
            }
            double rate = sum == 0 ? 0 : win / sum;
            list.add(new Node(i + 1, rate, winThenW, weights[i]));
        }

        list.sort(Comparator.comparing(Node::getRate, Comparator.reverseOrder())
                .thenComparing(Node::getWinThenW, Comparator.reverseOrder())
                .thenComparing(Node::getWeight, Comparator.reverseOrder())
                .thenComparing(Node::getIdx));

        int[] answer = new int[list.size()];
        int i = 0;
        for (Node node : list) {
            answer[i++] = node.idx;
        }
        return answer;
    }

    class Node {
        int idx;
        double rate;
        int winThenW;
        int weight;

        public Node(int idx, double rate, int winThenW, int weight) {
            this.idx = idx;
            this.rate = rate;
            this.winThenW = winThenW;
            this.weight = weight;
        }

        public int getIdx() {return idx;}
        public double getRate() {return rate;}
        public int getWinThenW() {return winThenW;}
        public int getWeight() {return weight;}
    }
}
