package programmers.Lv2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        for (String x : record) {
            String[] str = x.split(" ");

            if (str[0].equals("Enter")) {
                queue.add(new Node(str[1], true));
                map.put(str[1], str[2]);

            } else if (str[0].equals("Leave")) {
                queue.add(new Node(str[1], false));

            } else {
                map.put(str[1], str[2]);
            }
        }

        String[] answer = new String[queue.size()];
        int idx = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            String tmp = map.get(node.id);
            if (node.isEnter) {
                answer[idx++] = String.format("%s님이 들어왔습니다.", tmp);
            } else {
                answer[idx++] = String.format("%s님이 나갔습니다.", tmp);
            }
        }

        return answer;
    }

    private class Node {
        String id;
        boolean isEnter;


        Node(String id, boolean isEnter) {
            this.id = id;
            this.isEnter = isEnter;
        }
    }
}
