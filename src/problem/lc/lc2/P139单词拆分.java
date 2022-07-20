package problem.lc.lc2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P139单词拆分 {

    //看作完全背包问题，dp解决，dp要两重循环啊，不然dp个寂寞
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i - len >= 0 && s.substring(i - len, i).equals(word)) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[s.length()];
    }


    //看看人家写的dfs
    public boolean wordBreak2(String s, List<String> wordDict) {
        Map<String, Boolean> wordMap = new HashMap<>();
        for (String word : wordDict) {
            wordMap.put(word, true);
        }
//        return canBreak(s, 0, wordMap);
        Map<Integer, Boolean> can = new HashMap<>();
        return canBreak2(s, 0, wordMap, can);
    }

    //这个会超时
    public boolean canBreak(String s, int start, Map<String, Boolean> wordMap) {
        if (start == s.length()) {
            return true;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String substr = s.substring(start, i);
            if (wordMap.get(substr) != null && canBreak(s, i, wordMap)) {
                return true;
            }
        }
        return false;
    }

    //记忆化的优化？？
    public boolean canBreak2(String s, int start, Map<String, Boolean> wordMap, Map<Integer, Boolean> can) {
        if (start == s.length()) {
            return true;
        }
        if (can.get(start) != null) {
            return can.get(start);
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String substr = s.substring(start, i);
            if (wordMap.get(substr) != null && canBreak2(s, i, wordMap, can)) {
                can.put(start, true);
                return true;
            }
        }
        can.put(start, false);
        return false;
    }




    //下面写了这么大一片dfs，还是不对啊
//    public boolean wordBreak(String s, List<String> wordDict) {
//        return dfs(s, wordDict, 0);
//    }
//
//    public boolean dfs(String s, List<String> wordDict, int index) {
//        if (index == s.length()) {
//            return true;
//        }
//        for (int i = 0; i < wordDict.size(); i++) {
//            if (!preEqual(s, wordDict.get(i), index)) {
//                continue;
//            }
//            return dfs(s, wordDict, index + wordDict.get(i).length());
//        }
//        return false;
//    }
//
//    public boolean preEqual(String s, String s2, int index) {
//        if (s.length() - index < s2.length()) {
//            return false;
//        }
//        for (int i = 0; i < s2.length(); i++) {
//            if (s2.charAt(i) != s.charAt(index + i)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
