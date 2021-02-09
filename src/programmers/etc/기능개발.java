package programmers.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class ProgressInfo{
    int progresse;
    int speed;

    public ProgressInfo(int progresse, int speed){
        this.progresse = progresse;
        this.speed = speed;
    }

}

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<ProgressInfo> queue = new LinkedList();
        for(int i=0; i<progresses.length;i++){
            ProgressInfo info = new ProgressInfo(progresses[i],speeds[i]);
            queue.add(info);
        }
        int time = 1;
        int result = 0;
        ArrayList<Integer> list = new ArrayList();
        while(!queue.isEmpty()){
            if(queue.peek().progresse + (queue.peek().speed * time) >=100){
                queue.poll();
                result++;
            }else{
                if(result>0) list.add(result);
                result = 0;
                time++;
            }
        }
        if(result>0) list.add(result);

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};

        기능개발 main = new 기능개발();
        int[] result = main.solution(progresses, speeds);
        System.out.println(Arrays.toString(result)); // 2,1
    }
}
