package programmers.Lv2;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        /*for(int i=0; i<prices.length-1;i++){
            int x = 0;
            for(int j=i+1; j<prices.length;j++){
                x++;
                if(prices[i]>prices[j]){
                    break;
                }
            }
            answer[i] = x;
        }*/

        Stack<Integer> beginIdxs = new Stack<>();
        // 이전값을 비교해야되기 때문에 첫번째 값 삽입
        beginIdxs.push(0);
        // 현재값이 이전값보다 낮아질경우만 체크해서 배열에 삽입 (반복)
        for (int i=1; i<prices.length; i++) {
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                answer[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);
        }
        // 배열에 삽입이 안된곳 삽입
        int i = prices.length;
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            answer[beginIdx] = i - beginIdx - 1;
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        주식가격 main = new 주식가격();
        int[] result = main.solution(prices);
        System.out.println(Arrays.toString(result));
    }
}
