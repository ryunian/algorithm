package BOJ.DataStructures.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                trie.insert(str);
                arr[i] = str;
            }

            System.out.println(trie.root.child[9].child[2].child[1].isleaf);
            System.out.println(trie.root.child[9].child[1].child[1].isleaf);
            System.out.println();

            boolean check = true;
            for (int i = 0; i < n; i++) {
                check = trie.checkConsist(arr[i]);
                if (!check) break;
            }
            if (check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    private static class TrieNode {
        private char c;
        private TrieNode[] child;
        private boolean isleaf;

        public TrieNode(char c) {
            this.isleaf = false;
            this.c = c;
            this.child = new TrieNode[26];
        }

        public boolean isLeaf() {
            return this.isleaf;
        }

        public void setLeaf(boolean isleaf) {
            this.isleaf = isleaf;
        }

        public TrieNode getChild(int index) {
            return this.child[index];
        }

        public void setChild(TrieNode node, int index) {
            this.child[index] = node;
        }

    }

    private static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode('\0');
        }

        public void insert(String word) {
            TrieNode current = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - '0';

                if (current.getChild(index) == null) {
                    TrieNode node = new TrieNode(c);
                    current.setChild(node, index);
                    current = node;

                } else {
                    current = current.getChild(index);
                }
            }
            current.setLeaf(true);
        }

        public boolean checkConsist(String word) {
            TrieNode current = root;

            for (int i = 0; i < word.length(); i++) {
                if (current.isLeaf()) {
                    return false;
                }

                char c = word.charAt(i);
                int index = c - '0';
                current = current.getChild(index);
            }

            return true;
        }
    }
}











