package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _22235 {
    private static int INF = 987654321;
    private static Map<Integer, Integer> map = initMap();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Node> list = new ArrayList<>();
        int start = dateToSec(br.readLine());
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Node(st.nextToken(), st.nextToken(), st.nextToken()));
        }

        int[] station = {225, 233, 246, 258, 272};
        int res = INF;
        int prev = start;

        for (int i = 1; i < station.length; i++) {
            res = INF;
            for (Node next : list) {
                if (next.arr[station[i - 1]] == INF) continue;
                if (next.arr[station[i - 1]] <= prev) continue;
                res = Math.min(res, next.arr[station[i]]);
            }
            res -= 20;
            prev = res;
        }

        if (res == INF || res >= 3600 * 24) {
            System.out.println(-1);
        } else {
            secTodate(res);
        }
    }

    private static class Node {
        int[] arr;
        int startPoint;
        int endPoint;
        int time;

        public Node(String startPoint, String endPoint, String time) {
            this.startPoint = Integer.parseInt(startPoint.substring(1));
            this.endPoint = Integer.parseInt(endPoint.substring(1));
            this.time = dateToSec(time);
            this.arr = new int[272 + 1];

            Arrays.fill(arr, INF);
            arr[this.startPoint] = this.time;

            for (int i = this.startPoint + 1; i <= this.endPoint; i++) {
                arr[i] = arr[i - 1] + map.getOrDefault(i - 1, 2) * 60 + 20;
            }
        }
    }

    private static Map<Integer, Integer> initMap() {
        Map<Integer, Integer> ret = new HashMap<>();
        ret.put(210, 3);        ret.put(220, 4);
        ret.put(221, 4);        ret.put(222, 3);
        ret.put(225, 3);        ret.put(238, 3);
        ret.put(245, 4);        ret.put(247, 5);
        ret.put(249, 4);        ret.put(250, 3);
        ret.put(256, 3);        ret.put(266, 3);
        return ret;
    }

    private static int dateToSec(String s) {
        String[] str = s.split(":");
        int ret = 0;
        int time = 3600;
        for (int i = 0; i < str.length; i++) {
            ret += Integer.parseInt(str[i]) * time;
            time /= 60;
        }
        return ret;
    }

    private static void secTodate(int sec) {
        int x = sec / 3600;
        sec %= 3600;
        int y = sec / 60;
        sec %= 60;
        int z = sec;
        System.out.printf("%02d:%02d:%02d", x, y, z);
    }
}
