package programmers.Lv1;

public class 신규아이디추천 {
    public static void main(String[] args) {
        신규아이디추천 test = new 신규아이디추천();
        test.solution("...!@BaT#*..y.abcdefghijklm");
        test.solution("z-+.^.");
        test.solution("=.=");
        test.solution("123_.def");
        test.solution("abcdefghijklmn.p");
        test.solution("");
    }

    public String solution(String new_id) {
        // new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = lv1(new_id);

        // new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        new_id = lv2(new_id);

        // new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        new_id = lv3(new_id);

        // new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        new_id = lv4(new_id);

        // new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        new_id = lv5(new_id);

        // new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다
        new_id = lv6(new_id);

        // new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        new_id = lv7(new_id);
        return new_id;
    }

    private String lv7(String new_id) {
        if (new_id.length() <= 2) {
            return lv7(new_id + new_id.charAt(new_id.length() - 1));
        }
        return new_id;
    }

    private String lv6(String new_id) {
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            return lv4(new_id);
        }
        return new_id;
    }

    private String lv5(String new_id) {
        if (new_id.length() == 0) return "a";
        return new_id;
    }

    private String lv4(String new_id) {
        if (new_id.length() == 0) return new_id;

        if (new_id.charAt(0) == '.') {
            return lv4(new_id.substring(1));
        }
        if (new_id.charAt(new_id.length() - 1) == '.') {
            return lv4(new_id.substring(0, new_id.length() - 1));
        }
        return new_id;
    }

    private String lv3(String new_id) {
        if (new_id.indexOf("..") == -1) return new_id;

        return lv3(new_id.replace("..", "."));
    }

    private String lv2(String new_id) {
        return new_id.replaceAll("[^0-9a-z-_.]", "");
    }

    private String lv1(String answer) {
        return answer.toLowerCase();
    }
}
