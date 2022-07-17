package problem.lc.lc1;

import problem.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class P98验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        Deque<Integer> stack = new LinkedList<>();
        return dfs(root, stack);
    }

    public boolean dfs(TreeNode root, Deque<Integer> stack) {
        if (root.left != null) {
            if (!dfs(root.left, stack)) {
                return false;
            }
        }
        if (stack.isEmpty()) {
            stack.push(root.val);
        } else {
            if (stack.peek() >= root.val) {
                return false;
            } else {
                stack.push(root.val);
            }
        }
        if (root.right != null) {
            if (!dfs(root.right, stack)) {
                return false;
            }
        }
        return true;
    }
}
