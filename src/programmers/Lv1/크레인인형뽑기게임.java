package programmers.Lv1;

import java.util.Stack;

public class 크레인인형뽑기게임 {
    public static void main(String[] args) {
        크레인인형뽑기게임 test = new 크레인인형뽑기게임();
        test.solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}},
                new int[]{1,5,3,5,1,2,1,4});


    }
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        int[] idxInfo = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[j][i] != 0){
                    idxInfo[i] = j;
                    break;
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < moves.length; i++) {
            int x = moves[i]-1;
            if(idxInfo[x] >= n) continue;
            int element = board[idxInfo[x]++][x];

            if(!stack.isEmpty() && stack.peek() == element){
                stack.pop();
                cnt+= 2;
            }else{
                stack.push(element);
            }
        }
//        System.out.println(cnt);

        return cnt;
    }
}
