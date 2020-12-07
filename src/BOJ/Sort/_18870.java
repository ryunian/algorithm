package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        Set set = new TreeSet();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            set.add(x);
        }

        StringBuilder sb = new StringBuilder();
        Object[] sort = set.toArray();
        for (int i = 0; i < n; i++) {
            int x = Arrays.binarySearch(sort, arr[i]);
            sb.append(x+" ");
        }
        System.out.println(sb.toString());

    }
}
