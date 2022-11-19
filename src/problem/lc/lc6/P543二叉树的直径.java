package problem.lc.lc6;

import problem.struct.TreeNode;

public class P543二叉树的直径 {
    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        dfs(root);
        return res - 1;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = dfs(root.left);
        int R = dfs(root.right);
        res = Math.max(res, L + R + 1);
        return Math.max(L, R) + 1;
    }
}
