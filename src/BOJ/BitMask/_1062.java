package BOJ.BitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1062 {
    static int n, k, res = 0;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visit = new boolean[26];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int bit = 0;
            for (int j = 0; j < str.length(); j++) {
                bit |= 1 << (str.charAt(j) - 'a');
            }
            arr[i] = bit;
        }

        char[] init = {'a', 'c', 'i', 'n', 't'};
        int num = 0;
        for (int i = 0; i < init.length; i++) {
            visit[init[i] - 'a'] = true;
            num |= 1 << (init[i] - 'a');
        }

        if (k >= 5) {
            solve(num, 0, -1);
        }
        System.out.println(res);
    }

    private static void solve(int bit, int cnt, int idx) {
        if (cnt == k - 5) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i] & bit) == arr[i]) count++;
            }
            res = Math.max(count, res);
            return;
        }

        for (int i = idx + 1; i < 26; i++) {
            if (!visit[i]) {
                visit[i] = true;
                solve(bit | (1 << i), cnt + 1, i);
                visit[i] = false;
            }
        }
    }

}