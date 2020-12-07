package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095 {
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            num = new int[val+1];
            num[0] = 1;
            solve(1, val);
            System.out.println(num[val]);
        }
    }

    private static void solve(int x, int y) {
        if(x < 3) num[x] = x;
        else{
            num[x] = num[x-1] + num[x-2] + num[x-3];
        }
        if(x != y){
            solve(x+1, y);
        }
    }
}
