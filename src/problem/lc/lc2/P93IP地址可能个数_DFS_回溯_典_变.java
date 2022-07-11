package problem.lc.lc2;

import java.util.ArrayList;
import java.util.List;

public class P93IP地址可能个数_DFS_回溯_典_变 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(path, 0, res, s);
        return res;
    }

    public void dfs(List<String> path, int start, List<String> res, String s) {
        if (path.size() == 4 && start == s.length()) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                if (i != 0) {
                    builder.append(".");
                }
                builder.append(path.get(i));
            }
            res.add(builder.toString());
            return;
        }
        if (path.size() == 4 && start < s.length()) {
            return;
        }
        for (int len = 1; len <= 3; len++) {
            if (start - 1 + len >= s.length()) {    //start是下一块的起点
                return;
            }
            if (len != 1 && s.charAt(start) == '0') {
                return;
            }
            String tempStr = s.substring(start, start + len);
            if (Integer.valueOf(tempStr) > 255) {
                return;
            }
            path.add(tempStr);
            dfs(path, start + len, res, s);
            path.remove(path.size() - 1);
        }
    }
}
