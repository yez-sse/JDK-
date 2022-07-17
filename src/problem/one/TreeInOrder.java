package problem.one;

import problem.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeInOrder {
    List<Integer> inOrderList = new ArrayList<>();

    public void recurInOrder(TreeNode root) {
        if (root == null) {
            return ;
        }
        if (root.left != null) {
            recurInOrder(root.left);
        }
        inOrderList.add(root.val);
        if (root.right != null) {
            recurInOrder(root.right);
        }
    }

    public void nonRecurInOrder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root.left != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            inOrderList.add(root.val);
            root = root.right;
        }
    }
}
