package BOJ.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// i에서 N번 이동해서 j로 가는 경우의 수는 인접행렬의 N제곱의 (i, j) 값이다.
// 가중치가 없는 그래프인 경우, 0 또는 1로 이루어진 그래프의 인접 행렬이 주어질 때
// i에서 N번 이동해서 j로 가는 경우의 수는 인접행렬의 N제곱의 (i, j) 값이다.
// 이를 이용하기 위해서 가중치가 주어지는 이 문제의 그래프를 조금 변형시킨다.
// 가중치가 5이하이기 때문에 각 정점을 5개로 나누어준다.
// 예를 들어서 i번 정점이라고 한다면, i , i-1 , i-2 , i-3 , i-4 로 나누어서, 각 정점 사이를 1분 만에 이동할 수 있도록 해주는 것이다.
// 따라서 j에서 i로 가는데 3분이 필요하다면 j와 i-2를 연결시켜준다.
// 그러면 j에서 1초후에는 i-2로 이동하고, 2초 후에는 i-1, 3초 후에는 i에 도착할 수 있게 된다.
// 이를 구현하기 위해서 각 정점의 번호를 5*i , 5*i - 1 , 5*i - 2 , 5*i - 3 , 5*i - 4 로 나타내고, 그래프를 만들어준다.
// 시간 복잡도는 O((5N)3logT)O((5N)3logT) 이다.
// 출처 https://wogud6792.tistory.com/77
public class _1533 {
    static int size, start, end, time, mod = 1000003;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        size = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());

        // 간선의 길이가 5이하의 조건
        // 한 정점당 4개의 정점을 추가로 만든다.(*5)
        long[][] matrix = new long[size * 5 + 1][size * 5 + 1];
        long[][] ans = new long[size * 5 + 1][size * 5 + 1];
        for (int i = 1; i <= size; i++) {
            char[] x = br.readLine().toCharArray();
            for (int j = 1; j <= size; j++) {
                if (x[j - 1] - '0' >= 1) {
                    matrix[i * 5][j * 5 - (x[j - 1] - '0' - 1)] = 1;
                }
            }
            for (int j = 1; j <= 4; j++) {
                matrix[(i - 1) * 5 + j][(i - 1) * 5 + j + 1] = 1;
            }
        }
        for (int i = 1; i <= 5 * size; i++) {
            ans[i][i] = 1;
        }

        solve(ans, matrix);
    }

    private static void solve(long[][] ans, long[][] matrix) {
        while (time != 0) {
            if (time % 2 == 1) {
                ans = calculation(ans, matrix);
            }
            time /= 2;
            matrix = calculation(matrix, matrix);

        }

        /*for (long[] a : ans) {
            for (long b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }*/

        System.out.println(ans[start * 5][end * 5]);
    }

    // 인접행렬의 제곱 계산
    private static long[][] calculation(long[][] a, long[][] b) {
        long[][] ret = new long[size * 5 + 1][size * 5 + 1];
        for (int i = 1; i <= size * 5; i++) {
            for (int j = 1; j <= size * 5; j++) {
                for (int k = 1; k <= size * 5; k++) {
                    ret[i][j] += a[i][k] * b[k][j];
                    // 개수를 문제에 제시된 1,000,003으로 나눈다.
                    ret[i][j] %= mod;
                }
            }
        }
        return ret;
    }
}
