package problem.pat.tree.dfs;

import java.util.*;

public class P1064CompleteBinarySearchTree {

    private static int n;
    private static int t = 0;
    private static int[] inOrder = new int[1010];
    private static int[] level = new int[1010];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            inOrder[i] = in.nextInt();
        }
        Arrays.sort(inOrder, 0, n);
        inOrderOp(0);
    }

    public static void inOrderOp(int root) {
        if (root >= n) {
            return;
        }
        //这句太帅了，真的太帅了，注意先进的是左边
        inOrderOp(2 * root + 1);
        level[root] = inOrder[t++];
        inOrderOp(2 * root + 2);
    }
}
