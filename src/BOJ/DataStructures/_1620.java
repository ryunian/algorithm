package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String x = br.readLine();
            map.put(x,String.valueOf(i));
            map.put(String.valueOf(i), x);

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String x = br.readLine();
            sb.append(map.get(x)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
