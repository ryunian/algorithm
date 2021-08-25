package SWEA.D3;

import java.util.Scanner;

// 문제 제목 붙이기
public class _7087 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[] arr = new int[26];
            for (int i = 0; i < n; i++) {
                char c = sc.next().charAt(0);
                arr[c - 'A']++;
            }

            int i = 0;
            while (i < 26){
                if(arr[i] == 0) break;
                i++;
            }
            System.out.printf("#%d %d\n", tc, i);
        }
    }
}
