package problem.lc.lc1;

public class P34非递减即递增数组中一数的区间_二分查找_典_变 {


    //我写的，是对的
    public int[] searchRange3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[]{-1, -1};
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                while (mid >= 0 && nums[mid] == target) {
                    mid--;
                }
                res[0] = Math.max(0, mid);
                while (mid + 1 < nums.length && nums[mid+1] == target) {
                    mid++;
                }
                res[1] = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }



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
