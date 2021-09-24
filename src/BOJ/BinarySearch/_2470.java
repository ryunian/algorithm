package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 두 용액
public class _2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int x = 0;
        int y = 0;
        int min = Integer.MAX_VALUE;

        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n-1;

            while (left <= right) {
                int mid = (left + right) / 2;
                int val = arr[mid] + arr[i];
                int abs = Math.abs(val);

//                System.out.println(left+" "+right+" "+mid);

                if (min > abs) {
                    min = abs;
                    x = arr[i];
                    y = arr[mid];
                }

                if (val > 0) {
                    right = mid - 1;
                } else if (val < 0) {
                    left = mid + 1;
                }else {
                    System.out.println(arr[i]+" "+arr[mid]);
                    return;
                }
            }
        }
        System.out.println(x + " " + y);
    }
}
