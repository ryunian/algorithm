package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _1013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        Pattern pattern = Pattern.compile("(100+1+|01)+");
        while (test-- > 0){
            String query = br.readLine();
            Matcher matcher = pattern.matcher(query);

            if(matcher.matches()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}