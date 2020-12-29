package BOJ.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _5719 {
    static int n, m, start, end, max = 987654321;
    static ArrayList<Edge>[] list;
    static ArrayList<Integer>[] tmp;
    static int[] arr;

    private static class Edge {
        int v;
        int dis;

        public Edge(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 0 0이 나올떄까지 무한 반복
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            // 장소의 수 , 도로의 수
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            // 종료
            if (n == 0 && m == 0) break;

            // 시작 정점 , 끝나는 정점
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            arr = new int[n];
            tmp = new ArrayList[n];
            /* 값을 넣을때 초기화할 예정
            for (int i = 0; i < n; i++) {
                tmp[i] = new ArrayList();
            }*/

            // 간선 연결 정보
            list = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list[a].add(new Edge(b, c));
            }

            solve(true);
            deleteEdge();
            solve(false);

            // 결과 print
            System.out.println(arr[end] == max ? -1 : arr[end]);

        }
    }

    // 다익스트라
    // onOff 가 true 일 경우 삭제를 위한 값을 tmp 에 저장
    private static void solve(boolean onOff) {
        // 우선순위 큐 , edge 의 dis 를 기준으로 설정
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.dis));
        queue.add(new Edge(start, 0));

        // 방문 정보 초기화
        Arrays.fill(arr, max);
        arr[start] = 0;

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();

            // 끝점일 경우 return
            if (cur.v == end) return;

            // 지금 꺼낸것보다 더 짧은 경로가 있을 경우 넘어간다
            if (cur.dis > arr[cur.v]) continue;

            for (Edge next : list[cur.v]) {
                if (arr[next.v] > arr[cur.v] + next.dis) {
                    arr[next.v] = arr[cur.v] + next.dis;
                    queue.add(new Edge(next.v, arr[next.v]));

                    if (onOff) {
                        tmp[next.v] = new ArrayList<>();
                        tmp[next.v].add(cur.v);
                    }
                }
                // 거리가 같을 수도 있으므로
                else if (onOff && arr[next.v] == arr[cur.v] + next.dis) {
                    tmp[next.v].add(cur.v);
                }
            }
        }
    }

    // bfs
    private static void deleteEdge() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n];
        queue.add(end);
        visit[end] = true;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            // 앞선 다익스트라에서 값이 있을 경우만 초기화 했으므로
            // null 일 경우 continue
            if(tmp[cur] == null) continue;
            for(int next : tmp[cur]){
                if(!visit[next]){
                    visit[next] = true;
                    queue.add(next);
                }
                // 중첩리스트를 조회하여 해당 값 삭제
                for (int i = 0; i < list[next].size(); i++) {
                    if(list[next].get(i).v == cur){
                        list[next].remove(i);
                        break;
                    }
                }
            }
        }
    }
}
