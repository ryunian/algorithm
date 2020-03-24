package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14889 {
    static int size;
    static int[][] num;
    static boolean[] check;
    static int[] temp;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        num = new int[size][size];
        temp = new int[size/2];
        for(int i=0; i<size; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<size; j++){
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check = new boolean[size+1];

        dfs(0,1);
        System.out.println(min);
    }

    private static void dfs(int idx,int k) {
        if(idx==size/2){
//            System.out.println(Arrays.toString(temp));
            boolean[] temp2 = new boolean[size];
            for(int i=0; i<size/2; i++){
                temp2[temp[i]-1] = true;
            }
            int sum = 0;
            int sum2 = 0;
            for(int i=0; i<size;i++){
                for(int j=0; j<size; j++){
                    if(i!=j && temp2[i] == true && temp2[j] == true){
                        sum += num[i][j];
                    }else if(i!=j && temp2[i] == false && temp2[j] == false){
                        sum2 += num[i][j];
                    }
                }
            }
            int result = Math.abs(sum-sum2);
            if(min>result) min = result;
            if(min == 0){
                System.out.println(min);
                System.exit(0);
            }
            return;
        }
        // 수열이 오름차 순으로 설정해야 중복을 최대한 없앨수 있다.
        // k는 오름차순으로 나열
        for(int i=k; i<=size; i++){
            if(!check[i]){
                check[i] = true;
                temp[idx] = i;
                dfs(idx+1,i+1);
                check[i] = false;
            }
        }

    }
}
