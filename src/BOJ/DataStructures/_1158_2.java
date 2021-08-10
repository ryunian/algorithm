package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 요세푸스 문제
public class _1158_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()) - 1;

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = m % list.size();
        while (true) {
            sb.append(list.remove(idx) + ", ");

            if (list.isEmpty()) break;
            if (list.size() == idx) {
                idx = m % list.size();
            } else {
                idx = (idx + m) % list.size();
            }
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb.toString());
    }
}
