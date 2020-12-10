package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bfs(n, m);
    }

    private static void bfs(int n, int m) {
        int[] visit = new int[100001];
        Arrays.fill(visit, -1);
        Queue<Integer> queue = new LinkedList();
        queue.add(n);
        visit[n] = 0;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            if(cur == m){
                System.out.println(visit[cur]);
                break;
            }
            for (int i = 0; i < 3; i++) {
                int next;
                int cnt;
                if(i == 0){
                    next = cur +1;
                    cnt = visit[cur]+1;
                }else if(i == 1){
                    next = cur -1;
                    cnt = visit[cur]+1;
                }else{
                    next = cur*2;
                    cnt = visit[cur];
                }
                if(next < 0 || next > 100000) continue;
                if(visit[next] > cnt) visit[next] = cnt;
                if(visit[next] == -1){
                    visit[next] = cnt;
                    queue.add(next);
                }
            }
        }
    }
}
