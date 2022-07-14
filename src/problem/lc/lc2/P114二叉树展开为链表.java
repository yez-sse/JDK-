package problem.lc.lc2;

import problem.prob.TreeNode;

public class P114二叉树展开为链表 {
    //这道题首先要找到当前树节点，在搜索树中的前一个节点和后一个节点
    //然后把前一节点和后一节点之间的一段，插在它和右子树之间
    public void flatten(TreeNode root) {
        while (root != null) {
            //左子树为null，考虑下一个
            if (root.left == null) {
                root = root.right;
            } else {
                //找到左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //下面两句要能够想象出来了，算是最关键的思路了
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                //下一个，都不用递归或者迭代什么的
                root = root.right;
            }
        }
    }
}
