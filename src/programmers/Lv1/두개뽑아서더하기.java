package programmers.Lv1;

import java.util.Arrays;
import java.util.HashSet;

public class 두개뽑아서더하기 {
    public static void main(String[] args) {
        두개뽑아서더하기 test = new 두개뽑아서더하기();
        test.solution(new int[]{2,1,3,4,1});
        test.solution(new int[]{5,0,2,7});
    }

    public int[] solution(int[] numbers) {
        Arrays.sort(numbers);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
                if (numbers[i] == numbers[j]) i++;
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
