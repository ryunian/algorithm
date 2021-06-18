package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _3671 {
    static int cnt, length;
    static char[] arr;
    static boolean[] visit;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 10000000;
        boolean[] sosu = new boolean[max];
        sosu[0] = sosu[1] = true;
        for (int i = 2; i < max; i++) {
            if(sosu[i]) continue;
            for (int j = i+i; j < max; j+= i) {
                sosu[j] = true;
            }
        }

        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (test-- > 0){
            arr = br.readLine().toCharArray();
            length = arr.length;
            visit = new boolean[length];
            set = new HashSet<>();
            for (int i = 0; i < length; i++) {
                visit[i] = true;
                dfs(arr[i]+"");
                visit[i] = false;
            }

            int res = 0;
            for (Iterator<Integer> it = set.iterator(); it.hasNext(); ) {
                if(!sosu[it.next()]){
                    res++;
                }
            }
            sb.append(res+"\n");
        }
        System.out.print(sb.toString());
    }

    private static void dfs(String str) {
        set.add(Integer.parseInt(str));

        for (int i = 0; i < length; i++) {
            if(!visit[i]){
                visit[i] = true;
                dfs(str+arr[i]);
                visit[i] = false;
            }
        }
    }
}
