package programmers;

public class 타겟넘버 {
    public static void main(String[] args) {
        타겟넘버 test = new 타겟넘버();
        test.solution(new int[]{1, 1, 1, 1, 1}, 3);
    }

    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, -1);

        System.out.println(answer);
        return answer;
    }

    private void dfs(int[] numbers, int target, int sum, int idx) {
        if (idx == numbers.length - 1) {
            if (sum == target) answer++;
            return;
        }

        dfs(numbers, target, sum + numbers[idx + 1], idx + 1);
        dfs(numbers, target, sum - numbers[idx + 1], idx + 1);
    }
}
