package BOJ.Graph.SCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 도미노
public class _4196 {
    static int cnt, size;
    static int[] visit, finish;
    static List<Integer>[] list;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            cnt = 0;
            size = 1;
            stack = new Stack<>();
            visit = new int[n + 1];
            finish = new int[n + 1];
            list = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
            }

            for (int i = 1; i <= n; i++) {
                if (visit[i] == 0) {
                    scc(i);
                }
            }
            boolean[] degree = new boolean[size];
            for (int i = 1; i <= n; i++) {
                for (int v : list[i]) {
                    if (finish[i] != finish[v]) {
                        degree[finish[v]] = true;
                    }
                }
            }
            int res = 0;
            for (int i = 1; i < size; i++) {
                if (!degree[i]) res++;
            }
            sb.append(res + "\n");
        }
        System.out.print(sb.toString());
    }


    private static int scc(int idx) {
        visit[idx] = ++cnt;
        stack.push(idx);

        int root = visit[idx];
        for (int next : list[idx]) {
            if (visit[next] == 0) {
                root = Math.min(root, scc(next));
            } else if (finish[next] == 0) {
                root = Math.min(root, visit[next]);
            }
        }

        if (root == visit[idx]) {
            while (true) {
                int top = stack.pop();
                finish[top] = size;
                if (top == idx) break;
            }
            size++;
        }

        return root;
    }
}
