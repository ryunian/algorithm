package programmers.Lv2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 파일명정렬 {
    public static void main(String[] args) {
        파일명정렬 test = new 파일명정렬();
        test.solution(new String[]{"img12", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
    }

    public String[] solution(String[] files) {
        List<File> list = parse(files);
        list.sort(Comparator.comparing(File::getHead).thenComparing(File::getNum));

        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
            File file = list.get(i);
            answer[i] = file.head + file.num + file.tail;
        }

        return answer;
    }

    private List<File> parse(String[] files) {
        List<File> list = new ArrayList<>();
        Pattern p = Pattern.compile("[0-9]+");
        for (String str : files) {
            Matcher matcher = p.matcher(str);
            if (matcher.find()) {
                String a = str.substring(0, matcher.start());
                String b = matcher.group();
                String c = str.substring(matcher.end());
                list.add(new File(a, b, c));
            }
        }
        return list;
    }

    private static class File {
        String head;
        String num;
        String tail;

        public File(String head, String num, String tail) {
            this.head = head;
            this.num = num;
            this.tail = tail;
        }

        public String getHead() {
            return head.toLowerCase();
        }

        public int getNum() {
            return Integer.parseInt(num);
        }
    }
}
