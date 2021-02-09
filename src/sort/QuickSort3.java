package sort;

import java.util.Arrays;

public class QuickSort3 {
    public static void main(String[] args) {
        int[] arr = {31, 8, 48, 73, 11, 3, 20, 29, 65, 15};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // 분할
        int q = partition(arr, left, right);

        // 오른쪽부분 정렬
        quickSort(arr, q + 1, right);
        // 왼쪽부분 정렬
        quickSort(arr, left, q - 1);

    }

    private static int partition(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        // 중앙 값을 첫번쨰 요소로 이동
        swap(arr, left, mid);

        int pivot = arr[left];
        int i = left, j = right;

        while (i < j) {
            // j는 오른쪽에서 왼쪽으로 피봇보다 작거나 같은 값을 찾는다
            while (pivot < arr[j]) {
                j--;
            }
            // i는 왼쪽에서 오른쪽으로 피봇보다 큰 값을 찾는다.
            while (i < j && pivot >= arr[i]) {
                i++;
            }
            // 찾은 i와 j를 교환
            swap(arr, i, j);
        }
        // 반복문을 벗어난 경우는 i와 j가 만난 경우
        // 피봇 교환
        arr[left] = arr[i];
        arr[i] = pivot;

        return i;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
