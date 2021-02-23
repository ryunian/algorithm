package programmers;

import java.util.HashMap;
import java.util.Iterator;

public class 위장 {
    public int solution(String[][] clothes) {
        int result = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key, 1);
            }
        }
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String x = iterator.next();
            result *= map.get(x).intValue()+1;
        }
        return result-1;
    }
}