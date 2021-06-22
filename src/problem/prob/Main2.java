package problem.prob;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

    }

    public List<List<TreeNode>> levelOrder(TreeNode root) {
        List<List<TreeNode>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            int size = queue.size();
            if (res.size() % 2 == 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode tempNode = queue.pollLast();
                    temp.add(tempNode);
                    if (tempNode.right != null) {
                        queue.addFirst(tempNode.right);
                    }
                    if (tempNode.left != null) {
                        queue.addFirst(tempNode.left);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode tempNode = queue.pollFirst();
                    temp.add(tempNode);
                    if (tempNode.left != null) {
                        queue.addLast(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        queue.addLast(tempNode.right);
                    }
                }
            }
            res.add(temp);
        }
        return res;
    }
}
