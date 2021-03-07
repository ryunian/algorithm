package programmers.Lv2;

import java.util.ArrayList;

public class 구명보트 {
    public static void main(String[] args) {
        구명보트 test = new 구명보트();
        test.solution(new int[]{70, 50, 80, 50}, 100);
        test.solution(new int[]{70, 80, 50}, 100);
        test.solution(new int[]{30, 30, 50}, 100);
        test.solution(new int[]{30, 30, 70, 70}, 100);
        test.solution(new int[]{70, 70, 10, 10, 10, 10, 10, 10}, 100);
        test.solution(new int[]{70, 70, 10, 10, 10, 10, 10, 10, 5}, 100);
        test.solution(new int[]{70, 70, 20, 19, 15, 11, 9, 7, 5}, 100);
    }

    public int solution(int[] people, int limit) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i]);
        }
        list.sort((o1, o2) -> o2 - o1);

        int answer = 0;
        int sum = 0;
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            sum = list.get(left++);
            answer++;
            while (sum + list.get(right) <= limit){
                sum += list.get(right);
                right--;
            }

        }
        System.out.println(list + " " + answer);

        return answer;
    }
}
// 3 3 2 2 2 3 3