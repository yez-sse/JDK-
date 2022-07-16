package problem.lc.lc2;

public class P121买卖股票的最佳时机 {

    //只能完成两笔交易
    public int maxProfit3(int[] prices) {
        return 0;
    }

    //这题贪心的思路很好想，证明起来应该也不难
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += (prices[i + 1] - prices[i]);
            }
        }
        return profit;
    }

    //注意和下面的1_1对比，真的理解了动态规划的过程，才能体会到差别在哪里
    public int maxProfit2_1(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);    //是包含了之前的收益的
        }
        return dp[prices.length - 1][0];
    }


    public int maxProfit1_1(int[] prices) {
        //核心：0表示不持股，1表示持股
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);  //没有包含以前的收益
        }
        return dp[dp.length - 1][0];
    }

    //这个方法是自己写的，一个突出问题就是写的太多了，感觉不用这么多
    //另一个就是，这个不是动态规划，而是叫哨兵机制来维护一个单调栈（单调数组）
    public int maxProfit1(int[] prices) {
        int[] high = new int[prices.length];
        int highNum = prices[prices.length - 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            highNum = Math.max(highNum, prices[i]);
            high[i] = highNum;
        }
        int res = Integer.MIN_VALUE;
        int[] low = new int[prices.length];
        int lowNum = prices[0];
        for (int i = 0; i < prices.length; i++) {
            lowNum = Math.min(lowNum, prices[i]);
            low[i] = lowNum;
            res = Math.max(res, high[i] - low[i]);
        }
        return res;
    }
}
