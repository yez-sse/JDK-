package problem.lc.lc6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P611有效三角形个数 {


    public int triangleNumber2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i - 1, k = 0; k < j; j--) {
                while (k < j && nums[k] + nums[j] <= nums[i]) {
                    k++;
                }
                res += (j - k);
            }
        }
        return res;
    }


    //下面这个dfs为什么不行？？？

    private int res = 0;

    public int triangleNumber(int[] nums) {
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, 0, path, visited);
        return res;
    }

    public void dfs(int[] nums, int begin, List<Integer> path, boolean[] visited) {
        if (path.size() == 3) {
            if (isTriangle(path.get(0), path.get(1), path.get(2))) {
                System.out.println(path.get(0) + " " + path.get(1) + " " + path.get(2));
                res++;
            }
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, begin + 1, path, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public boolean isTriangle(int x, int y, int z) {
        if (x + y > z && x + z > y && y + z > x) {
            return true;
        }
        return false;
    }
}
