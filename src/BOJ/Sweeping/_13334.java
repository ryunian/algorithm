package BOJ.Sweeping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _13334 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Way[] way = new Way[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a<b){
                way[i] = new Way(a,b);
            }else{
                way[i] = new Way(b,a);
            }
        }
        int size = Integer.parseInt(br.readLine());

//        Arrays.sort(way, (o1, o2) -> o1.x - o2.x);
        // y 기준으로 오름차순 정렬, y 가 같을 경우 x기준으로 오름차순 정렬
        Arrays.sort(way, Comparator.comparing(Way::getY).thenComparing(Way::getX));
        PriorityQueue<Integer> pq = new PriorityQueue();
        int max = 0;
        for (int i = 0; i < n; i++) {
            // dis = 사무실(y)를 기준으로 size만큼 떨어져있는 집(x)의 최대 거리
            int dis = way[i].y - size;
            if(dis <= way[i].x){
                // 최대거리 안에 있을 경우 우선순위 큐에 넣는다.
                // ex) 5(x), 40(y) 의 경우 dis값이 10이므로 포함되지 않는다.
                pq.add(way[i].x);
            }

            // 우선순위큐에 집의 거리가 가장 낮은 순서대로 체크
            // dis값보다 낮을 경우 포함되지 않으므로 poll
            while(!pq.isEmpty()){
                if(pq.peek() < dis) {
                    pq.poll();
                }else{
                    // 더이상 없을 경우 stop
                    break;
                }
            }
            max = Math.max(max, pq.size());
        }
        System.out.println(max);

    }
    public static class Way{
        int x;
        int y;

        public Way(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
    }
}
