package programmers.Lv1;

import java.util.*;

public class 같은숫자는싫어 {
    public static void main(String[] args) {
        같은숫자는싫어 test = new 같은숫자는싫어();
        test.solution(new int[]{1,1,3,3,0,1,1});
        test.solution(new int[]{4,4,4,3,3});
    }
    public int[] solution(int []arr) {
        if(arr.length == 0) return new int[]{};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] != arr[i]){
                list.add(arr[i]);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
