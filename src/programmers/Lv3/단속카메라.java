package programmers.Lv3;

import java.util.Arrays;
import java.util.Comparator;

class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0; // 카메라의 갯수
        int camera = -30001; // 카메라의 위치

        // 나간지점 기준 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        for (int[] route : routes) {
            // 진입 시점이 현재있는 카메라 위치에서 벗어 날경우
            if (camera < route[0]) {
                // 카메라 위치를 나간지점으로 업데이트
                camera = route[1];
                answer++;
            }
        }

        return answer;
    }
}