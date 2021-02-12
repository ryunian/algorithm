package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2346 {
    static int n, visit = 1001;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int point = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(point + " ");
            int num = arr[point];
            arr[point] = visit;
            if(i != n-1){
                point = shift(point, num);
            }
        }
        System.out.println(sb.toString());
    }

    private static int shift(int point, int num) {
        if(num > 0){
            while (num > 0){
                point = point == n ? 1 : point+1;
                if(arr[point] != visit){
                    num--;
                }
            }
        }else{
            num *= -1;
            while (num > 0) {
                point = point == 1 ? n : point - 1;
                if (arr[point] != visit) {
                    num--;
                }
            }
        }
        return point;
    }
}
