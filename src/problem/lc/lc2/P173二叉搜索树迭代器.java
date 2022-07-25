package problem.lc.lc2;

import problem.struct.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P173二叉搜索树迭代器 {

    Deque<TreeNode> stack = new ArrayDeque<>();

    public P173二叉搜索树迭代器(TreeNode root) {
        dfsLeft(root);
    }

    void dfsLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    //这个方法算是最关键的了
    public int next() {
        TreeNode root = stack.pop();
        int ans = root.val;
        root = root.right;
        dfsLeft(root);
        return ans;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
