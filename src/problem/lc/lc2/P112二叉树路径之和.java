package problem.lc.lc2;

import problem.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P112二叉树路径之和 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode root, int targetSum, int cur) {
        if (root == null) {
            return false;
        }
        cur += root.val;    //大胆加，因为数字本身就是有正有负
        if (cur == targetSum) {
            if (root.left == null && root.right == null) {
                return true;
            }
        }
        return dfs(root.left, targetSum, cur) || dfs(root.right, targetSum, cur);
    }

    //p113路径记录下来
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs2(root, targetSum, 0, res, path);
        return res;
    }
    //这个方法写的击败的很可怜，最后两句复杂度还是高了
    public void dfs2(TreeNode root, int targetSum, int cur, List<List<Integer>> res, List<Integer> path) {
        if (root == null) {
            return;
        }
        cur += root.val;    //大胆加，因为数字本身就是有正有负
        path.add(root.val);
        if (cur == targetSum) {
            if (root.left == null && root.right == null) {
                res.add(new ArrayList<>(path));
                return;
            }
        }
        dfs2(root.left, targetSum, cur, res, new ArrayList<>(path));
        dfs2(root.right, targetSum, cur, res, new ArrayList<>(path));
    }

    public void dfs3(TreeNode root, int targetSum, int cur, List<List<Integer>> res, List<Integer> path) {
        if (root == null) {
            return;
        }
        cur += root.val;    //大胆加，因为数字本身就是有正有负
        path.add(root.val);
        if (cur == targetSum) {
            if (root.left == null && root.right == null) {
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);   //这个地方至关重要啊，因为下一句就return了
                return;
            }
        }
        dfs2(root.left, targetSum, cur, res, path);
        dfs2(root.right, targetSum, cur, res, path);
        path.remove(path.size() - 1);
    }
}
