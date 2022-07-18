package problem.lc.lc2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P131分割成回文串_dfs回溯_变 {

    int len = 0;
    List<List<String>> res;

    public List<List<String>> partition(String s) {
        len = s.length();
        res = new ArrayList<>();

        Deque<String> path = new ArrayDeque<>();   //Java文档推荐这么写？？
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, path);
        return res;
    }

    private void dfs(char[] charArray, int index, Deque<String> path) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            if (!checkPalindrome(charArray, index, i)) {
                continue;
            }
            path.addLast(new String(charArray, index, i + 1 - index));
            dfs(charArray, i + 1, path);
            path.removeLast();
        }
    }

    public boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
