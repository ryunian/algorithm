package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Edge[] edge = new Edge[n+1];
        for (int i = 0; i < n; i++) {
            String[] x = br.readLine().split(" ");
            long a = Integer.parseInt(x[0]);
            long b = Integer.parseInt(x[1]);
            edge[i] = new Edge(a, b);
        }
        edge[n] = edge[0];
        double sum;
        double val= 0;
        for (int i = 0; i < n; i ++) {
            val += edge[i].x * edge[i+1].y - edge[i+1].x * edge[i].y;
        }
        sum = Math.abs(val) /2;

        System.out.printf("%.1f",sum);

    }
    private static class Edge{
        long x;
        long y;
        public Edge(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
}
