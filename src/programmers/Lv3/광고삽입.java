package programmers.Lv3;

public class 광고삽입 {
    public static void main(String[] args) {
        광고삽입 test = new 광고삽입();
        test.solution("02:03:55", "00:14:15",
                new String[]{
                        "01:20:15-01:45:14",
                        "00:40:31-01:00:00",
                        "00:25:50-00:48:29",
                        "01:30:59-01:53:29",
                        "01:37:44-02:02:30"
                });

    }

    public String solution(String play_time, String adv_time, String[] logs) {
        int play = dateToSec(play_time);
        int adv = dateToSec(adv_time);
        int maxSize = 360001;
        long[] arr = new long[maxSize];
        for (String x : logs) {
            int start = dateToSec(x.substring(0, 8));
            int end = dateToSec(x.substring(9));
            arr[start]++;
            arr[end]--;
        }


        for (int i = 1; i < play; i++) {
            arr[i] += arr[i - 1];
        }
        for (int i = 1; i < play; i++) {
            arr[i] += arr[i - 1];
        }

        long max = arr[adv];
        int res = 0;
        for (int start = adv; start < play; start++) {
            long sum = arr[start] - arr[start - adv];

            if (sum > max) {
                max = sum;
                res = start - adv + 1;
            }
        }

        int a = 0, b = 0;
        if (res / 3600 != 0) {
            a = res / 3600;
            res %= 3600;
        }
        if (res / 60 != 0) {
            b = res / 60;
            res %= 60;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%1$02d", a)).append(":");
        sb.append(String.format("%1$02d", b)).append(":");
        sb.append(String.format("%1$02d", res));
        System.out.println(sb);
        return sb.toString();
    }

    private int dateToSec(String str) {
        int ret = 0;
        ret += Integer.parseInt(str.substring(0, 2)) * 3600;
        ret += Integer.parseInt(str.substring(3, 5)) * 60;
        ret += Integer.parseInt(str.substring(6, 8));

        return ret;
    }
}
