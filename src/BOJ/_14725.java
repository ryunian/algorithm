package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _14725 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Node root = new Node();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int leng = Integer.parseInt(st.nextToken());

            Node node = root;
            for (int j = 0; j < leng; j++) {
                String str = st.nextToken();
                if (!node.child.containsKey(str)) {
                    node.child.put(str, new Node());
                }
                node = node.child.get(str);
            }
        }

        find(root, 0);
        System.out.println(sb.toString());
    }

    private static void find(Node node, int cnt) {
        Iterator<String> it = node.child.keySet().iterator();
        while (it.hasNext()) {
            for (int i = 0; i < cnt; i++) {
                sb.append("--");
            }
            String str = it.next();
            sb.append(str).append("\n");
            find(node.child.get(str), cnt + 1);
        }
    }

    private static class Node {
        private TreeMap<String, Node> child;

        public Node() {
            child = new TreeMap<String, Node>();
        }
    }
}
