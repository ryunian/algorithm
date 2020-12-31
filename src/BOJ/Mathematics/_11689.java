package BOJ.Mathematics;

import java.util.ArrayList;
import java.util.Scanner;

public class _11689 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int size = (int) Math.sqrt(1000000000000l);
        boolean[] arr = new boolean[size+1];
        ArrayList<Long> sosu = new ArrayList();

        // 에라토스테네스의체 를 이용해야 시간초과를 막을수 있다.
        for (long i = 2; i <= size; i++) {
            if(arr[(int)i]) continue;
            else sosu.add(i);
            for (long j = i*i; j <= size; j+=i) {
//                System.out.println(j);
                arr[(int)j] = true;
            }
        }
        // 오일러 토선트 함수
        long result = 1;
        for (int i = 0; i < sosu.size(); i++) {
            int cnt = 0;
            long num = sosu.get(i);
            while (n % num == 0){
                cnt++;
                n /= num;
            }
            // 나눠지지 않았으면 넘어간다.
            if(cnt == 0) continue;
            // 계산
            result *= Math.pow(num, cnt) - Math.pow(num, cnt -1);
        }
        // 1이 아닐경우 현재 n은 소수이다
        if (n != 1){
            result *= n - 1;
        }
        System.out.println(result);

    }
}
