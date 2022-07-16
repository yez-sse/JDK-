package problem.lc.lc1;

public class P91_解码方法_动态规划_典 {

    public static void main(String[] args) {
        String s = "2101";
        numDecodings(s);
    }

    public static int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }

        int[] dp = new int[chars.length];
        dp[0] = 1;
        if (chars.length > 1) {
            if (chars[1] == '0' && (chars[0] - '0') * 10 + (chars[1] - '0') > 26) {
                dp[1] = 0;
            } else if (chars[1] == '0' || (chars[0] - '0') * 10 + (chars[1] - '0') > 26) {
                dp[1] = 1;
            } else {
                dp[1] = 2;
            }
        }
        for (int i = 2; i < chars.length; i++) {
            if (chars[i] == '0') {
                if (chars[i - 1] == '0' || ((chars[i - 1] - '0') * 10 + (chars[i] - '0') > 26)) {
                    return 0;
                } else {
                    dp[i] = dp[i - 2];
                }
            } else if (chars[i - 1] == '0') {
                dp[i] = dp[i - 1];
            } else  {
                if ((chars[i - 1] - '0') * 10 + (chars[i] - '0') > 26) {
                    dp[i] += dp[i - 1];
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
        }
        return dp[chars.length - 1];
    }
}
