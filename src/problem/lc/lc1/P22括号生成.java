package problem.lc.lc1;

import java.util.ArrayList;
import java.util.List;

public class P22括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public void dfs(List<String> res, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append('(');
            dfs(res, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (close < open) {
            cur.append(')');
            dfs(res, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
