package programmers.Lv2;

public class 스킬트리 {
    public static void main(String[] args) {
        스킬트리 test = new 스킬트리();
        test.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}); // 2
        test.solution("REA", new String[]{"REA", "POA"});
        test.solution("CBDK", new String[]{"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"}); // 4
        test.solution("BDC", new String[]{"AAAABACA"}); // 0
        test.solution("CBD", new String[]{"C", "D", "CB", "BDA"}); // 2

    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        boolean[] alpha = new boolean[26];
        for (int i = 0; i < skill.length(); i++) {
            int x = skill.charAt(i) - 'A';
            alpha[x] = true;
        }

        for (int i = 0; i < skill_trees.length; i++) {
            int idx = 0;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                char c = skill_trees[i].charAt(j);
                if (!alpha[c - 'A']) continue;
                if (skill.charAt(idx) == c) {
                    idx++;
                } else {
                    idx = -1;
                    break;
                }
            }
            if (idx != -1) {
                answer++;
            }
        }
        return answer;
    }
}
