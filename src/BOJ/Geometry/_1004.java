package BOJ.Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            int result = 0;
            while (n-- > 0){
                boolean chk1 = false;
                boolean chk2 = false;

                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                if(Math.pow(sx - x, 2) + Math.pow(sy - y , 2) > Math.pow(r, 2)){
                    chk1 = true;
                }
                if(Math.pow(ex - x, 2) + Math.pow(ey - y , 2) > Math.pow(r, 2)){
                    chk2 = true;
                }
                // 둘 중 하나가 false 일 경우
                if(chk1 == !chk2) result++;
            }
            System.out.println(result);
        }
    }
}
