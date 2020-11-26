package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class _3190 {
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 방향 오른쪽 오름차순, 왼쪽 내림차순
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 보드의 크기 n
        n = Integer.parseInt(br.readLine());
        // 사과의 개수 k
        k = Integer.parseInt(br.readLine());

        // 사과의 위치
        int[][] apple = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            apple[i][0] = Integer.parseInt(st.nextToken());
            apple[i][1] = Integer.parseInt(st.nextToken());
        }

        // 방향 변환 횟수 L
        // L = 왼쪽 , D = 오른쪽
        int l = Integer.parseInt(br.readLine());
        String[][] pos = new String[l][2];
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            pos[i][0] = st.nextToken();
            pos[i][1] = st.nextToken();
        }

        int cnt,i,x,y,z;
        cnt = i = z = 0;
        x = y = 1;
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{x,y});
        while (true) {
            int x2 = x + direction[z][0];
            int y2 = y + direction[z][1];

//            for(int[] asdf : list){
//                System.out.print(asdf[0] +" "+asdf[1]+"    ");
//            }
//            System.out.println();
            // 체크
            boolean check1 = isNotWall(x2,y2);
            boolean check2 = isNotMe(x2,y2,list);
//            System.out.println(check2);
            if(!check1 || !check2) break;

            // 이동
            boolean isApple = false;

            // 사과가 있는지 탐색
            for (int j = 0; j < k; j++) {
                if(x2 == apple[j][0] && y2 == apple[j][1]){
                    apple[j][0] = 0;
                    apple[j][1] = 0;
                    isApple = true;
                }
            }
            if(!isApple){
                // 사과가 없으므로 몸통 삭제
                list.remove(0);
            }
            list.add(new int[]{x2,y2});

            x = x2;
            y = y2;
            cnt++;

            // 방향 변경
            if(i != l && cnt == Integer.parseInt(pos[i][0])){
                if(pos[i][1].equals("D")){
//                    System.out.println("D");
                    z++;
                }else{
                    z--;
                }
                z = z == -1 ? 3 : z;
                z = z == 4 ? 0 : z;
                i++;
            }
//            System.out.println(z);
        }

        System.out.println(cnt+1);

    }

    // 다음칸이 막혀 있는지 체크
    private static boolean isNotWall(int x, int y) {
        return x > 0 && x <= n && y > 0 && y <= n;
    }

    // 다음칸이 자기 자신인지 체크
    private  static  boolean isNotMe(int x, int y, List<int[]> list){
        for(int[] z : list){
            if(z[0] == x && z[1]==y){
                return false;
            }
        }
        return true;
    }
}
