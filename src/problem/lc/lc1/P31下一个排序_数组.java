package problem.lc.lc1;

import java.util.Arrays;

public class P31下一个排序_数组 {
    public void nextPermutation(int[] nums) {
        int idx = nums.length - 1;
        while (idx > 0 && nums[idx] <= nums[idx - 1]) {
            idx--;
        }
        for (int i = nums.length - 1; i >= idx; i--) {
            if (idx != 0 && (nums[i] > nums[idx - 1])) {
                int temp = nums[idx - 1];
                nums[idx - 1] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        Arrays.sort(nums, idx, nums.length);
    }
}
