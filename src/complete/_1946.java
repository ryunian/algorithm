package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _1946 {
    public static void main(String[] args) throws IOException {
        // Scanner 를 사용할경우 시간차이가 크다
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            int[] arr = new int[x+1];
            for (int j = 0; j < x; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int seq = Integer.parseInt(st.nextToken());
                arr[seq] = Integer.parseInt(st.nextToken());
            }
            int cnt = 1;
            int prev = arr[1];
            for (int k = 2; k < arr.length; k++) {
                if(prev > arr[k]){
                    cnt++;
                    prev = arr[k];
                }
            }
            System.out.println(cnt);
        }
    }
}

/*
1
7
3 6
7 3
4 2
1 4
5 7
2 5
6 1
*/
