package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1920 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(find(x, 0, arr.length)).append("\n");
//            System.out.println();
        }

        System.out.println(sb.toString());

    }

    private static int find(int target, int start, int end) {
        int mid = (start + end) / 2;
//        System.out.print("\ntarget = " + target);
//        System.out.print("  start = " + start);
//        System.out.print("  mid = " + mid);
//        System.out.print("  end = " + end);
        if (mid >= end){
            return 0;
        }

        if (arr[mid] == target) {
            return 1;
        } else if (arr[mid] > target) {
            return find(target, start, mid);
        } else {
            return find(target, mid + 1, end);
        }

    }

}
