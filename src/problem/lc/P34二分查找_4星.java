package problem.lc;

public class P34二分查找_4星 {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length
                && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;       //下面这个判断条件加上上面的-1，好聪明的想法啊
            if (nums[mid] > target || (lower && nums[mid] == target)) {  // 后面是为了找到第一个遇到的
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // 我写的，暴力法
    public int[] searchRange2(int[] nums, int target) {
        int[] ans = {-1, -1};
        int numsLeft = 0, numsRight = nums.length - 1;
        while (numsLeft < nums.length) {
            if (nums[numsLeft] == target) {
                ans[0] = numsLeft;
                break;
            }
            numsLeft++;
        }
        if (numsLeft != nums.length) {
            while (numsRight >= numsLeft) {
                if (nums[numsRight] == target) {
                    ans[1] = numsRight;
                    break;
                }
            }
        }
        return ans;
    }
}
