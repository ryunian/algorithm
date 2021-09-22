package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 버블 소트
public class _1517_2 {
    static int n;
    static int[] arr, sort;
    static long cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sort = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, n - 1);
        System.out.println(cnt);
    }

    private static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                sort[k++] = arr[i++];
            } else {
                if(arr[j] != sort[k]){
                    cnt += (j - k);
                }
                sort[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            sort[k++] = arr[i++];
        }
        while (j <= right) {
            sort[k++] = arr[j++];
        }
        for (int l = left; l <= right; l++) {
            arr[l] = sort[l];
        }
    }
}
