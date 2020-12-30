package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 단절점
// 정점 A가 루트 라면 ::
//   자식 수가 2개 이상이면 단절점이다.
// 정점 A가 루트가 아니라면 ::
//   A번 정점에서 자식 노드들이 정점 A를 거치지 않고
//   정점 A보다 빠른 방문번호를 가진 정점으로 갈 수 없다면 단절점이다.
public class _11266 {
    static int v, e, cnt = 0;
    static int[] visit;
    static ArrayList<Integer>[] list;
    static boolean[] isCut;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        visit = new int[v];
        list = new ArrayList[v];
        isCut = new boolean[v];
        for (int i = 0; i < v; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list[a].add(b);
            list[b].add(a);
        }
        for (int i = 0; i < v; i++) {
            if (visit[i] == 0) {
                dfs(i, true);
            }
        }

        // 결과
        StringBuilder sb = new StringBuilder();
        int result = 0;
        for (int i = 0; i < v; i++) {
            if(isCut[i]){
                sb.append(i+1+" ");
                result++;
            }
        }
        System.out.println(result);
        System.out.println(sb.toString());
    }

    private static int dfs(int cur, boolean isRoot) {
        visit[cur] = ++cnt;
        int ret = visit[cur];
        int child = 0;

        for (int next : list[cur]) {
            if (visit[next] != 0) {
                ret = Math.min(ret, visit[next]);
                continue;
            }

            child++;
            int prev = dfs(next, false);

            // root가 아니며,
            // A번 정점에서 자식 노드들이 정점 A를 거치지 않고
            // 정점 A보다 빠른 방문번호를 가진 정점으로 갈 수 없다면 단절점이다
            if (!isRoot && prev >= visit[cur]) {
                isCut[cur] = true;
            }
            ret = Math.min(ret, prev);
        }
        // 정점이 root 이며, 자식 수가 2개 이상이면 단절점 이다.
        if (isRoot) {
            isCut[cur] = (child >= 2);
        }
        return ret;
    }
}
