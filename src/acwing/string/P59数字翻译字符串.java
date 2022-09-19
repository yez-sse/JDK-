package acwing.string;

import java.util.*;

public class P59数字翻译字符串 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();


    }

    public static int getTranslationCount(String s) {
//        if (s.length() <= 2) {
//            return Integer.parseInt(s) > 25 ? 1 : 2;
//        }
        if (s.length() == 1) {
            return Integer.parseInt(s);
        }
        if (s.length() == 2) {
            if (Integer.parseInt(s) >= 10 && Integer.parseInt(s) <= 25) {
                return 2;
            }
            return 1;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (Integer.parseInt(s.substring(0, 2)) >= 10
                && Integer.parseInt(s.substring(0, 2)) <= 25) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < s.length(); i++) {
            if (Integer.parseInt(s.substring(i - 1, i + 1)) >= 10
                    && Integer.parseInt(s.substring(i - 1, i + 1)) <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }
}
