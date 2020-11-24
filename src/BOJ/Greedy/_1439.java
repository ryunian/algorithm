package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
//        System.out.println(Arrays.toString(arr));
        int[] check = new int[2];

        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(check));
            if(i == arr.length-1){
                check[arr[i]-'0']++;
                break;
            }
//            int x = arr[i] - '0';
//            System.out.println(x);
            if(arr[i] != arr[i+1]){
                check[arr[i]-'0']++;
            }
        }

//        System.out.println(Arrays.toString(check));
        System.out.println(Math.min(check[0], check[1]));
    }
}
