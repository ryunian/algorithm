package BOJ.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _4195 {
    static HashMap<String, Integer> map;
    static int[] arr, level;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            arr = new int[n * 2];
            level = new int[n * 2];
            sb = new StringBuilder();
            for (int i = 0; i < n * 2; i++) {
                arr[i] = i;
                level[i] = 1;
            }
            int idx = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                map.putIfAbsent(a, map.size());
                map.putIfAbsent(b, map.size());

                union(map.get(a), map.get(b));
                System.out.println(map);
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(level));
            }
            System.out.print(sb.toString());
        }
    }

    private static int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        return arr[x] = find(arr[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            arr[y] = x;
            level[x] += level[y];
            level[y] = 1;
        }

        sb.append(level[x]).append("\n");
    }
}
