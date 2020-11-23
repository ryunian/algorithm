package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 멀티탭 구멍의 수
        int n = Integer.parseInt(st.nextToken());
        // 전기용품의 총 사용 횟수
        int k = Integer.parseInt(st.nextToken());

        // 전기용품 각각의 사용 횟수
        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.toString(arr));

        List<Integer> list = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < k; i++) {
            // 리스트가 비어잇을경우
            if(list.size() < n){
                if(!list.contains(arr[i])){
                    list.add(arr[i]);
                }
            }
            // 리스트가 비어있지 않고 중복으로 들어오지 않을 경우
            else if(!list.contains(arr[i])){
                int a = 101;
                int target = -1;
                for (int j = 0; j < list.size(); j++) {
                    boolean b = false;
                    for (int l = i+1; l < k ; l++) {
//                        System.out.println("list.get : "+ list.get(j) +"   a : " + a + "    k-l : "+ (k-l) + "   j : "+ j);
                        if(list.get(j) == arr[l] & !b){
                            if(a > k - l && a != 0){
                                a = k - l;
                                target = j;
                            }
                            b = true;
                        }else {
                            if(!b && a != 0 && l == (k-1)){
//                                System.out.println("x");
                                a = 0;
                                target = j;
                            }
                        }
                    }
//                    System.out.println("========================\ntarget : "+ (target+1) + " // a = " + a);
                }
//                System.out.println("target : "+ target + " arr[i] " + arr[i]);
                if(target != -1){
                    list.remove(target);
                    list.add(arr[i]);
                    count++;
                }else{
                    count++;
                }
            }
//            System.out.println(list);
        }
        System.out.println(count);
    }
}