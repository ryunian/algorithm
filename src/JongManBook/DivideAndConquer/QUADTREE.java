package JongManBook.DivideAndConquer;

import java.util.Scanner;

// 7.2 쿼드 트리 뒤집기
public class QUADTREE {
    private static int idx;
    private static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) {
            str = sc.next();
            idx = 0;
            System.out.println(solve());
        }
    }

    private static String solve() {
        char x = str.charAt(idx++);
        if(x == 'b' || x =='w'){
            return String.valueOf(x);
        }

        String leftUp = solve();
        String rightUp = solve();
        String leftDown = solve();
        String rightDown = solve();

        return "x"+leftDown+rightDown+leftUp+rightUp;
    }
}
/*
4
w
xbwwb
xbwxwbbwb
xxwwwbxwxwbbbwwxxxwwbbbwwwwbb
 */