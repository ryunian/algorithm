package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Info> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int sum = 0;
            for (int j = 0; j < str.length(); j++) {
                int tmp = str.charAt(j);
                if('0' <= tmp & tmp <= '9'){
                    sum += tmp - '0';
                }
            }
            list.add(new Info(str, sum));
        }
        list.sort(Comparator.comparing(Info::getLength).thenComparing(Info::getSum).thenComparing(Info::getStr));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).str+"\n");
        }
        System.out.print(sb.toString());
    }
    private static class Info{
        String str;
        int sum;
        int length;

        public Info(String str, int sum) {
            this.str = str;
            this.sum = sum;
            this.length = str.length();
        }

        public String getStr() {
            return str;
        }

        public int getSum() {
            return sum;
        }

        public int getLength() {
            return length;
        }
    }
}
