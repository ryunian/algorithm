package SWEA.D3;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class _7102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>();

            int max = 0;
            for (int i = 1; i <= x; i++) {
                for (int j = 1; j <= y; j++) {
                    map.put(i + j, map.getOrDefault(i + j, 1) + 1);
                    max = Math.max(map.get(i + j), max);
                }
            }

            sb.append("#" + tc + " ");
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                int key = iterator.next();
                if (map.get(key) == max) {
                    sb.append(key + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
