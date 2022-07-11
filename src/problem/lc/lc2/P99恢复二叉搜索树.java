package problem.lc.lc2;

import problem.prob.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P99恢复二叉搜索树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        recoverTree3(root);
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        //下面是思维的盲区，导致这题做不出来
        TreeNode x = null;
        TreeNode y = null;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                y = list.get(i + 1);    //遍历结束就是位置错误中小的那个
                if (x == null) {
                    x = list.get(i);    //一开始出现就是错误位置中大的那个
                }
            }
        }
        if (x != null && y != null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    public void dfs(TreeNode root, List<TreeNode> list) {
        if (root.left != null) {
            dfs(root.left, list);
        }
        list.add(root);
        if (root.right != null) {
            dfs(root.right, list);
        }
    }


    //下面这个逻辑上也有问题
    public static void recoverTree3(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        dfs3(root, stack);
    }

    public static void dfs3(TreeNode root, Deque<TreeNode> stack) {
        if (root.left != null) {
            dfs3(root.left, stack);
        }
        if (!stack.isEmpty() && root.val < stack.peek().val) {
            Deque<TreeNode> stack2 = new LinkedList<>();
            while (stack.size() > 1 && root.val < stack.peek().val) {
                stack2.push(stack.pop());
            }
            int temp = root.val;
            root.val = stack.peek().val;
            stack.peek().val = temp;
            stack.push(root);
            while (!stack2.isEmpty()) {
                stack.push(stack2.pop());   //这个地方不能就直接放进去，而是要一个连一个的变
            }
        } else {
            stack.push(root);
        }
        if (root.right != null) {
            dfs3(root.right, stack);
        }
    }


    //677/1919还是有很多情况没有考虑到啊
    public void recoverTree2(TreeNode root) {
        if (root.left != null) {
            if (root.val < root.left.val) {
                int temp = root.val;
                root.val = root.left.val;
                root.left.val = temp;
                return;
            }
            recoverTree2(root.left);
        }
        if (root.right != null) {
            if (root.val > root.right.val) {
                int temp = root.val;
                root.val = root.right.val;
                root.right.val = temp;
                return;
            }
            recoverTree2(root.right);
        }
    }
}
