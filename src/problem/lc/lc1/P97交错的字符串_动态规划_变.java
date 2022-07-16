package problem.lc.lc1;

public class P97交错的字符串_动态规划_变 {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.print(isInterleave2(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        //初始化
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= s2.length(); i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        //状态转移方程
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }


    //我写的，99/106还行，时间复杂度太高了
    public static boolean isInterleave2(String s1, String s2, String s3) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < s3.length() && i < s1.length() && j < s2.length()) {
            if (s3.charAt(k) != s1.charAt(i) && s3.charAt(k) != s2.charAt(j)) {
                return false;
            } else if (s3.charAt(k) == s1.charAt(i) && s3.charAt(k) == s2.charAt(j)) {
                return isInterleave2(s1.substring(i + 1), s2.substring(j), s3.substring(k + 1)) ||
                        isInterleave2(s1.substring(i), s2.substring(j + 1), s3.substring(k + 1));
            } else if (s3.charAt(k) == s1.charAt(i) && s3.charAt(k) != s2.charAt(j)){
                i++;
                k++;
            } else {
                j++;
                k++;
            }
        }
        if (i < s1.length() && j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        } else if (i == s1.length() && j < s2.length()) {
            return s2.substring(j).equals(s3.substring(k));
        } else if (k == s3.length()) {
            return true;
        }
        return false;
    }
}
