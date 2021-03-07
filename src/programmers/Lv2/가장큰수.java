package programmers.Lv2;

import java.util.Arrays;

public class 가장큰수 {
    public static void main(String[] args) {
        가장큰수 test = new 가장큰수();
//        test.solution(new int[]{6, 10, 2});
//        test.solution(new int[]{3, 30, 34, 5, 9});
//        test.solution(new int[]{987, 9, 98, 981});
        test.solution(new int[]{0, 0, 0, 0});
    }

    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = "" + numbers[i] + numbers[i] + numbers[i];
        }
        Arrays.sort(arr);

        boolean isZero = true;
        for (int i = arr.length-1; i >= 0 ; i--) {
            if(isZero && arr[i].equals("000")){
                continue;
            }
            else{
                isZero = false;
            }
            sb.append(arr[i].substring(0, arr[i].length()/3));
        }
        System.out.println(sb.toString());

        return sb.length()== 0 ? "0" : sb.toString();
    }
}
