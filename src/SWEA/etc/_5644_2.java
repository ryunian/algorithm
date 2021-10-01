package SWEA.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 무선 충전
public class _5644_2 {
    static int[] userA, userB;
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};
    static List<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            userA = new int[m];
            userB = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                userA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                userB[i] = Integer.parseInt(st.nextToken());
            }

            int idx = 0;
            while (a-- > 0) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                list.add(new Node(idx++, x, y, c, p));
            }
            System.out.printf("#%d %d\n", tc, move(m));
        }
    }

    private static int move(int m) {
        int x1 = 0, y1 = 0;
        int x2 = 9, y2 = 9;
        int sum = charge(x1, y1, x2, y2);

        for (int i = 0; i < m; i++) {
            x1 += dx[userA[i]];
            y1 += dy[userA[i]];
            x2 += dx[userB[i]];
            y2 += dy[userB[i]];
            sum += charge(x1, y1, x2, y2);
        }
        return sum;
    }

    private static int charge(int x1, int y1, int x2, int y2) {
        ArrayList<Pair> tmp = getBatery(x1, y1, x2, y2);
        tmp.sort(null);
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 2; i++) {
            for (Pair pair : tmp) {
                if (pair.user != i || set.contains(pair.idx)) continue;
                sum += pair.val;
                set.add(pair.idx);
                break;
            }
        }
        int sum2 = 0;
        set = new HashSet<>();
        for (int i = 1; i >= 0; i--) {
            for (Pair pair : tmp) {
                if (pair.user != i || set.contains(pair.idx)) continue;
                sum2 += pair.val;
                set.add(pair.idx);
                break;
            }
        }
        return Math.max(sum, sum2);
    }

    private static ArrayList<Pair> getBatery(int x1, int y1, int x2, int y2) {
        ArrayList<Pair> ret = new ArrayList<>();
        for (Node node : list) {
            if (Math.abs(node.x - x1) + Math.abs(node.y - y1) <= node.range) {
                ret.add(new Pair(0, node.idx, node.val));
            }
            if (Math.abs(node.x - x2) + Math.abs(node.y - y2) <= node.range) {
                ret.add(new Pair(1, node.idx, node.val));
            }
        }
        return ret;
    }

    static class Node {
        int idx, x, y, range, val;

        public Node(int idx, int x, int y, int range, int val) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.range = range;
            this.val = val;
        }
    }

    static class Pair implements Comparable<Pair> {
        int user, idx, val;

        public Pair(int user, int idx, int val) {
            this.user = user;
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return o.val - val;
        }
    }
}