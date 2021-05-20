package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17140 {
    private static int r, c, k, res = Integer.MAX_VALUE, row, col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        int[][] map = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        row = 3; col = 3;
        solve(0, map);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    private static void solve(int cnt, int[][] map) {
        if (cnt > 100) {
            return;
        }
        if (r < row && c < col && map[r][c] == k) {
            res = Math.min(res, cnt);
            return;
        }
        if (row >= col) {
            solve(cnt + 1, operationR(map));
        } else {
            solve(cnt + 1, operationC(map));
        }

    }

    private static int[][] operationR(int[][] map) {
        int max = 0;
        for (int i = 0; i < row; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < col; j++) {
                if(map[i][j] == 0) continue;
                set.add(map[i][j]);
            }
            max = Math.max(max, set.size() * 2);
        }

        int[][] ret = new int[row][max];

        for (int i = 0; i < row; i++) {
            HashMap<Integer, Integer> tmp = new HashMap<>();
            for (int j = 0; j < col; j++) {
                int x = map[i][j];
                if (x == 0) continue;
                if (tmp.get(x) == null) {
                    tmp.put(x, 1);
                } else {
                    tmp.put(x, tmp.get(x) + 1);
                }
            }

            List<Integer> list = mapToSortList(tmp);
            int k = list.size() <= 100 ? list.size() : 100;
            for (int j = 0; j < k; j++) {
                ret[i][j] = list.get(j);
            }
        }
        col = max;
        return ret;
    }

    private static int[][] operationC(int[][] map) {
        int max = 0;
        for (int i = 0; i < col; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < row; j++) {
                if(map[j][i] == 0) continue;
                set.add(map[j][i]);
            }
            max = Math.max(max, set.size() * 2);
        }

        int[][] ret = new int[max][col];
        for (int i = 0; i < col; i++) {
            HashMap<Integer, Integer> tmp = new HashMap<>();
            for (int j = 0; j < row; j++) {
                int x = map[j][i];
                if (x == 0) continue;
                if (tmp.get(x) == null) {
                    tmp.put(x, 1);
                } else {
                    tmp.put(x, tmp.get(x) + 1);
                }
            }

            List<Integer> list = mapToSortList(tmp);
            int k = list.size() <= 100 ? list.size() : 100;
            for (int j = 0; j < k; j++) {
                ret[j][i] = list.get(j);
            }
        }
        row = max;
        return ret;
    }

    private static List<Integer> mapToSortList(HashMap<Integer, Integer> map) {
        List<Pair> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(new Pair(key, map.get(key)));
        }
        list.sort(Comparator.comparing(Pair::getCnt).thenComparing(Pair::getNum));

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Pair cur = list.get(i);
            ret.add(cur.num);
            ret.add(cur.cnt);
        }
        return ret;
    }

    private static class Pair {
        int num;
        int cnt;

        public Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        public int getNum() {
            return num;
        }

        public int getCnt() {
            return cnt;
        }
    }
}
