package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 마인크래프트
public class _18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int k = 256 + 1;

        int[] arr = new int[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[val]++;
            }
        }
        ArrayList<Node> list = new ArrayList<>();

        // 2초 : 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다.
        // 1초 : 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다
        for (int height = 0; height < k; height++) {
            int time = 0;
            int block = b;
            for (int j = 0; j < k; j++) {
                if(arr[j] == 0) continue;
                int tmp = Math.abs(height - j) * arr[j];
                if (height < j) {
                    time += tmp * 2;
                    block += tmp;
                } else if (height > j) {
                    time += tmp;
                    block -= tmp;
                }
            }
            if(block >= 0){
                list.add(new Node(time, height, block));
            }
        }
        list.sort((o1, o2) -> {
            if(o1.time != o2.time) return o1.time - o2.time;
            return o2.height - o1.height;
        });
        Node res = list.get(0);
        System.out.println(res.time+" "+res.height);
    }


    static class Node {
        int time;
        int height;
        int block;

        public Node(int time, int height, int block) {
            this.time = time;
            this.height = height;
            this.block = block;
        }
    }
}
