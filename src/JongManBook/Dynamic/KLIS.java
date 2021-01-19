package JongManBook.Dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 9.7 K번째 최대 증가 부분 수열
public class KLIS {
    static int n, k, MAX = 987654321;
    static int[] arr;
    static int[] cacheLen, cacheCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            cacheLen = new int[n + 1];
            cacheCnt = new int[n + 1];
            Arrays.fill(cacheLen, -1);
            Arrays.fill(cacheCnt, -1);

            StringBuilder sb = new StringBuilder();
            ArrayList<Integer> list = new ArrayList<>();

            sb.append(lis(-1) - 1).append("\n");
            reconstruct(-1, k - 1, list);

            for (int res : list) {
                sb.append(res + " ");
            }
            System.out.println(sb.toString());
        }
    }

    private static int lis(int start) {
        int ret = cacheLen[start + 1];
        if (ret != -1) return ret;
        // 항상 arr[start] 는 있기 떄문에 길이는 최하 1
        ret = 1;
        for (int next = start + 1; next < n; next++) {
            if (start == -1 || arr[start] < arr[next]) {
                ret = Math.max(ret, lis(next) + 1);
            }
        }
        return cacheLen[start + 1] = ret;
    }

    private static int count(int start) {
        // 기저사례 : lis의 길이가 1인 경우
        if (lis(start) == 1) return 1;

        int ret = cacheCnt[start];
        if (ret != -1) return ret;
        ret = 0;

        for (int next = start + 1; next < n; next++) {
            if ((start == -1 || arr[start] < arr[next]) && lis(start) == lis(next) + 1) {
                ret = Math.min(MAX, ret + count(next));
            }
        }

        return cacheCnt[start] = ret;
    }

    private static void reconstruct(int start, int skip, ArrayList<Integer> list) {
        // arr[start] 는 항상 LIS에 포함
        if (start != -1) list.add(arr[start]);

        // 뒤에 올수 있는 숫자들과 위치의 목록
        // Pair.x : 숫자, Pair.y : 숫자의 위치
        ArrayList<Pair> follwers = new ArrayList<>();

        for (int next = start + 1; next < n; next++) {
            if ((start == -1 || arr[start] < arr[next]) && lis(start) == lis(next) + 1) {
                follwers.add(new Pair(arr[next], next));
            }
        }
        // 숫자를 기준으로 오름차순 정렬
        follwers.sort(Comparator.comparingInt(o -> o.x));

        // k 번째 LIS의 다음 숫자를 찾는다.
        for (int i = 0; i < follwers.size(); i++) {
            int idx = follwers.get(i).y;
            int cnt = count(idx);
            if (cnt <= skip) {
                skip -= cnt;
            } else {
                // 다음 숫자는 arr[idx]
                reconstruct(idx, skip, list);
                break;
            }
        }
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
/*
3
8 6
5 1 6 4 3 2 8 7
8 4
2 1 4 3 6 5 8 7
8 2
5 6 7 8 1 2 3 4
 */