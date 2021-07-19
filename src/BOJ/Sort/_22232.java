package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 람다를 이용한 다중 정렬
public class _22232 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList<>();
        while (n-- > 0){
            st = new StringTokenizer(br.readLine(), ".");
            list.add(new Node(st.nextToken(), st.nextToken()));
        }
        Set<String> set = new HashSet<>();
        while (m-- > 0) {
            set.add(br.readLine());
        }

        // 정렬
        Comparator<Node> chk = Comparator.comparingInt(o -> (set.contains(o.extension) == true ? -1 : 1));
        list.sort(Comparator.comparing(Node::getStr).thenComparing(chk).thenComparing(Node::getExtension));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).str).append(".").append(list.get(i).extension).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static class Node {
        String str;
        String extension;

        public Node(String str, String extension) {
            this.str = str;
            this.extension = extension;
        }

        public String getStr() {
            return str;
        }

        public String getExtension() {
            return extension;
        }
    }
}
