package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _8980 {
    private static class Node{
        int start;
        int end;
        int box;

        public Node(int start, int end, int box) {
            this.start = start;
            this.end = end;
            this.box = box;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Node(a,b,c));
        }
        list.sort(Comparator.comparing(Node::getEnd).thenComparing(Node::getStart));

        int[] tmp = new int[n+1];
        Arrays.fill(tmp, size);

        int res = 0;
        for(Node node : list){
            int min = Integer.MAX_VALUE;
            for(int i = node.start; i < node.end ; i++){
                min = Math.min(min, tmp[i]);
            }

            if(min >= node.box){
                for(int i = node.start; i < node.end ; i++){
                    tmp[i] -= node.box;
                }
                res += node.box;
            }else{
                for(int i = node.start; i < node.end ; i++){
                    tmp[i] -= min;
                }
                res += min;
            }
        }
        System.out.println(res);
    }
}
