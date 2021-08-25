package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 딱지놀이
public class _14696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int[] userA = new int[5];
            int[] userB = new int[5];
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                userA[Integer.parseInt(st.nextToken())]++;
            }
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for (int j = 0; j < b; j++) {
                userB[Integer.parseInt(st.nextToken())]++;
            }

            int flag = -1;
            for (int j = 4; j > 0; j--) {
                if (userA[j] > userB[j]) {
                    flag = 0;
                    break;
                } else if (userA[j] < userB[j]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                sb.append("A\n");
            } else if (flag == 1) {
                sb.append("B\n");
            } else {
                sb.append("D\n");
            }
        }
        System.out.print(sb.toString());
    }
}
