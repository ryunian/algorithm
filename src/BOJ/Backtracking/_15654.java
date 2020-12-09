package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15654 {
    static int n,m;
    static int[] arr,temp;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        temp = new int[m];
        visit = new boolean[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb.toString());
    }

    private static void dfs(int cnt) {
        if(cnt == m){
            for(int x : temp){
                sb.append(x+" ");
            }
            sb.append("\n");
            return;
        }

        for (int j = 0; j < n; j++) {
            if(!visit[j]){
                visit[j] = true;
                temp[cnt] = arr[j];
                dfs(cnt +1);
                visit[j] = false;
            }
        }
    }
}
