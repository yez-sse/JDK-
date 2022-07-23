package problem.lc.lc2;

public class P152乘积最大子数组_动态规划 {


    public int maxProduct2(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
//                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][0] * nums[i]);
                dp[i][0] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
//                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][1] * nums[i]);
                dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
            } else {
                dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][1] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
            }
        }
        return dp[nums.length - 1][1];
    }

    //数组长度上万就超时了，明显这题暴力是不能做的
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
            if (dp[i][i] > res) {
                res = dp[i][i];
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = dp[i][j - 1] * nums[j];
                if (dp[i][j] > res) {
                    res = dp[i][j];
                }
            }
        }
        return res;
    }
}
