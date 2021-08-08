package SWEA.D3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _3499 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        List<String> list;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= test; tc++) {
            int n = sc.nextInt();

            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.next());
            }

            int div = (n + 1) / 2;
            int x = 0;
            int y = div;

            sb.append("#" + tc + " ");
            for (int i = y; i < n; i++) {
                sb.append(list.get(x++) + " ");
                sb.append(list.get(y++) + " ");
            }
            if (n % 2 == 1) sb.append(list.get(div - 1));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
