package BOJ.LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _3176 {
    static int n;
    static boolean[] visit;
    static int[] deep;
    // 3차원 배열보다 min,max를 나눠주는게 메모리 사용이 적다.
    static int[][] parent, min, max;
    static ArrayList<City>[] list;
    // Stringbuilder를 안쓰면 시간초과
    static StringBuilder sb = new StringBuilder();

    private static class City {
        int point;
        int dis;

        public City(int point, int dis) {
            this.point = point;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1][21];
        min = new int[n + 1][21];
        max = new int[n + 1][21];
        deep = new int[n + 1];
        visit = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new City(b, c));
            list[b].add(new City(a, c));
        }

        findDeep(1, 0);
        makeParent();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            solve(a, b);
        }
        System.out.println(sb.toString());
    }

    private static void solve(int a, int b) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        if (deep[a] > deep[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        for (int i = 20; i >= 0; i--) {
            if (deep[b] - deep[a] >= (1 << i)) {
                minVal = Math.min(minVal, min[b][i]);
                maxVal = Math.max(maxVal, max[b][i]);
                b = parent[b][i];
            }
        }

        if (a != b) {
            for (int i = 20; i >= 0; i--) {
                if (parent[a][i] != parent[b][i]) {
                    minVal = Math.min(Math.min(minVal, min[b][i]), min[a][i]);
                    maxVal = Math.max(Math.max(maxVal, max[b][i]), max[a][i]);
                    a = parent[a][i];
                    b = parent[b][i];
                }
            }
            minVal = Math.min(Math.min(minVal, min[b][0]), min[a][0]);
            maxVal = Math.max(Math.max(maxVal, max[b][0]), max[a][0]);
        }
        sb.append(minVal+" "+maxVal+"\n");
    }

    private static void makeParent() {
        for (int j = 1; j < 21; j++) {
            for (int i = 0; i <= n; i++) {
                parent[i][j] = parent[parent[i][j - 1]][j - 1];
                min[i][j] = Math.min(min[i][j - 1], min[parent[i][j - 1]][j - 1]);
                max[i][j] = Math.max(max[i][j - 1], max[parent[i][j - 1]][j - 1]);
                // 3차원배열 사용할 시
                // parent[i][j][1] = Math.min(parent[i][j - 1][1], parent[parent[i][j - 1][0]][j - 1][1]);
                // parent[i][j][2] = Math.max(parent[i][j - 1][2], parent[parent[i][j - 1][0]][j - 1][2]);
            }
        }
    }

    private static void findDeep(int cur, int cnt) {
        visit[cur] = true;
        deep[cur] = cnt;
        for (City next : list[cur]) {
            if (!visit[next.point]) {
                parent[next.point][0] = cur;
                min[next.point][0] = next.dis;
                max[next.point][0] = next.dis;
                findDeep(next.point, cnt + 1);
            }
        }
    }
}
