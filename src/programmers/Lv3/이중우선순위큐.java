package programmers.Lv3;

import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        이중우선순위큐 test = new 이중우선순위큐();
        test.solution(new String[]{"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"});
    }

    public int[] solution(String[] operations) {
        int insertCnt = 0;
        int deleteCnt = 0;

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i = 0; i < operations.length; i++) {
            String[] str = operations[i].split(" ");
            int value = Integer.parseInt(str[1]);
            if (str[0].equals("I")) {
                insertCnt++;
                min.add(value);
                max.add(value);
            }
            else if(min.isEmpty() && max.isEmpty()){
                continue;
            }
            else if (str[0].equals("D") && value == 1) {
                deleteCnt++;
                max.poll();
            } else if (str[0].equals("D") && value == -1) {
                deleteCnt++;
                min.poll();
            }

            if (insertCnt == deleteCnt) {
                min.clear();
                max.clear();
                insertCnt = 0;
                deleteCnt = 0;
            }

        }
        if(insertCnt <= deleteCnt){
            return new int[]{0,0};
        }else{
            return new int[]{max.peek(), min.peek()};
        }
    }
}
