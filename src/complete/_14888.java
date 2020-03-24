package complete;

import java.util.Scanner;

public class _14888 {
    static int size;
    static int[] num;
    static int[] calculate;
    static int[] temp;
    static boolean[] check;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        num = new int[size];
        for (int i = 0; i < size; i++) {
            num[i] = sc.nextInt();
        }
        calculate = new int[size - 1];
        temp = new int[size];
        temp[0] = num[0];
        check = new boolean[size - 1];
        int count = 0;
        int n = 0;
        for(int i=0; i<4; i++){
            n++;
            int x = sc.nextInt();
            for(int j=0;j<x;j++){
                calculate[count++] = n;
            }
        }
//        System.out.println(Arrays.toString(calculate));
        dfs(1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int idx) {
        if (idx == size) {
            if(min>temp[idx-1]) min = temp[idx-1];
            if(max<temp[idx-1]) max = temp[idx-1];
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            if (!check[i]) {
                if (calculate[i] == 1) {
                    temp[idx] = temp[idx-1] + num[idx];
                } else if (calculate[i] == 2) {
                    temp[idx] = temp[idx-1] - num[idx];
                } else if (calculate[i] == 3) {
                    temp[idx] = temp[idx-1] * num[idx];
                } else if (calculate[i] == 4) {
                    temp[idx] = temp[idx-1] / num[idx];
                }
                check[i] = true;
                dfs(idx + 1);
                check[i] = false;
            }
        }
    }
}
