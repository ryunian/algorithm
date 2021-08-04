package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _21774 {
    public static Map<Integer, List<Long>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        while (n-- > 0) {
            String[] tmp = br.readLine().replaceAll("[-: ]", "").split("#");
            long date = Long.parseLong(tmp[0]);
            int logLv = Integer.parseInt(tmp[1]);

            map.put(logLv, map.getOrDefault(logLv , new ArrayList<>()));
            map.get(logLv).add(date);
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String[] tmp = br.readLine().split("#");
            long a = Long.parseLong(tmp[0].replaceAll("[-:# ]", ""));
            long b = Long.parseLong(tmp[1].replaceAll("[-:# ]", "")) + 1;
            int c = Integer.parseInt(tmp[2]);

            int res = 0;
            for (int i = c; i <= 6; i++) {
                if (map.get(i) == null) continue;
                int max = binarysearch(b, i);
                int min = binarysearch(a, i);

                res += max - min;
            }

            sb.append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    // lowerBound
    private static int binarysearch(long val, int logLv) {
        int left = 0;
        int right = map.get(logLv).size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (map.get(logLv).get(mid) < val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
