package BOJ.Sweeping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class _2594 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = toMinute(sc.nextInt())-10;
            int b = toMinute(sc.nextInt())+10;
            list.add(new Node(a, b));
        }

        list.sort(Comparator.comparing(o -> o.prev));

        int tmp = 600;
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res = Math.max(res, list.get(i).prev - tmp);
            tmp = Math.max(tmp, list.get(i).next);
        }
        res = Math.max(res, 1320 - tmp);

        System.out.println(res);
    }

    public static int toMinute(int x) {
        return x / 100 * 60 + x % 100;
    }

    private static class Node {
        int prev;
        int next;

        public Node(int prev, int next) {
            this.prev = prev;
            this.next = next;
        }
    }
}
