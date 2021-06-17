package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2295 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                a.add(arr[i] + arr[j]);
            }
        }
        Collections.sort(a);

        loop:
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int val = arr[i] - arr[j];
                int left = 0;
                int right = a.size();
                boolean isPossible = false;

                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (a.get(mid) == val) {
                        isPossible = true;
                        break;
                    } else if (a.get(mid) < val) {
                        left = mid + 1;
                    } else if (a.get(mid) > val) {
                        right = mid - 1;
                    }
                }
                if (isPossible) {
                    System.out.println(arr[i]);
                    break loop;
                }
            }
        }
    }
}
