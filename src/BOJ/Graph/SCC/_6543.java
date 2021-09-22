package BOJ.Graph.SCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 그래프의 싱크
public class _6543 {
    static int cnt, sccCnt;
    static List<Integer>[] list;
    static Stack<Integer> stack;
    static int[] visit, sccArr;
    static boolean[] finish;
    static ArrayList<ArrayList<Integer>> sccInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            int m = Integer.parseInt(st.nextToken());
            list = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            while (m-- > 0) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
            }

            stack = new Stack<>();
            cnt = 0;
            sccCnt = 0;
            visit = new int[n + 1];
            finish = new boolean[n + 1];
            sccArr = new int[n + 1];
            sccInfo = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (visit[i] == 0) {
                    scc(i);
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int next : list[i]) {
                    if (sccArr[i] != sccArr[next]) {
                        sccInfo.get(sccArr[i]).clear();
                    }
                }
            }
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < sccInfo.size(); i++) {
                res.addAll(sccInfo.get(i));
            }
            res.sort(null);
            for (int i = 0; i < res.size(); i++) {
                sb.append(res.get(i) + " ");
            }
            sb.append("\n");
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
            } else if (!finish[next]) {
                root = Math.min(root, visit[next]);
            }
        }

        if (root == visit[idx]) {
            ArrayList<Integer> tmp = new ArrayList<>();
            while (true) {
                int top = stack.pop();
                finish[top] = true;
                sccArr[top] = sccCnt;
                tmp.add(top);
                if (top == idx) break;
            }
            sccInfo.add(tmp);
            sccCnt++;
        }

        return root;
    }
}
