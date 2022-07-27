package problem.lc.lc2;

import problem.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P199二叉树的右视图 {

    List<Integer> res2 = new ArrayList<>();
    //甜姨这个dfs带一定的技巧
    public List<Integer> rightSideView2(TreeNode root) {
        dfs(root, 0);
        return res2;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 如果当前节点所在深度还没有出现在res里，注意一层只增加一个节点
        // 说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中
        if (depth == res2.size()) {
            res2.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }



    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            res.add(queue.peek().val);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
            }
        }
        return res;
    }
}
