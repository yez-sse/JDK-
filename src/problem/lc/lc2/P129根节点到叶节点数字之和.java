package problem.lc.lc2;

import problem.struct.TreeNode;

public class P129根节点到叶节点数字之和 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int preNum) {
        if (root == null) {
            return 0;
        }
        int sum = preNum * 10 + root.val;
//        if (root.left != null || root.right != null) {
//            return dfs(root.left, sum) + dfs(root.right, sum);
//        } else {
//            return sum; //递归了啊，这里递归了，不用dfs
//        }
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }

    //写了这么一大堆还不都是对的
//    List<Integer> path;
//    List<Integer> nums;
//
//    public int sumNumbers(TreeNode root) {
//        path = new ArrayList<>();
//        nums = new ArrayList<>();
//        int res = 0;
//        for (int i : nums) {
//            res += i;
//        }
//        return res;
//    }
//
//    public void dfs(TreeNode root) {
//        if (root == null) {
//            nums.add(path.get(path.size() - 1));
//            return;
//        }
//        if (path.size() == 0) {
//            path.add(root.val);
//        } else {
//            path.add(path.get(path.size() - 1) * 10 + root.val);
//        }
//        dfs(root.left);
//        dfs(root.right);
//        path.remove(path.size() - 1);
//    }
}
