package programmers;

import java.util.ArrayList;
import java.util.Comparator;

public class 섬연결하기 {
    public static void main(String[] args) {
        섬연결하기 test = new 섬연결하기();
        test.solution(4,
                new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}});

    }

    private int answer;
    private int[] num;
    private ArrayList<Node> list;

    public int solution(int n, int[][] costs) {
        list = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            list.add(new Node(costs[i][0], costs[i][1], costs[i][2]));
        }
        // 가격 기준으로 정렬
        list.sort(Comparator.comparingInt(o -> o.cost));

        // union-find를 위한 초기화
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i;
        }

        answer = 0;
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i).x;
            int y = list.get(i).y;
            int cost = list.get(i).cost;
            union(x,y, cost);
        }
        System.out.println(answer);

        return answer;
    }

    private class Node {
        int x;
        int y;
        int cost;

        private Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    private int find(int x) {
        if(num[x] == x){
            return x;
        }

        return num[x] = find(num[x]);
    }
    private void union(int x, int y, int cost){
        x = find(x);
        y = find(y);
        if(x == y){
            return;
        }else{
            answer += cost;
            num[x] = y;
        }
    }
}
