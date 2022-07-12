package problem.lc.lc2;

import problem.prob.TreeNode;

import java.util.*;

public class P102二叉树层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() && queue.peek() != null) {
            int tempSize = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < tempSize; i++) {
                TreeNode tempNode = queue.pollFirst();
                tempList.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.addLast(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.addLast(tempNode.right);
                }
            }
            res.add(tempList);
        }
//        Collections.reverse(res);
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() && queue.peek() != null) {
            int tempSize = queue.size();
            LinkedList<Integer> tempList = new LinkedList<>();
            for (int i = 0; i < tempSize; i++) {
                TreeNode tempNode = queue.pollFirst();
                if (res.size() % 2 == 0) {
                    tempList.addLast(tempNode.val);
                } else {
                    tempList.addFirst(tempNode.val);
                }
                if (tempNode.left != null) {
                    queue.addLast(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.addLast(tempNode.right);
                }
            }
            res.add(tempList);
        }
        return res;
    }
}
