package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n = br.readLine().split("");
        int m = Integer.parseInt(br.readLine());

        List<String> list = new LinkedList<>(Arrays.asList(n));
        ListIterator<String> iterator = list.listIterator();
        while(iterator.hasNext()){
            iterator.next();
        }

        for (int i = 0; i < m; i++) {
            String[] x = br.readLine().split(" ");
            switch (x[0]){
                case "L":
                    if(iterator.hasPrevious()) iterator.previous();
                    break;
                case "D":
                    if(iterator.hasNext()) iterator.next();
                    break;
                case "B":
                    if(iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case "P":
                    iterator.add(x[1]);
                    break;
            }
//            System.out.println(list);
        }
        StringBuilder sb = new StringBuilder();
        for(Object x : list){
            sb.append(x);
        }
        System.out.println(sb);
    }
}
