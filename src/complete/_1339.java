package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] alpha = new int[26]; // 알파벳의 갯수
        for(int i = 0; i<n; i++){
            char[] arr  = br.readLine().toCharArray();
            for(int j = arr.length-1; j>=0; j--){
//                System.out.println(arr[j]);
                int idx = arr[j]-65;
                alpha[idx] += (int) Math.pow(10, arr.length-1-j);
//                System.out.println(alpha[idx]);
            }
        }
//        System.out.println(Arrays.toString(alpha));
        Arrays.sort(alpha);
        int result = 0;
        int num = 9;
        for(int i = alpha.length-1; i>=0; i--){
            result += alpha[i] * num;
            num--;
            if(num == -1) break;
        }
        System.out.println(result);
    }
}