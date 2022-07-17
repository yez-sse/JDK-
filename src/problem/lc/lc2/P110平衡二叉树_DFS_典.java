package problem.lc.lc2;

import problem.struct.TreeNode;

public class P110平衡二叉树_DFS_典 {

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        if (left == -1) {
            return -1;
        }
        int right = dfs(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    //P111二叉树的最小深度，这是我写的，就打败了17%
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        if (root.right == null) {
            return left + 1;
        }
        int right = minDepth(root.right);
        if (root.left == null) {
            return right + 1;
        }
        return Math.min(left, right) + 1;
    }
}
