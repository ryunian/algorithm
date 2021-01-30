package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _15686 {
    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, res = Integer.MAX_VALUE;
    static ArrayList<Node> house, chicken;
    static boolean[] visit;

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
        visit = new boolean[chicken.size()];

        for (int i = 0; i < chicken.size(); i++) {
            // calculation 에서 true 인 것만 체크하기 떄문에 다시 false 로 초기화 해야한다.
            visit[i] = true;
            solve(i, 1);
            visit[i] = false;
        }
        System.out.println(res);
    }

    private static void solve(int idx, int cnt) {
        if (cnt > m) return;

        calculation();

        // 백트래킹을 이용하여 폐업하지 않을 치킨집 선택
        for (int i = idx + 1; i < chicken.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                solve(i, cnt + 1);
                visit[i] = false;
            }
        }
    }

    // 폐업하지 않은 치킨집과 집사이의 최소 치킨거리 계산
    private static void calculation() {
        int sum = 0;
        for (int i = 0; i < house.size(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < chicken.size(); j++) {
                if (!visit[j]) continue;
                int val = Math.abs(house.get(i).x - chicken.get(j).x)
                        + Math.abs(house.get(i).y - chicken.get(j).y);
                min = Math.min(min, val);
            }
            sum += min;
        }
        res = Math.min(res, sum);
    }
}
