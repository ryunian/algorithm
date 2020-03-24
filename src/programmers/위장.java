package programmers;

import java.util.HashMap;
import java.util.Iterator;

public class 위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
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
            answer *= map.get(x).intValue()+1;
        }
        return answer-1;
    }

    public static void main(String[] args) {
//        int a = 2;
//        a *= 2+1;
//        System.out.println(a);
        위장 test = new 위장();
        String[][] x ={{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
//        String[][] x = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        int y = test.solution(x);
        System.out.println(y);
    }
}
