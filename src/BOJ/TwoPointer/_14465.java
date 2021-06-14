package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // false = 정상
        // true = 망가짐
        boolean[] arr = new boolean[n];

        while (b-- > 0) {
            int x = Integer.parseInt(br.readLine()) - 1;
            arr[x] = true;
        }

        int left = 0;
        int right = k - 1;
        int brokenCnt = 0;

        for (int i = 0; i < k; i++) {
            if (arr[i]) brokenCnt++;
        }

        int res = brokenCnt;
        while (right + 1 < n) {
            brokenCnt += arr[left++] ? -1 : 0;
            brokenCnt += arr[++right] ? 1 : 0;

            res = Math.min(brokenCnt, res);
        }
        System.out.println(res);

    }
}
