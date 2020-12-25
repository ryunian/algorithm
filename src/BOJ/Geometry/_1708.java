package BOJ.Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

// 블록껍질 알고리즘
// 시계방향, 반시계방향 정렬
public class _1708 {
    static ArrayList<Pair> list = new ArrayList<>();
    // 시작 좌표
    static Pair start = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            list.add(new Pair(x, y));

            // y축 값이 가장 작은 좌표
            if (y < start.y) {
                start = new Pair(x, y);
            }
            // y축이 값이 같은것이 있을 경우 x축중에서 가장 작은 좌표
            else if (y == start.y && x < start.x) {
                start = new Pair(x, y);
            }
        }

        // 반시계방향으로 정렬
        list.sort(new Comparator<Pair>() {
            Pair a = start;

            @Override
            public int compare(Pair b, Pair c) {
                int ccwVal = ccw(a, b, c);
                if (ccwVal == -1) {
                    return 1;
                } else if (ccwVal == 1) {
                    return -1;
                } else {
                    long dist1 = dist(a, b);
                    long dist2 = dist(a, c);
                    if (dist1 > dist2) return 1;
                    else return -1;
                }
            }
        });

        Stack<Pair> stack = new Stack();
        stack.push(start);
        for (int i = 1; i < n; i++) {
            while (stack.size() >= 2) {
                Pair a = stack.get(stack.size() - 2);
                Pair b = stack.get(stack.size() - 1);
                Pair c = list.get(i);

                // 점a,b로 이루어진 선분보다 c가 왼쪽에 있거나 같은 선상에 있을 경우 제외
                if (ccw(a, b, c) <= 0) {
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(list.get(i));
        }
        System.out.println(stack.size());
    }

    private static long dist(Pair a, Pair b) {
        return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
    }

    // 반시계 방향(counter clockwise)
    private static int ccw(Pair a, Pair b, Pair c) {
        // 해당값 안에서 int값의 범위가 초과 할수 있기 때문에
        // pair의 자료형을 long으로 설정해야 한다.
        long ccwR = (a.x * b.y + b.x * c.y + c.x * a.y) - (b.x * a.y + c.x * b.y + a.x * c.y);
        // 반시계방향
        if (ccwR > 0) {
            return 1;
        }
        // 시계방향
        else if (ccwR < 0) {
            return -1;
        }
        // 직선상
        else {
            return 0;
        }
    }

    private static class Pair {
        long x;
        long y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
