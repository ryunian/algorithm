package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            char[] x = br.readLine().toCharArray();
            tree.add(x[0],x[2],x[4]);
        }
        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);

    }
    private static class Node{
        char data;
        Node left;
        Node right;

        public Node(char data){
            this.data = data;
        }
    }
    private static class Tree{
        Node root;

        public Tree(){
            root = new Node('A');
        }
        public void add(char data, char left, char right){
            if(root.data == data){
                if(left != '.') root.left = new Node(left);
                if(right != '.') root.right = new Node(right);
            }else {
                next(root.left, data, left, right);
                next(root.right, data, left, right);
            }
        }

        private void next(Node node, char data, char left, char right) {
            if(node == null){
                return;
            }else if(node.data == data){
                if(left != '.') node.left = new Node(left);
                if(right != '.') node.right = new Node(right);
            }else{
                next(node.left, data, left, right);
                next(node.right, data, left, right);
            }

        }

        public void preorder(Node node){
            System.out.print(node.data);
            if(node.left != null) preorder(node.left);
            if(node.right != null) preorder(node.right);

        }
        public void inorder(Node node){
            if(node.left != null) inorder(node.left);
            System.out.print(node.data);
            if(node.right != null) inorder(node.right);

        }
        public void postOrder(Node node){
            if(node.left != null) postOrder(node.left);
            if(node.right != null) postOrder(node.right);
            System.out.print(node.data);
        }

    }
}
