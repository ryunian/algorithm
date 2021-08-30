package programmers.Lv3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 매칭점수 {
    public static void main(String[] args) {
        매칭점수 test = new 매칭점수();
        test.solution("blind", new String[]{
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"
        });
        test.solution("Muzi", new String[]{
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"
        });
    }

    Map<Integer, Node> map;
    Map<String, Integer> mapping;

    public int solution(String word, String[] pages) {
        word = word.toLowerCase();
        map = new HashMap<>();
        mapping = new HashMap<>();

        int length = pages.length;
        for (int i = 0; i < pages.length; i++) {
            pages[i] = pages[i].toLowerCase();
        }
        for (int i = 0; i < length; i++) {
            findAddr(pages[i], i);
        }
        for (int i = 0; i < length; i++) {
            findWord(pages[i], word, i);
        }
        for (int i = 0; i < length; i++) {
            findOutSide(pages[i], i);
        }

        double max = 0;
        int answer = 0;
        for (int i = 0; i < length; i++) {
            double sum = map.get(i).score1 + map.get(i).score2;
            if (max < sum) {
                max = sum;
                answer = i;
            }
        }
        return answer;
    }

    private void findAddr(String str, int idx) {
        String[] arr = str.split("\"");
        map.put(idx, new Node(0, 0));

        for (int i = 0; i < arr.length; i++) {
            String tmp = arr[i].trim();
            if (tmp.equals("content=")) {
                if (arr[i - 2].indexOf("<meta property=") == -1) continue;
                if (arr[i - 1].indexOf("og:url") == -1) continue;
                if (arr[i + 1].indexOf("https://") == -1) continue;
                mapping.put(arr[i + 1], idx);
                return;
            }
        }
    }

    private void findWord(String str, String word, int idx) {
        Pattern p = Pattern.compile(word);
        Matcher m = p.matcher(str);

        while (m.find()) {
            char a = str.charAt(m.start() - 1);
            char b = str.charAt(m.end());
            if ('a' < a && a < 'z') continue;
            if ('a' < b && b < 'z') continue;
            map.get(idx).score1++;
        }
    }

    private void findOutSide(String str, int idx) {
        String[] arr = str.split("\"");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String tmp = arr[i].trim();
            if (tmp.indexOf("<a href=") != -1) {
                if (arr[i + 1].indexOf("https://") == -1) continue;
                if (arr[i + 2].charAt(0) != '>') continue;
                list.add(arr[i + 1]);
            }
        }

        double val = map.get(idx).score1 / list.size();
        for (String x : list) {
            if (!mapping.containsKey(x)) continue;
            int outside = mapping.get(x);
            map.get(outside).score2 += val;
        }
    }


    static class Node {
        double score1;
        double score2;

        public Node(double score1, double score2) {
            this.score1 = score1;
            this.score2 = score2;
        }
    }
}