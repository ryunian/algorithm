package SWEA.D3;

import java.util.LinkedList;
import java.util.Scanner;

public class _1228 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            while (n-- > 0) {
                list.add(sc.nextInt());
            }

            int query = sc.nextInt();
            while (query-- > 0) {
                sc.next();
                int idx = sc.nextInt();
                int loop = sc.nextInt();
                while (loop-- > 0) {
                    list.add(idx++, sc.nextInt());
                }
            }

            sb.append("#" + tc + " ");
            int x = 10;
            while (x-- > 0) {
                sb.append(list.remove(0) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
