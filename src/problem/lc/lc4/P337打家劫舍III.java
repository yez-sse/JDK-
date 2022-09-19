package problem.lc.lc4;

import problem.struct.TreeNode;

public class P337打家劫舍III {

    public int rob(TreeNode root) {
        int[] res = dfsDp(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfsDp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfsDp(root.left);
        int[] right = dfsDp(root.right);

        int[] dp = new int[2];
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + left[1];
        return dp;
    }
}
