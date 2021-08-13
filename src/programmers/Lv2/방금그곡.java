package programmers.Lv2;

public class 방금그곡 {
    public static void main(String[] args) {
        방금그곡 test = new 방금그곡();
        test.solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"});
        test.solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"});
        test.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"});
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = replaceStr(m);
        int max = 0;
        for (int i = 0; i < musicinfos.length; i++) {
            String[] str = musicinfos[i].split(",");
            int time = toSec(str[1]) - toSec(str[0]);
            String tmp = replaceStr(str[3]);

            StringBuilder sb = new StringBuilder();
            while (sb.length() < time) {
                sb.append(tmp);
            }
            sb.setLength(time);
            if (sb.toString().indexOf(m) != -1 && max < time) {
                answer = str[2];
                max = time;
            }
        }
        //System.out.println(answer);
        return answer;
    }

    public String replaceStr(String str) {
        str = str.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
        return str;
    }


    public int toSec(String str) {
        String[] arr = str.split(":");
        int ret = 0;
        ret += Integer.parseInt(arr[0]) * 60;
        ret += Integer.parseInt(arr[1]);
        return ret;
    }
}
