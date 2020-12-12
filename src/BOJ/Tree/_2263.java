package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2263 {
    static int[] inorder, postorder,position;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];
        position = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            position[inorder[i]-1] = i;
        }

//        System.out.println(Arrays.toString(inorder));
//        System.out.println(Arrays.toString(postorder));
//        System.out.println(Arrays.toString(position));

        solve(0, n - 1, 0, n - 1);
        System.out.println(sb.toString());
    }

    private static void solve(int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) return;
        int rootVal = postorder[postEnd];
        sb.append(rootVal+" ");
        int root = position[rootVal-1];
        solve(inStart, root-1,postStart,root - (inStart - postStart)-1);
        solve(root+1, inEnd,root - (inStart - postStart)  ,postEnd-1);

    }
}
