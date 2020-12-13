package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] x = br.readLine().split("");
        String[] y = br.readLine().split("");
        int xlen = x.length;
        int ylen = y.length;
        int[][] map = new int[xlen + 1][ylen + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= xlen; i++) {
            for (int j = 1; j <= ylen; j++) {
                if (!x[i - 1].equals(y[j - 1])) {
                    map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
                } else {
                    map[i][j] = map[i - 1][j - 1] + 1;
                }
            }
        }
        int cnt = map[xlen][ylen];
        int i = xlen;
        int j = ylen;
        Stack<String> stack = new Stack<>();
        while (i > 0 && j > 0) {
            if (map[i][j] == map[i][j - 1]) {
                j--;
            } else if (map[i][j] == map[i - 1][j]) {
                i--;
            } else {
                stack.push(x[i - 1]);
                j--;
                i--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(cnt);
        if (cnt != 0) {
            System.out.println(sb.toString());
        }
    }
}
