package programmers.etc;

import java.util.*;

class PrintInfo {
    int priorities;
    int idx;

    public PrintInfo(int priorities, int idx) {
        this.priorities = priorities;
        this.idx = idx;
    }
}

public class 프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<PrintInfo> queue = new LinkedList();
        for(int i=0; i<priorities.length;i++){
            PrintInfo info = new PrintInfo(priorities[i],i);
            queue.add(info);
        }
        Arrays.sort(priorities);
        int idx = priorities.length-1;
        int n = 1;
        while(!queue.isEmpty()){
            PrintInfo x = queue.poll();
            if(x.priorities != priorities[idx]){
                queue.add(x);
            }else{
                if(x.idx == location){
                    answer = n;
                    break;
                }
                idx--;
                n++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//        int[] priorities = {2, 1, 3, 2};
        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int location = 2;
        int location = 0;
        프린터 main = new 프린터();
        int result = main.solution(priorities, location);
        System.out.println(result); // 1 // 5
    }
}
