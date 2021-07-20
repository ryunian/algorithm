package BOJ.Sort;

import java.io.*;

public class _10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int size = 10001;
        int[] cnt = new int[size];
        while (num-- > 0) {
            cnt[Integer.parseInt(br.readLine())]++;
        }
        for (int i = 1; i < size; i++) {
            while (cnt[i] > 0) {
                bw.append(i + "\n");
                cnt[i]--;
            }
        }

        bw.flush();
        bw.close();
    }
}