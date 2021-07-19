package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> note = new HashSet<>();
        Set<String> post = new HashSet<>();

        while (n-->0){
            note.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        while (m-->0){
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()){
                String keyWord = st.nextToken();
                if(!post.contains(keyWord)){
                    note.remove(keyWord);
                    post.add(keyWord);
                }
            }
            sb.append(note.size()+"\n");
        }
        System.out.print(sb.toString());
    }
}
