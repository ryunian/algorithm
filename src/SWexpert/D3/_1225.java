package SWexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();
        int length = 8;

        // 테케가 몇개 나오는지 문제에 말이 없음
        String tc = "";
        while ((tc = br.readLine()) != null) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < length; i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            int cnt = 0;
            while (true) {
                int x = queue.poll() - cnt - 1;
                if (x <= 0) break;

                queue.add(x);
                cnt++;
                cnt %= 5;
            }

            sb.append("#" + tc + " ");
            while (!queue.isEmpty()) {
                sb.append(queue.poll() + " ");
            }
            sb.append("0\n");
        }
        System.out.print(sb.toString());
    }
}
