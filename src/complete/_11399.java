package complete;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

// 1 정렬을 이용한 방식
// 2 TreeMap을 이용한 방식 << 사용
public class _11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int person = sc.nextInt();
        int[] x = new int[person];
        for (int i = 0; i < person; i++) {
            x[i] = sc.nextInt();
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : x) {
            if (map.get(num) != null) {
                map.put(num, map.get(num).intValue()+1);
            }else{
                map.put(num, 1);
            }
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        int sum = 0; // 개인이 걸린시간
        int result = 0; // 총 걸린시간
        while (iterator.hasNext()) {
            int key = iterator.next();
            for (int i = 1; i <= map.get(key); i++) {
                sum += key;
                result += sum;
                System.out.println(sum);
            }
        }
        System.out.println(result);
    }
}
//int[] x = {3, 1, 4, 3, 2};
// 1 3 6 9 13