package programmers.Lv1;

import java.util.*;


public class 나누어떨어지는숫자배열 {
    public static void main(String[] args) {
        나누어떨어지는숫자배열 test = new 나누어떨어지는숫자배열();
        int[] x = test.solution(new int[]{5,9,7,10},5);
        System.out.println(Arrays.toString(x));
    }

    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            if(i % divisor == 0){
                list.add(i);
            }
        }
        if(list.size() == 0) return new int[]{-1};

        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
