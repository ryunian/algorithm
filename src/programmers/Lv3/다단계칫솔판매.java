package programmers.Lv3;

import java.util.HashMap;

public class 다단계칫솔판매 {
    public static void main(String[] args) {
        다단계칫솔판매 test = new 다단계칫솔판매();
        test.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
                , new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}
                , new String[]{"young", "john", "tod", "emily", "mary"}
                , new int[]{12, 4, 2, 5, 10});

    }

    HashMap<String, Node> map;
    int length;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        map = new HashMap<>();
        length = enroll.length;
        for (int i = 0; i < length; i++) {
            map.put(enroll[i], new Node(referral[i], 0));
        }
        for (int i = 0; i < seller.length; i++) {
            solve(seller[i], amount[i] * 100);
        }

        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            answer[i] = map.get(enroll[i]).money;
        }
        return answer;
    }

    private void solve(String seller, int amount) {
        if (seller.equals("-")) {
            return;
        }
        Node cur = map.get(seller);

        int x = (int) (amount * 0.1);
        int myMoney = amount - x;
        cur.money += myMoney;
        if (x != 0) {
            solve(cur.parent, x);
        }
    }

    class Node {
        String parent;
        int money;

        public Node(String parent, int money) {
            this.parent = parent;
            this.money = money;
        }
    }
}
