package problem.lc.lc2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90子集II_DFS_有重复元素_向前走不回头_典 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        res.add(path);
        Arrays.sort(nums);
        dfs(res, path, visited, nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> path, boolean[] visited, int[] nums, int begin) {
        for (int i = begin; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {   //这里
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            res.add(new ArrayList<>(path));
            dfs(res, path, visited, nums, i+1); //这里
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
