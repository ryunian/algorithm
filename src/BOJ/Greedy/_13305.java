package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] road = new int[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n-1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        int[] liter = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            liter[i] = Integer.parseInt(st.nextToken());
        }


//        System.out.println(Arrays.toString(road));
//        System.out.println(Arrays.toString(liter));

        long price = 0;
        long x = liter[0];
        for (int i = 0; i < n-1; i++) {
            price += x * road[i];
            if(x > liter[i+1]) x = liter[i+1];
//            System.out.println(price);
        }
        System.out.println(price);
    }
}
