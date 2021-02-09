package programmers.etc;

import java.util.Arrays;
import java.util.Stack;

class TopInfo{
    int idx;
    int height;

    public TopInfo(int idx, int height){
        this.idx = idx;
        this.height = height;
    }
}

public class 탑 {
    public int[] solution(int[] heights) {
        /*int[] answer = new int[heights.length];

        for(int i=0; i<heights.length;i++){
            for(int j=i-1; j>=0;j--){
                if(heights[i]<heights[j]){
                    answer[i] = j+1;
                    break;
                }
            }
        }
        return answer;*/

        Stack<TopInfo> stack = new Stack<>();
        int[] answer = new int[heights.length];

        for(int i=0; i<heights.length;i++){
            TopInfo topInfo = new TopInfo(i+1,heights[i]);
            int receive = 0;
            while(!stack.isEmpty()){
                if(stack.peek().height > topInfo.height){
                    receive = stack.peek().idx;
                    break;
                }
                stack.pop();
            }
            stack.push(topInfo);
            answer[i] = receive;
        }
        return answer;
    }

    public static void main(String[] args) {
        탑 test = new 탑();
        int[] heights = {6,9,5,7,4}; // 0 0 2 2 4
//        int[] heights = {3,9,9,3,5,7,6}; // 0 0 0 3 3 3 6
        heights = test.solution(heights);
        System.out.println(Arrays.toString(heights));
    }
}
