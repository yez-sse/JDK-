package problem.lc.lc3;

import problem.struct.TreeNode;

public class P222完全二叉树的节点个数 {

    int sum = 0;

    public int countNodes(TreeNode root) {
        dfs(root);
        return sum;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        sum++;
        dfs(root.left);
        dfs(root.right);
    }
}
