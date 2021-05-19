package BOJ.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 풀이방법 : 1. 분할정복+upperBound 2. dfs 3. 이진탐색구현
public class _5639 {
    private static List<Integer> list;
    private static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        sb = new StringBuilder();
        solve(0, list.size() );
        System.out.print(sb.toString());
    }
    private static void solve(int left, int right) {
        if (left >= right) {
            return;
        }
        int val = upperBound(list.get(left), left + 1, right);

        solve(left + 1, val);
        solve(val, right);

        sb.append(list.get(left)+"\n");
    }

    private static int upperBound(int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
