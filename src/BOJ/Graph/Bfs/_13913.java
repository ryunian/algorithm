package BOJ.Graph.Bfs;

// 숨바꼭질 4
import java.util.*;

public class _13913 {
    static int n, k, max = 100000;
    static int[] d = {-1, 1, 0};
    static int[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        solve();
    }

    private static void solve() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visit = new int[max + 1];
        Arrays.fill(visit, -1);
        visit[n] = n; // prev (root)

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == k) {
                break;
            }

            for (int i = 0; i < 3; i++) {
                int next = cur + d[i];
                if (i == 2) next *= 2;
                if (next < 0 || next > max) continue;
                if (visit[next] != -1) continue;
                visit[next] = cur;

                queue.add(next);
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        while (stack.peek() != n) {
            int cur = stack.peek();
            int prev = visit[cur];
            stack.push(prev);
        }
        sb.append(stack.size() - 1).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb);
    }
}
