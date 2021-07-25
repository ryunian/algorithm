package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1525 {
    static int n;
    static int[] didx = {-1,1,-3,3};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < 3; j ++) {
                if (tmp[j].equals("0")) {
                    n = idx;
                }
                sb.append(tmp[j]);
                idx++;
            }
        }
        solve(sb);

    }

    private static void solve(StringBuilder sb) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, sb.toString(), 0));
        Set<String> set = new HashSet<>();
        set.add(sb.toString());
        String target = "123456780";

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.str.equals(target)){
                System.out.println(cur.cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nIdx = cur.idx + didx[i];

                if(nIdx < 0 || nIdx >= 9) continue;
                if(cur.idx % 3 == 0 && i == 0) continue;
                if(cur.idx % 3 == 2 && i == 1) continue;

                char[] tmp = cur.str.toCharArray();
                tmp[cur.idx] = tmp[nIdx];
                tmp[nIdx] = '0';
                String str = new String(tmp);

                if(!set.contains(str)){
                    set.add(str);
                    queue.add(new Node(nIdx, str, cur.cnt + 1));
                }
            }
        }
        System.out.println(-1);
    }


    static class Node{
        int idx;
        String str;
        int cnt;

        public Node(int idx, String str, int cnt) {
            this.idx = idx;
            this.str = str;
            this.cnt = cnt;
        }
    }
}