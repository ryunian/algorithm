package BOJ.Recursion;

import java.util.Scanner;

public class _17478 {
    static String[] str = {
            "\"재귀함수가 뭔가요?\"\n",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n",
            "라고 답변하였지.\n",
            "____",
            "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n"
    };
    static int n = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        solve(0);
        System.out.print(sb.toString());
    }

    private static void solve(int cnt) {
        if (cnt == n) {
            write(cnt, 0);
            write(cnt, 6);
            write(cnt, 4);
            return;
        }
        write(cnt, 0);
        write(cnt, 1);
        write(cnt, 2);
        write(cnt, 3);
        solve(cnt + 1);
        write(cnt, 4);
    }

    private static void write(int cnt, int idx) {
        for (int i = 0; i < cnt; i++) {
            sb.append(str[5]);
        }
        sb.append(str[idx]);
    }
}
