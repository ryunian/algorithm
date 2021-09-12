package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

// 빙고
public class _2578 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = 5;
        HashMap<Integer, Node> map = new HashMap<>();
        ArrayList<Integer>[] list = new ArrayList[n * 2 + 2];
        for (int i = 0; i < n * 2 + 2; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                int a = i;
                int b = j + n;
                int c = -1;
                int d = -1;
                list[a].add(num);
                list[b].add(num);
                if (i == j) {
                    c = n * 2;
                    list[c].add(num);
                }
                if (i + j == 4) {
                    d = n * 2 + 1;
                    list[d].add(num);
                }
                map.put(num, new Node(a, b, c, d));
            }
        }
        int num = 0;
        loop:
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                num++;
                Node node = map.get(x);
                list[node.a].remove((Integer) x);
                list[node.b].remove((Integer) x);
                if (node.c != -1) list[node.c].remove((Integer) x);
                if (node.d != -1) list[node.d].remove((Integer) x);

                int cnt = 0;
                for (ArrayList tmp : list) {
                    if (tmp.isEmpty()) cnt++;
                }
                if (cnt >= 3) break loop;
            }
        }
        System.out.println(num);
    }

    static class Node {
        // 가로 세로 대각선
        int a, b, c, d;

        public Node(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
}