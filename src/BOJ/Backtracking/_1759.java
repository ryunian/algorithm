package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1759 {
    static int n, m;
    static String[] alpha;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        alpha = br.readLine().split(" ");
        Arrays.sort(alpha);
        visit = new boolean[m];

        for (int i = 0; i < m - n + 1; i++) {
            visit[i] = true;
            solve(i, 1);
            visit[i] = false;
        }

        System.out.println(sb.toString());

    }

    private static void solve(int idx, int cnt) {
        if (cnt == n) {
            String tmp = "";
            int vowel = 0; // 모음
            int consonant = 0; // 자음
            for (int i = 0; i < m; i++) {
                if (visit[i]) {
                    tmp += alpha[i];
                    if (alpha[i].equals("a") || alpha[i].equals("e") || alpha[i].equals("i") ||
                            alpha[i].equals("o") || alpha[i].equals("u")) {
                        vowel++;
                    } else {
                        consonant++;
                    }
                }
            }
            if (vowel >= 1 && consonant >= 2) {
                sb.append(tmp + "\n");
            }
            return;
        }

        for (int i = idx + 1; i < m; i++) {
            if (!visit[i]) {
                visit[i] = true;
                solve(i, cnt + 1);
                visit[i] = false;
            }
        }
    }
}
