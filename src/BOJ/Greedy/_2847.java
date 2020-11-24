package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int score = 0;
        for (int i = n-2; i >= 0; i--) {
            if(arr[i] >= arr[i+1]){
                int x = arr[i];
                arr[i] = arr[i+1]-1;
                score += x - arr[i];
            }
        }
        System.out.println(score);
    }
}
