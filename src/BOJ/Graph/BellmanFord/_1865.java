package BOJ.Graph.BellmanFord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1865 {
    static int a, b, c;
    static int INF = 987654321;
    static int[] point;
    static Edge[] edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()); // 지점
            b = Integer.parseInt(st.nextToken()); // 도로
            c = Integer.parseInt(st.nextToken()); // 웜홀

            edge = new Edge[2 * b + c];
            point = new int[a + 1];

            int idx = 0;
            for (int j = 0; j < b; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                edge[idx++] = new Edge(start, end, time);
                edge[idx++] = new Edge(end, start, time);
            }
            for (int j = 0; j < c; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken()) * -1;
                edge[idx++] = new Edge(start, end, time);
            }

            boolean result = true;
            if (!bellmanFord()) {
                result = false;
            }
            System.out.println(result ? "YES" : "NO");
        }
    }

    private static boolean bellmanFord() {
        Arrays.fill(point, INF);
        point[1] = 0;
        boolean isPosible = true;
        int cnt = 0;
        while (isPosible && cnt < a) {
            isPosible = false;
            for (int j = 0; j < edge.length; j++) {
                int start = edge[j].start;
                int end = edge[j].end;
                int time = edge[j].time;
                if (point[end] > point[start] + time) {
                    point[end] = point[start] + time;
                    isPosible = true;
                }
            }
            cnt++;
        }
        return isPosible;
    }


    private static class Edge {
        int start;
        int end;
        int time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}
