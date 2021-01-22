package programmers;

import java.util.LinkedList;
import java.util.Queue;

class QueueInfo{
    int weight;
    int time;

    public QueueInfo(int weight, int time){
        this.weight = weight;
        this.time = time;
    }
}

public class TruckPassBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<QueueInfo> queue = new LinkedList<>();

        // 들어가야할 트럭
        int i = 0;
        // 큐에 들어간 무게
        int in = 0;
        for(int time=1;;time++){
            // 시간이 경과되서 큐에서 삭제
            if(!queue.isEmpty() && time - queue.peek().time == bridge_length){
                // 큐에 들어가 있는 무게 삭제
                in -= queue.peek().weight;
                // 큐에 들어가 있는 트럭 삭제
                queue.poll();
            }
            // 큐에 삽입
            if(i < truck_weights.length && in+truck_weights[i]<=weight){
                // 큐에 트럭과 들어간 시간 삽입
                QueueInfo queueInfo = new QueueInfo(truck_weights[i], time);
                queue.add(queueInfo);
                // 큐에 들어간 총 무게
                in += truck_weights[i];
                // 다음 트럭 선택
                i++;
            }
            // 넣을것도 없고, 큐에도 없을 경우
            if(i==truck_weights.length && queue.isEmpty()){
                answer = time;
                break;
            }
//            System.out.println("time = "+time+" in =  "+in);
        }
        return answer;
    }

    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        TruckPassBridge main = new TruckPassBridge();
        int x = main.solution(bridge_length,weight,truck_weights);
        System.out.println(x); // 8
    }
}
