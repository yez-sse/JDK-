package problem.lc.lc6;

public class P647回文子串 {

    public int countSubstrings(String s) {
        int sum = 0;
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len - 1; i++) {
            dp[i][i] = 1;
            sum++;
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1] > 0)) {
                    sum++;
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
            }
        }
        return sum;
    }
}
