package BOJ.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _2822 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(new Pair(i, sc.nextInt()));
        }
        list.sort((o1, o2) -> o2.score-o1.score);



        List<Integer> tmp = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += list.get(i).score;
            tmp.add(list.get(i).idx+1);
        }
        Collections.sort(tmp);
        StringBuilder sb = new StringBuilder();
        for(int x : tmp){
            sb.append(x+" ");
        }
        System.out.println(sum);
        System.out.println(sb.toString());
    }
    public static class Pair{
        int idx;
        int score;

        public Pair(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }
    }
}
