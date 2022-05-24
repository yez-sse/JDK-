package problem.lc;

import java.util.ArrayList;
import java.util.List;

public class P46DFS全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(res, cur, nums, visited);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] visited) {
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            visited[i] = true;
            cur.add(nums[i]);
            if (cur.size() == nums.length) {
                res.add(new ArrayList<>(cur));
            } else {
                dfs(res, cur, nums, visited);
            }
            cur.remove(cur.size()-1);
            visited[i] = false;
        }
    }
}
