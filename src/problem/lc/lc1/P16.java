package problem.lc.lc1;

import java.util.Arrays;

public class P16 {
    public static void main(String[] args) {

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int L = i + 1, R = nums.length - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum < target) {
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    L++;
                } else if (sum > target) {
                    while (R > L && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    R--;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
