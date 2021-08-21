package BOJ.Graph.Bfs;

import java.io.*;
import java.util.*;

// 최소 환승 경로
public class _2021 {
    static int n, m, start, end, res = -1;
    static List<Integer>[] routeList, stationList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        routeList = new LinkedList[m + 1];
        for (int i = 1; i <= m; i++) {
            routeList[i] = new LinkedList<>();
        }
        stationList = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            stationList[i] = new LinkedList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            while (true) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == -1) break;
                routeList[i].add(tmp);
                stationList[tmp].add(i);
            }
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        if(start == end){
            res = 0;
        }else {
            solve();
        }
        System.out.println(res);
    }
    private static void solve() {
        boolean[] visitRt = new boolean[m + 1];
        boolean[] visitSt = new boolean[n + 1];
        visitSt[start] = true;

        Queue<Node> queue = new LinkedList<>();
        for(int route : stationList[start]){
            queue.add(new Node(route, 0));
            visitRt[route] = true;
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int nextStation : routeList[cur.route]) {
                if (visitSt[nextStation]) continue;
                visitSt[nextStation] = true;

                if (nextStation == end) {
                    res = cur.cnt;
                    return;
                }
                for (int nextRoute : stationList[nextStation]) {
                    if (!visitRt[nextRoute]) {
                        visitRt[nextRoute] = true;
                        queue.add(new Node(nextRoute, cur.cnt + 1));
                    }
                }
            }
        }
    }

    static class Node {
        int route, cnt;

        public Node(int route, int cnt) {
            this.route = route;
            this.cnt = cnt;
        }
    }
}