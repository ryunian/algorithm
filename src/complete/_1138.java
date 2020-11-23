package complete;

import java.util.Scanner;

public class _1138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] result = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i<n ; i++){
            for(int j = 0; j< n ; j++){
                // 자기보다 큰사람을 지나치고, 자리가 비어있을 시
                if(arr[i] == 0 && result[j]==0){
                    result[j] = i+1;
                    break;
                }else if(result[j] == 0){
                    arr[i]--;
                }
            }
        }
        for(int i : result){
            System.out.print(i + " ");
        }
    }
}
/*
4
2 1 1 0
> 4 2 1 3

5
1 3 1 0 0
> 4 1 3 5 2
 */