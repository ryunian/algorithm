package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _1931 {
    public static void main(String[] args) throws IOException {
        /*Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[][] arr = new int[cnt][2];
        for (int i = 0; i < cnt; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[][] arr = new int[cnt][2];
        for(int i =0 ; i<cnt ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()){
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);

                }
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int result = 0;
        int end = -1;
        for (int i = 0; i < cnt; i++) {
            if (arr[i][0] >= end) {
                end = arr[i][1];
                result++;
            }
        }
        System.out.println(result);
    }
}
