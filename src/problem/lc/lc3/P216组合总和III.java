package problem.lc.lc3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P216组合总和III {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0 || k > n) {
            return res;
        }

        // 等差数列，9到(9 - k + 1)
        if (n > (9 + (9 - k + 1)) * k / 2) {
            return res;
        }

        dfs(k, n, 1, new ArrayDeque<>(), res);
        return res;
    }

    private void dfs(int k, int rest, int start, Deque<Integer> path, List<List<Integer>> res) {
        if (10 - start < k) {
            return;
        }
        if (k == 0) {
            if (rest == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
        }

        for (int i = start; i <= 10 - k; i++) {
            if (rest - i < 0) {
                break;
            }
            path.add(i);
            dfs(k - 1, rest - i, i + 1, path, res);
            path.removeLast();
        }
    }
}
