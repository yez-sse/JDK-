package problem.lc.lc2;

public class P198打家劫舍 {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 0; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }


    //自己这么写的，歪打正着了，可能里面又可行性的证明，但咱不会证啊
    public int rob2(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        dp[0][0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][1], dp[nums.length - 2][1]);
    }
}
