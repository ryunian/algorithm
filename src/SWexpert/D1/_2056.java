package SWexpert.D1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class _2056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        SimpleDateFormat parse = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat fomat = new SimpleDateFormat("yyyy/MM/dd");
        parse.setLenient(false);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            String str = sc.nextLine();
            try {
                Date date = parse.parse(str);
                sb.append("#").append(i).append(" ").append(fomat.format(date)).append("\n");
            } catch (ParseException e) {
                sb.append("#").append(i).append(" -1\n");
            }
        }
        System.out.print(sb.toString());
    }
}