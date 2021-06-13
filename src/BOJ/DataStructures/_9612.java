package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class _9612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int cnt = 0;
        while (n-- > 0){
            String str = br.readLine();
            if(map.get(str) == null){
                map.put(str, 1);
            }else {
                map.put(str, map.get(str)+1);
            }
            int tmp = map.get(str);
            if(cnt < tmp){
                cnt = tmp;
                list.clear();
                list.add(str);
            }else if(cnt == tmp){
                list.add(str);
            }
        }
        list.sort(Comparator.reverseOrder());
        System.out.print(list.get(0)+" "+cnt);
    }
}
