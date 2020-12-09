package BOJ.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1786 {
    static int cnt = 0;
    static char[] str, pattern;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().toCharArray();
        pattern = br.readLine().toCharArray();

        // 패턴에서 접두사와 접미사의 반복되는 길이인 배열pi를 생성한다.
        int[] pi = makePi();

        // 배열 pi를 이용하여 문자열에서 패턴에 맞는 것을 찾는다
        findStr(pi);

        // result
        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    private static int[] makePi() {
        int[] pi = new int[pattern.length];
        int j = 0;
        for (int i = 1; i < pi.length; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = pi[j - 1];
            }

            if (pattern[i] == pattern[j]) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    private static void findStr(int[] pi) {
        int j = 0;
        for (int i = 0; i < str.length; i++) {
            while (j > 0 && str[i] != pattern[j]) {
                j = pi[j - 1];
            }
            if (str[i] == pattern[j]) {
                if (j == pattern.length - 1) {
                    cnt++;
                    sb.append(i - j + 1 + " ");
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
    }
}
