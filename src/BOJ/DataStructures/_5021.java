package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _5021 {
    static double tmp = 0;
    static String first;
    static Map<String, List<String>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        first = br.readLine();
        map = new HashMap<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();
            map.put(a, new ArrayList<>(Arrays.asList(new String[]{b, c})));
        }
        double max = 0;
        String res = "";
        while (m-- > 0) {
            String str = br.readLine();
            tmp = 0;
            solve(str, 0);
            if (tmp > max) {
                max = tmp;
                res = str;
            }
        }
        System.out.println(res);
    }

    private static void solve(String str, int cnt) {
        if (str.equals(first)) {
            double x = 1 << cnt;
            tmp += 1/x;
            return;
        }
        if (map.get(str) != null) {
            List<String> list = map.get(str);
            solve(list.get(0), cnt + 1);
            solve(list.get(1), cnt + 1);
        }
    }
}
