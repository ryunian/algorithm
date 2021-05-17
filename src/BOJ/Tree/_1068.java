package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[] visit = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == -1) root = i;
        }
        int k = Integer.parseInt(br.readLine());
        if(root != k){
            solve(arr, visit, root, k);
        }
        System.out.println(res);
    }

    static int res = 0;

    private static void solve(int[] arr, boolean[] visit, int i, int k) {
        visit[i] = true;
        boolean isleaf = true;
        for (int j = 0; j < arr.length; j++) {
            if (!visit[j] && i == arr[j] && j != k) {
                solve(arr, visit, j, k);
                isleaf = false;
            }
        }
        if (isleaf) {
            res++;
        }
    }
}
