package BOJ.DataStructures.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Trie
// TrieMap , 구현은 쉽지만 시간이 더 소모된다.
public class _14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Trie trie = new Trie();
        while (n-- > 0) {
            trie.insert(br.readLine());
        }
        int res = 0;
        while (m-- > 0) {
            String str = br.readLine();
            if (trie.isFind(str)) {
                res++;
            }
        }
        System.out.println(res);
    }

    private static class TrieNode {
        private char c;
        private TrieNode[] child;
        private boolean isLeaf;

        public TrieNode(char c) {
            this.c = c;
            this.child = new TrieNode[26];
            this.isLeaf = false;
        }
    }

    private static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode('\0');
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int idx = c - 'a';

                if (cur.child[idx] == null) {
                    TrieNode node = new TrieNode(c);
                    cur.child[idx] = node;
                    cur = node;
                } else {
                    cur = cur.child[idx];
                }
            }
            cur.isLeaf = true;
        }

        public boolean isFind(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                if (cur == null) {
                    return false;
                }
                char c = word.charAt(i);
                int idx = c - 'a';
                cur = cur.child[idx];
            }
            if (cur == null || !cur.isLeaf) {
                return false;
            } else {
                return true;
            }
        }
    }


    // hashmap을 이용한 버전 , 시간초과 난다.
    private static class TrieNodeMap {
        Map<Character, TrieNodeMap> child = new HashMap<>();
        boolean isLeaf;
    }

    private static class TrieMap {
        private TrieNodeMap root;

        public TrieMap() {
            this.root = new TrieNodeMap();
        }

        public void insert(String word) {
            TrieNodeMap current = root;
            for (int i = 0; i < word.length(); i++) {
                current = current.child.computeIfAbsent(word.charAt(i), key -> new TrieNodeMap());
            }
            current.isLeaf = true;
        }

        public boolean isFind(String word) {
            TrieNodeMap current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (current.child.get(c) == null) return false;
                current = current.child.get(c);
            }
            return current.isLeaf ? true : false;
        }
    }
}

