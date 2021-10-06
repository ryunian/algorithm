package SWEA.etc;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeSet;

// 보물상자 비밀번호
public class _5658 {
    static LinkedList<Character> list;
    static TreeSet<Integer> set;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt() / 4;
            int k = sc.nextInt();
            list = new LinkedList<>();
            String str = sc.next();
            for (int i = 0; i < str.length(); i++) {
                list.add(str.charAt(i));
            }
            set = new TreeSet<>((o1, o2) -> o2 - o1);
            for (int i = 0; i < n; i++) {
                makeInt();
                list.addFirst(list.removeLast());
            }
            Optional<Integer> first = set.stream().skip(k - 1).findFirst();
            System.out.printf("#%d %d\n", tc, first.get());
        }
    }

    private static void makeInt() {
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
            if (sb.length() == n) {
                int x = Integer.parseInt(sb.toString(), 16);
                set.add(x);
                sb.setLength(0);
            }
        }
    }
}
