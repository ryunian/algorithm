package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1038 {
    static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            solve(i, arr[i]);
        }

        Collections.sort(list);
        System.out.println(list.size() <= n ? -1 : list.get(n));
    }

    private static void solve(int idx, long num) {
        list.add(num);
        for (int i = idx + 1; i < 10; i++) {
            solve(i, num * 10 + arr[i]);
        }
    }

}
