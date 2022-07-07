package 典.tree;

import problem.prob.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L94_二叉树中序遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = null;
        root.left.left = null;
        root.left.right = new TreeNode(2);
        inorderTraversal2(root);
    }

    public static List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop(); //root等于stack.pop()只是暂时的，取数的时候用到。回溯遍历的时候不是null就是root.right
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty() && stack.peek() != null) {
            while (root.left != null) {
                root = root.left;
                stack.push(root);
            }
            root = stack.pop();
            res.add(root.val);
            root.left = null;   //这里破坏了二叉树的原有结构，肯定是不行的
            if (root.right != null) {
                stack.push(root.right);
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        dfs(root, inorder);
        return inorder;
    }

    public void dfs(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }
        inorder.add(root.val);
        if (root.left != null) {
            dfs(root.left, inorder);
        }
        if (root.right != null) {
            dfs(root.right, inorder);
        }
    }
}
