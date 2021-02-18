package programmers;

import java.util.ArrayList;
import java.util.Comparator;

public class 추석트래픽 {
    public static void main(String[] args) {
        추석트래픽 test = new 추석트래픽();
        test.solution(new String[]
                {"2016-09-15 01:00:04.001 2.0s",
                        "2016-09-15 01:00:07.000 2s"});
        test.solution(new String[]
                {"2016-09-15 01:00:04.002 2.0s",
                        "2016-09-15 01:00:07.000 2s"});
        test.solution(new String[]
                {
                        "2016-09-15 20:59:57.421 0.351s",
                        "2016-09-15 20:59:58.233 1.181s",
                        "2016-09-15 20:59:58.299 0.8s",
                        "2016-09-15 20:59:58.688 1.041s",
                        "2016-09-15 20:59:59.591 1.412s",
                        "2016-09-15 21:00:00.464 1.466s",
                        "2016-09-15 21:00:00.741 1.581s",
                        "2016-09-15 21:00:00.748 2.31s",
                        "2016-09-15 21:00:00.966 0.381s",
                        "2016-09-15 21:00:02.066 2.62s"
                });
        System.out.println(test.solution(new String[]{"2016-09-15 00:00:00.000 3s"}));
    }

    public int solution(String[] lines) {
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            String[] str = lines[i].replace("s", "").split(" ");
            String[] times = str[1].split(":");
            // 끝난시간
            float x = Float.parseFloat(times[0]) * 3600 + Float.parseFloat(times[1]) * 60 + Float.parseFloat(times[2]);
            // 걸린시간
            float y = Float.parseFloat(str[2]);
            // 시작시간
            float z = x - y + (float) 0.001;
            list.add(new Node(z, x));
        }
        list.sort(Comparator.comparing(Node::getEnd).thenComparing(Node::getStart));
        int answer = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            float time = list.get(i).end + (float) 0.999;
            int cnt = 0;
            for (int j = i; j < list.size(); j++) {
                if (list.get(j).start <= time) {
                    cnt++;
                } else {
                    break;
                }
            }
            answer = Math.max(cnt, answer);
        }
        return answer;
    }

    private static class Node {
        float start;
        float end;

        public Node(float start, float end) {
            this.start = start;
            this.end = end;
        }

        public float getStart() {
            return start;
        }

        public float getEnd() {
            return end;
        }
    }
}
