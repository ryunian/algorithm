package BOJ.Implementation;

import java.util.Scanner;

// 비밀 이메일
public class _2999 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int length = str.length();
        int x = (int) Math.sqrt(length);

        int y = x;
        while (true) {
            if (x * y == length) {
                break;
            } else if (x * y > length) {
                x--;
                y = x;
            } else {
                y++;
            }
        }
        char[][] map = new char[x][y];
        int idx = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                map[j][i] = str.charAt(idx++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                sb.append(map[i][j]);
            }
        }
        System.out.println(sb);
    }
}