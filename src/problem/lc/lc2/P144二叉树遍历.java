package problem.lc.lc2;

import problem.struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P144二叉树遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
//            while (root != null) {
//                res.add(root.val);
//                stack.push(root.left);
//                root = root.left;
//            }
            TreeNode node = stack.pop();    //注意这个node怎么用
            res.add(node.val);
            if (node.right != null) {   //注意是栈
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }


    //后序遍历没有那么简单，这里写的有问题，掌握的不熟练
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            //缺东西啊
//            while(root.left != null) {
//                root = root.left;
//                stack.push(root);
//            }
//            if (root.right == null) {
//                TreeNode node = stack.pop();
//                res.add(node.val);
//                root = stack.peek();
//            }
//            if (root.right != null){
//                root = root.right;
//                stack.push(root);
//            } else {
//                TreeNode node = stack.pop();
//                res.add(node.val);
//                root = stack.peek();
//            }
        }
        return res;
    }


    //人家的，有一个cur标记，当前退出节点是什么？？
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode cur = root;    //这个东西
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.left != null && peek.left != cur && peek.right != cur) {
                stack.push(peek.left);
            } else if (peek.right != null && peek.right != cur) {
                stack.push(peek.right);
            } else {
                res.add(stack.pop().val);
                cur = peek; //注意这里，不是stack.peek()，而是peek那个变量
            }
        }
        return res;
    }
}
