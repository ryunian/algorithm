package programmers;

import java.util.ArrayList;

public class Hindex {
    public static void main(String[] args) {
        Hindex test = new Hindex();
//        test.solution(new int[]{12, 11, 10, 9, 8, 1});
//        test.solution(new int[]{4, 4, 4, 5, 0, 1, 2, 3});
//        test.solution(new int[]{3, 0, 6, 1, 5});
//        test.solution(new int[]{0, 0, 1, 1});
//        test.solution(new int[]{0, 1});
//        test.solution(new int[]{2, 7, 5});
//        test.solution(new int[]{10,11,12,13});

        test.solution(new int[]{4,4,4});
        test.solution(new int[]{4,4,4,5,0,1,2,3});
        test.solution(new int[]{10,11,12,13});
        test.solution(new int[]{3,0,6,1,5});
        test.solution(new int[]{0,0,1,1});
        test.solution(new int[]{0, 1});
        test.solution(new int[]{10,9,4,1,1});
    }

    public int solution(int[] citations) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < citations.length; i++) {
            list.add(citations[i]);
        }
        list.sort((o1, o2) -> o2 - o1);
        int answer = 0;
        int max = list.size();
        while (max > 0){
            int over = 0;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) >= max) over++;
            }
            if(max <= over){
                answer = max;
                break;
            }
            max--;
        }
        System.out.println(list+" "+answer);


        return answer;
    }
}
