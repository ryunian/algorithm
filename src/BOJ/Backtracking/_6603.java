package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6603 {
    static int n;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            arr = new int[n];
            visit = new boolean[n];
            sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0);
            System.out.println(sb.toString());
        }
    }

    private static void dfs(int idx, int cnt) {
        if (cnt == 6){
            for (int i = 0; i < visit.length; i++) {
                if(visit[i]){
                    sb.append(arr[i]+" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if(!visit[i]){
                visit[i] = true;
                dfs(i,cnt+1);
                visit[i] = false;
            }

        }
    }
}
