package BOJ.Graph.SCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 강한 연결 요소 ( 타잔 알고리즘 )
public class _2150 {
    // sccCnt : 강한연결요소의 개수
    static int count = 0, sccCnt = 0;
    // dfs로 방문한 차례
    static int[] dfsNum;
    static boolean[] finish;
    static ArrayList<Integer>[] list;
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 정점 수
        int v = Integer.parseInt(st.nextToken());
        // 간선 수
        int e = Integer.parseInt(st.nextToken());
        list = new ArrayList[v + 1];
        dfsNum = new int[v + 1];
        finish = new boolean[v + 1];

        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        for (int i = 1; i <= v; i++) {
            if (dfsNum[i] == 0) {
                scc(i);
            }
        }

        // 가장 작은 정점의 정점 순으로 오름차순 정렬
        result.sort((o1, o2) -> o1.get(0) - o2.get(0));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                sb.append(result.get(i).get(j)).append(" ");
            }
            sb.append("-1\n");
        }

        // 결과
        System.out.println(sccCnt);
        System.out.println(sb.toString());
    }

    // 강한 연결 요소 ( 타잔 알고리즘 )
    private static int scc(int cur) {
        dfsNum[cur] = ++count;
        stack.push(cur);

        // 자신의 dfsNum, 자식들의 결과나 dfsNum 중 가장 작은 번호를 res에 저장
        int res = dfsNum[cur];
        for (int next : list[cur]) {
            // 방문하지 않은 이웃
            if (dfsNum[next] == 0) {
                res = Math.min(res, scc(next));
            }
            // 방문은 했으나 아직 SCC로 추출되지 않는 이웃
            else if (!finish[next]) {
                res = Math.min(res, dfsNum[next]);
            }
        }

        // 자신, 자신의 자손들이 도달 가능한 제일 높은 정점이 자신일 경우
        if (res == dfsNum[cur]) {
            // scc 요소를 담을 임시 리스트
            ArrayList<Integer> tmp = new ArrayList<>();
            // 스택에서 자신이 나올때 까지 pop 하면서 임시리스트에 삽입
            while (true) {
                int top = stack.peek();
                stack.pop();
                tmp.add(top);
                finish[top] = true;

                // 자기 자신이 나오면 stop
                if (top == cur) break;
            }
            // result 리스트에 담기전 임시리스트 정렬
            Collections.sort(tmp);
            result.add(tmp);

            sccCnt++;
        }

        return res;
    }
}
