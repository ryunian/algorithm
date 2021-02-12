package BOJ.Greedy;

import java.util.Scanner;

public class _1343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        boolean isPossible = true;

        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) =='X'){
                cnt++;
            }else{
                sb.append(str.charAt(i));
            }
            if(i == str.length()-1 || str.charAt(i+1)== '.'){
                if(cnt % 2 == 1){
                    isPossible = false;
                    break;
                }else{
                    while (cnt > 0){
                        if(cnt / 4 > 0){
                            sb.append("AAAA");
                            cnt -=4;
                        }else{
                            sb.append("BB");
                            cnt -=2;
                        }
                    }
                }
            }
        }
        if(isPossible){
            System.out.println(sb.toString());
        }else{
            System.out.println(-1);
        }
    }
}
