package BOJ.Graph.MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _4386 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        double[][] star = new double[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            star[i][0] = Double.parseDouble(st.nextToken());
            star[i][1] = Double.parseDouble(st.nextToken());
        }


        arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double x = Math.pow(Math.abs(star[i][0] - star[j][0]), 2);
                double y = Math.pow(Math.abs(star[i][1] - star[j][1]), 2);
                double insert = Math.sqrt(x + y);
                list.add(new Node(i+1, j+1, insert));
            }
        }
        list.sort(Comparator.comparing(x -> x.cost));

        double res = 0;
        for(Node node : list){
            if(union(node.start, node.end)){
                res += node.cost;
            }
        }
        System.out.println(String.format("%.2f", res));

    }

    public static int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        return arr[x] = find(arr[x]);
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y){
            return false;
        }else{
            arr[x] = y;
            return true;
        }
    }

    private static class Node {
        int start;
        int end;
        double cost;

        public Node(int start, int end, double cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

    }
}
