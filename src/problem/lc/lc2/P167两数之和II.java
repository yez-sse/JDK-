package problem.lc.lc2;

public class P167两数之和II {

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left] + nums[right];
            if (temp == target) {
                return new int[]{left + 1, right + 1};
            } else if (temp < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}