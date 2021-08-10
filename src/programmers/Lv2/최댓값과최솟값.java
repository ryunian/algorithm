package programmers.Lv2;

public class 최댓값과최솟값 {
    public static void main(String[] args) {
        최댓값과최솟값 test = new 최댓값과최솟값();
        test.solution("1 2 3 4");
    }

    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        String[] arr = s.split(" ");
        for (String str : arr) {
            int x = Integer.parseInt(str);
            max = Math.max(max, x);
            min = Math.min(min, x);
        }

        return min + " " + max;
    }
}
