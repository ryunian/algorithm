package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> crane = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        crane.sort((o1, o2) -> o2 - o1);
        box.sort((o1, o2) -> o2 - o1);

        if (crane.get(0) < box.get(0)) {
            System.out.println(-1);
        } else {
            int res = 0;
            while (box.size() != 0) {
                int craneIdx = 0;
                int boxIdx = 0;
                while (craneIdx < n) {
                    if (boxIdx == box.size()) break;

                    if (crane.get(craneIdx) >= box.get(boxIdx)) {
                        box.remove(boxIdx);
                        craneIdx++;
                    } else if (crane.get(craneIdx) < box.get(boxIdx)) {
                        boxIdx++;
                    }
                }
                res++;
            }
            System.out.println(res);
        }
    }
}
