package programmers.Lv2;

import java.util.*;

public class 튜플 {
    public static void main(String[] args) {
        튜플 test = new 튜플();
        test.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }
    public int[] solution(String s) {
        s = s.replace("{","").replace("}","");

        String[] arr = s.split(",");
        Map<String, Integer> map = new HashMap<>();
        for(String word : arr){
            if(map.get(word) == null){
                map.put(word, 0);
            }else{
                map.computeIfPresent(word, ((String key, Integer value) -> ++value));
            }
        }
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o2.y- o1.y);
        for (String str : map.keySet()) {
            queue.add(new Node(Integer.parseInt(str), map.get(str)));
        }
        int[] res = new int[queue.size()];
        int idx = 0;
        while (!queue.isEmpty()) {
            res[idx++] = queue.poll().x;
        }

        return res;
    }
    private class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
