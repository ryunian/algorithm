package programmers.Lv1;

public class 다음큰숫자 {
    public static void main(String[] args) {
        다음큰숫자 test = new 다음큰숫자();
        test.solution(78);
    }
    public int solution(int n) {
        String str = Integer.toBinaryString(n);
        int cnt = 0;
        for (char s : str.toCharArray()) {
            if(s == '1') cnt++;
        }

        int num = n+1;
        while (true){
            if(check(num) == cnt) break;
            num++;
        }

        System.out.println(num);
        return num;
    }

    private int check(int num) {
        String str = Integer.toBinaryString(num);
        int cnt = 0;
        for (char s : str.toCharArray()) {
            if(s == '1') cnt++;
        }
        return cnt;
    }

}
