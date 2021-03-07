package programmers.Lv2;


public class 멀쩡한사각형 {
    public static void main(String[] args) {
        멀쩡한사각형 test = new 멀쩡한사각형();
        System.out.println(test.solution(8, 12));
    }

    public long solution(int w, int h) {
        long a = w;
        long b = h;
        long max = a * b;
        long delRec = a + b - gcd(a, b);

        return max - delRec;
    }

    public long gcd(long x, long y) {
        if (x < y) gcd(y, x);
        return y == 0 ? x : gcd(y, x % y);
    }
}
