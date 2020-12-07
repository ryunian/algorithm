package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> clone = new HashSet<>();
        for (int i = 1; i <= 20 ; i++) {
            clone.add(i);
        }

        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < n; i++) {
            String[] a = br.readLine().split(" ");
            int val = a.length > 1 ? Integer.parseInt(a[1]) : 0;
            switch (a[0]){
                case "add":
                    set.add(val);
                    break;

                case "remove":
                    set.remove(val);
                    break;

                case "check":
                    sb.append(set.contains(val) ? 1 : 0).append("\n");
                    break;

                case "toggle":
                    if(set.contains(val)){
                        set.remove(val);
                    }else{
                        set.add(val);
                    }
                    break;

                case "all":
                    set.addAll(clone);
                    break;

                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
