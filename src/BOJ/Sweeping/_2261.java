package BOJ.Sweeping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2261 {
    private static class Matrix {
        int x;
        int y;

        public Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Matrix> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new Matrix(a, b));
        }
        // x를 기준으로 정렬
        arr.sort(Comparator.comparing(o -> o.x));
        System.out.println(solve(arr, 0, n - 1));
    }

    private static int solve(ArrayList<Matrix> arr, int start, int end) {
        int size = end - start + 1;
        // 분할된 x 좌표상의 크기가 3이하일 경우
        if (size <= 3) {
            // 가장 가까운 점의 거리를 구한다.
            return bruteForce(arr, start, end);
        }

        // 좌우로 분할
        int mid = (start + end) / 2;
        int left = solve(arr, start, mid);
        int right = solve(arr, mid + 1, end);

        // left side 와 right side 에서 구한 최소 거리중 더 작은 값을 임시 저장
        int ret = Math.min(left, right);

        List<Matrix> tmp = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            // 중앙을 기준으로 거리를 비교
            int d = arr.get(i).x - arr.get(mid).x;
            // 좌표간 거리가 현재 최소거리인 ret 보다 작은 경우 임시 리스트에 삽입
            if (d * d < ret) {
                tmp.add(arr.get(i));
            }
        }

        // x좌표 기준은 무의미 하므로 y 기준으로 정렬한다.
        tmp.sort(Comparator.comparingInt(o -> o.y));

        for (int i = 0; i < tmp.size() - 1; i++) {
            for (int j = i + 1; j < tmp.size(); j++) {
                int k = tmp.get(j).y - tmp.get(i).y;
                if (k * k < ret) {
                    int temp = calculator(tmp.get(i), tmp.get(j));
                    if (ret > temp) {
                        ret = temp;
                    }
                }
                // y좌표 기준 오름차순 정렬했기 때문에 기준점과 가장 가까운 좌표가 ret 보다 클경우
                // 다음 좌표는 무의미하므로 j 반복문은 break 한다.
                else {
                    break;
                }
            }

        }
        return ret;
    }

    private static int bruteForce(ArrayList<Matrix> arr, int start, int end) {
        int ret = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                int temp = calculator(arr.get(i), arr.get(j));
                if (ret > temp) {
                    ret = temp;
                }
            }
        }
        return ret;
    }

    private static int calculator(Matrix m1 , Matrix m2){
        return (m1.x - m2.x) * (m1.x - m2.x) + (m1.y - m2.y) * (m1.y - m2.y);
    }
}