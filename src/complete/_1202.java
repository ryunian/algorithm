package complete;

import java.io.*;
import java.util.*;

public class _1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 보석수
        int n = Integer.parseInt(st.nextToken());
        // 가방 수
        int k = Integer.parseInt(st.nextToken());

        // 보석의 무게 , 보석의 가격
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken()); // 무게
            arr[i][1] = Integer.parseInt(st.nextToken()); // 가격
        }

        // 각각 가방의 무게
        int[] weight = new int[k];
        for (int i = 0; i < k; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        // 무게를 기준으로 오름차순으로 정렬
        Arrays.sort(arr, ((a, b) -> (a[0] - b[0])));
        Arrays.sort(weight);


        // 우선 순위 큐를 이용한다
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());

        //
        long result = 0;
        int i = 0;

        for (int j = 0; j < k; j++) {
            // 보석의 무게가 가방의 무게이하일 경우
            // 해당 값이 없을 경우 우선순위 큐에 넣어둔 우선순위 값이 해당이 된다
            while (i < n && weight[j] >= arr[i][0]) {
                queue.add(arr[i][1]);
                i++;
            }
            if (!queue.isEmpty()) {
                result += queue.poll();
            }
        }
        System.out.println(result);
    }
}
