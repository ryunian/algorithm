package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) -1;

        ArrayList<Integer> list = new ArrayList<>();
        int n = 1;
        while (list.size() <= 1000){
            for (int i = 0; i < n; i++) {
                list.add(n);
            }
            n++;
        }
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}
