package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 치킨배달
public class _15686_2 {
    static int INF = 987654321;
    static int n, m, res = INF;
    static ArrayList<Node> house, chicken;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    house.add(new Node(i, j));
                } else if (x == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }
        visit = new int[m];
        solve(0, 0);
        System.out.println(res);
    }

    private static void solve(int idx, int cnt) {
        if (cnt == m) {
            calcu();
            return;
        }
        if (idx == chicken.size()) return;

        visit[cnt] = idx;
        solve(idx + 1, cnt + 1);
        solve(idx + 1, cnt);
    }


    private static void calcu() {
        int sum = 0;
        for (int i = 0; i < house.size(); i++) {
            int tmp = INF;
            for (int j = 0; j < m; j++) {
                int valX = Math.abs(chicken.get(visit[j]).x - house.get(i).x);
                int valY = Math.abs(chicken.get(visit[j]).y - house.get(i).y);
                tmp = Math.min(tmp, valX + valY);
            }
            sum += tmp;
        }
        res = Math.min(sum, res);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
