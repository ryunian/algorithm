package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringTokenizer;

public class _8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) * -1;
            int c = Integer.parseInt(st.nextToken()) * -1;
            int d = Integer.parseInt(st.nextToken()) * -1;
            arr[i] = new Node(a, b, c, d);
        }
        Arrays.sort(arr, Comparator.comparing(Node::getA).thenComparing(Node::getB).thenComparing(Node::getC));
        if (arr[0].idx == m) {
            System.out.println(1);
            return;
        }

        int tmp = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i].equals(arr[i - 1])) {
                tmp++;
            } else {
                tmp = 0;
            }
            if (arr[i].idx == m) {
                System.out.println(i + 1 - tmp);
                break;
            }
        }
    }

    private static class Node {
        int idx;
        int a;
        int b;
        int c;

        public Node(int idx, int a, int b, int c) {
            this.idx = idx;
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getC() {
            return c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return a == node.a &&
                    b == node.b &&
                    c == node.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }
}
