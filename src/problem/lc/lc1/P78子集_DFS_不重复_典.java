package problem.lc.lc1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P78子集_DFS_不重复_典 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        subsets(nums);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        res.add(new ArrayList<>(path));
        dfs(nums, 0, res, path);
        return res;
    }

    public static void dfs(int[] nums, int begin, List<List<Integer>> res, Deque<Integer> path) {
        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            res.add(new ArrayList<>(path)); //顺序啊，这个顺序很重要
            dfs(nums, i + 1, res, path);
            path.removeLast();
        }
    }
}
