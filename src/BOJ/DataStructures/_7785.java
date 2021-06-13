package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<String> set = new TreeSet<>(Comparator.reverseOrder());

        while (n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if(b.equals("enter")){
                set.add(a);
            }else {
                set.remove(a);
            }

        }
        StringBuilder sb = new StringBuilder();
        for(String str : set){
            sb.append(str+"\n");
        }
        System.out.print(sb.toString());
    }
}
