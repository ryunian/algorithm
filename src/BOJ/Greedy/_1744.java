package BOJ.Greedy;

import java.util.*;

public class _1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //Arrays.sort(arr, (o1,o2)-> o2.compareTo(o1));
        Arrays.sort(arr, Comparator.reverseOrder());
//        System.out.println("정렬 : " + Arrays.toString(arr));

        LinkedList<Integer> list = new LinkedList();
        // 양수
        for (int i = 0; i < n; i++) {
            // 0이하 이거나 길이를 초과할 경우
            if (arr[i] <= 0) break;

            if (i + 1 < n &&  arr[i] > 1 && arr[i + 1] > 1) {
                list.add(arr[i] * arr[i + 1]);
                i++;
            }else{
                list.add(arr[i]);
            }
        }
//        System.out.println(list);
        // 음수
        for (int i = n-1 ; 0 <= i; i--) {
            // 0이하 이거나 길이를 초과할 경우
            if (arr[i] > 0) break;

            if (i - 1 > 0 && arr[i] <= 0 && arr[i - 1] <=  0) {
                list.add(arr[i] * arr[i - 1]);
                i--;
            }else{
                list.add(arr[i]);
            }
        }

//        System.out.println(list);
        int result = 0;
        for (int i : list) {
            result += i;
        }
        System.out.println(result);
    }}