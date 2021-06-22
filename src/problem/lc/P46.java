package problem.lc;

import java.util.ArrayList;
import java.util.List;

public class P46 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, len, 0, used, path, res);
        return res;
    }

    // 全排列采用DFS深度优先遍历来做
    public static void dfs(int[] nums, int len, int depth, boolean[] used,
                           List<Integer> path, List<List<Integer>> res) {
        if (path.size() == len) {
            res.add(new ArrayList<>(path));
            return ;
        }
        for(int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, used, path, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
