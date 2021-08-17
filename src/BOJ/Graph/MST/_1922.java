package BOJ.Graph.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

// 네트워크 연결
public class _1922 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Node(a,b,c));
        }
        list.sort(Comparator.comparing(o -> o.cost));

        int sum = 0;
        for(Node node : list){
            sum += union(node.prev, node.next, node.cost);
        }
        System.out.println(sum);
    }
    public static int find(int x){
        if(arr[x] == x){
            return arr[x];
        }

        return arr[x] = find(arr[x]);
    }
    public static int union(int x, int y, int cost){
        x = find(x);
        y = find(y);

        if(x != y){
            arr[x] = y;
            return cost;
        }
        return 0;
    }

    static class Node{
        int prev;
        int next;
        int cost;

        public Node(int prev, int next, int cost) {
            this.prev = prev;
            this.next = next;
            this.cost = cost;
        }
    }
}
