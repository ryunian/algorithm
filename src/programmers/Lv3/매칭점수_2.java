package programmers.Lv3;

import java.util.*;
import java.util.regex.*;

public class 매칭점수_2 {
    public static void main(String[] args) {
        매칭점수_2 test = new 매칭점수_2();
        test.solution("blind", new String[]{
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"
        });
        test.solution("Muzi", new String[]{
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"
        });
    }

    private int length;
    private Map<Integer, Node> map;
    private Map<String, Integer> mapping;
    private Pattern myUrlPattern = Pattern.compile("(?i)<meta property=\"og:url\" content=\"https://(.+?)\"/>");
    private Pattern outSidePattern = Pattern.compile("(?i)<a href=\"https://(.+?)\">");

    public int solution(String word, String[] pages) {
        map = new HashMap<>();
        mapping = new HashMap<>();
        length = pages.length;

        findAddr(pages);
        findWord(pages, word);
        findOutSide(pages);

        double max = 0;
        int ret = 0;
        for (int i = 0; i < length; i++) {
            double sum = map.get(i).score1 + map.get(i).score2;
            if (max < sum) {
                max = sum;
                ret = i;
            }
        }
        return ret;
    }

    private void findAddr(String[] pages) {
        for (int i = 0; i < length; i++) {
            map.put(i, new Node(0, 0));
            Matcher matcher = myUrlPattern.matcher(pages[i]);
            if (matcher.find()) {
                mapping.put(matcher.group(1), i);
            }
        }
    }

    private void findWord(String[] pages, String word) {
        for (int i = 0; i < length; i++) {
            Pattern p = Pattern.compile("(?i)" + word);
            Matcher m = p.matcher(pages[i]);
            while (m.find()) {
                char a = pages[i].charAt(m.start() - 1);
                char b = pages[i].charAt(m.end());
                if ('a' < a && a < 'z') continue;
                if ('a' < b && b < 'z') continue;
                map.get(i).score1++;
            }
        }
    }

    private void findOutSide(String[] pages) {
        for (int i = 0; i < length; i++) {
            List<String> list = new ArrayList<>();
            Matcher matcher = outSidePattern.matcher(pages[i]);

            while (matcher.find()) {
                list.add(matcher.group(1));
            }

            double val = map.get(i).score1 / list.size();
            for (String x : list) {
                if (!mapping.containsKey(x)) continue;
                int outside = mapping.get(x);
                map.get(outside).score2 += val;
            }
        }
    }

    private static class Node {
        double score1;
        double score2;

        public Node(double score1, double score2) {
            this.score1 = score1;
            this.score2 = score2;
        }
    }
}

