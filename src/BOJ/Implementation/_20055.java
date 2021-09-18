package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 컨베이어 벨트 위의 로봇
public class _20055 {
    static int n, k;
    static ArrayList<Integer> list;
    static ArrayList<Integer> robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        robot = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        solve();
    }

    private static void solve() {
        int level = 1;
        while (true) {
            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            moveAll();
            // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
            //    만약 이동할 수 없다면 가만히 있는다.
            //    로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
            moveRobot();
            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            setRobot();
            // 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            int cnt = 0;
            for (int x : list) {
                if (x == 0) cnt++;
            }
            if (cnt >= k) {
                break;
            }
            level++;
        }
        System.out.println(level);
    }

    private static void setRobot() {
        if (list.get(0) > 0) {
            robot.add(0);
            list.set(0, list.get(0) - 1);
        }
    }

    private static void moveRobot() {
        for (int i = 0; i < robot.size(); i++) {
            int next = robot.get(i) + 1;
            boolean isok = true;
            for (int val : robot) {
                if (next == val) {
                    isok = false;
                    break;
                }
            }
            if (!isok) continue;
            if (list.get(next) < 1) continue;
            list.set(next, list.get(next) - 1);
            if (next == n - 1) {
                robot.remove(i--);
            } else {
                robot.set(i, next);
            }
        }
    }

    private static void moveAll() {
        int tmp = list.get(2 * n - 1);
        for (int i = list.size() - 1; i > 0; i--) {
            list.set(i, list.get(i - 1));
        }
        list.set(0, tmp);

        for (int i = 0; i < robot.size(); i++) {
            int next = robot.get(i) + 1;

            if (next == n - 1) {
                robot.remove(i--);
            } else {
                robot.set(i, next);
            }
        }
    }
}
