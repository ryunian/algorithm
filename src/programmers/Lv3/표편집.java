package programmers.Lv3;

import java.util.ArrayList;
import java.util.Stack;

public class 표편집 {
    public static void main(String[] args) {
        표편집 test = new 표편집();
        test.solution(8,2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"});
    }

    private ArrayList<Node> list;

    public String solution(int n, int k, String[] cmd) {
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i, new Node(i - 1, i + 1, true));
        }
        list.get(0).prev = -1;
        list.get(n - 1).next = -1;
        int idx = k;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < cmd.length; i++) {
            String[] str = cmd[i].split(" ");
            int cnt, prev, next;
            switch (str[0]) {
                case "D":
                    cnt = Integer.parseInt(str[1]);
                    idx = move(idx, cnt, true);
                    break;

                case "U":
                    cnt = Integer.parseInt(str[1]);
                    idx = move(idx, cnt, false);
                    break;

                case "C":
                    list.get(idx).isUse = false;
                    prev = list.get(idx).prev;
                    next = list.get(idx).next;
                    // 삭제된 노드를 스택에 저장
                    stack.push(idx);

                    if (next != -1) {
                        list.get(next).prev = prev;
                    }
                    if (prev != -1) {
                        list.get(prev).next = next;
                    }
                    if (next != -1) {
                        idx = next;
                    } else {
                        idx = prev;
                    }
                    break;
                case "Z":
                    int saveIdx = stack.pop();
                    list.get(saveIdx).isUse = true;
                    prev = list.get(saveIdx).prev;
                    next = list.get(saveIdx).next;
                    if (next != -1) {
                        list.get(next).prev = saveIdx;
                    }
                    if (prev != -1) {
                        list.get(prev).next = saveIdx;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (list.get(i).isUse) {
                sb.append("O");
            } else {
                sb.append("X");
            }
        }

        return sb.toString();
    }

    private int move(int idx, int cnt, boolean flag) {
        while (cnt-- > 0) {
            if (flag) {
                if(list.get(idx).next == -1) return idx;
                idx = list.get(idx).next;
            } else {
                if(list.get(idx).prev == -1) return idx;
                idx = list.get(idx).prev;
            }
        }
        return idx;
    }

    private class Node {
        int prev;
        int next;
        boolean isUse;

        public Node(int prev, int next, boolean isUse) {
            this.prev = prev;
            this.next = next;
            this.isUse = isUse;
        }
    }
}