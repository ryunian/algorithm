package BOJ.Implementation;

import java.io.*;
import java.util.*;

// 마법사 상어와 블리자드
public class _21611 {
    static int n, m;
    static int[] dir = {6, 2, 0, 4};
    static int[] res;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        res = new int[3];
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        init(arr);
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            solve(a, b);
        }
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans += (i + 1) * res[i];
        }
        System.out.println(ans);
    }

    private static void solve(int a, int b) {
        int x = dir[a - 1];
        int y = x + 1;
        for (int i = 0; i < b; i++) {
            if (x >= list.size()) break;
            list.remove(x--);
            y += 8;
            x += y;
        }
        boom();
        divide();
    }

    private static void divide() {
        ArrayList<Integer> tmp = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int val : list) {
            if (queue.isEmpty() || queue.peek() == val) {
                queue.add(val);
            } else if (queue.peek() != val) {
                if (tmp.size() != n * n - 1) tmp.add(queue.size());
                if (tmp.size() != n * n - 1) tmp.add(queue.peek());
                else break;
                queue.clear();
                queue.add(val);
            }
        }
        if (!queue.isEmpty()) {
            if (tmp.size() != n * n - 1) tmp.add(queue.size());
            if (tmp.size() != n * n - 1) tmp.add(queue.peek());
        }
        list = tmp;
    }

    private static void boom() {
        ArrayList<Integer> tmp = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean isok = true;
        for (int i = 0; i < list.size(); i++) {
            int val = list.get(i);
            if (queue.isEmpty() || queue.peek() == val) {
                queue.add(val);
            } else if (queue.peek() != val) {
                if (queue.size() >= 4) {
                    res[queue.peek() - 1] += queue.size();
                    isok = false;
                } else {
                    tmp.addAll(queue);
                }
                queue.clear();
                queue.add(val);
            }
        }
        if (queue.size() >= 4) {
            res[queue.peek() - 1] += queue.size();
            isok = false;
        } else {
            tmp.addAll(queue);
        }
        list = tmp;
        if (!isok) boom();
    }

    private static void init(int[][] arr) {
        list = new ArrayList<>();
        int x = n / 2;
        int y = n / 2;
        int num = 1;
        int cnt = 1;
        int z = 1;

        while (num < n * n) {
            for (int i = 0; i < cnt; i++) {
                if (num == n * n) break;
                y += (z * -1);
                if (arr[x][y] != 0) list.add(arr[x][y]);
                num++;
            }
            for (int i = 0; i < cnt; i++) {
                if (num == n * n) break;
                x += z;
                if (arr[x][y] != 0) list.add(arr[x][y]);
                num++;
            }
            z *= -1;
            cnt++;
        }
    }
}