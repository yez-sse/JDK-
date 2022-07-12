package problem.lc.lc2;

import problem.prob.TreeNode;

public class P104树的最大深度_典 {


    //这样写才叫用递归，而不是dfs+depth变量
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;   //这里不仅仅是特殊情况，递归到空的叶子节点也是要用的，递归的返回条件
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
