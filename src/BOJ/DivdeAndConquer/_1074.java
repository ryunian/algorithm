package BOJ.DivdeAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1074 {
    static int n, m, o, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); // 행
        o = Integer.parseInt(st.nextToken()); // 열
        size = (int) Math.pow(2, n);

        solve(0, 0, size, 0);
    }

    private static void solve(int x, int y, int divSize, int cnt) {
        if (divSize == 1) {
            if (x == m && y == o) {
                System.out.println(cnt);
            }
            return;
        }

        // 분할
        int div = divSize / 2;
        int nx = div + x;
        int ny = div + y;
        // 2사분면
        if(m < nx && o < ny){
            solve(x, y, div, cnt);
        }
        // 1사분면
        else if(m < nx && o >= ny){
            solve(x, y + div, div, cnt + (div * div));
        }
        // 3사분면
        else if(m >= nx && o < ny){
            solve(x + div, y, div, cnt + (div * div)*2);
        }
        // 4사분면
        else if(m >= nx && o >= ny){
            solve(x + div, y + div, div, cnt + (div * div) * 3);
        }
    }
}
