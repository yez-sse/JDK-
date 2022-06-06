package problem.lc.lc1;

public class P35二分查找 {
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 最经典的二分查找你都不会，你他妈傻逼啊卧槽，你还想他妈什么其他的卧槽
    // public int searchInsert(int[] nums, int target) {
    //     int len = nums.length;
    //     return binarySearch(nums, 0, len - 1, target);
    // }

    // public int binarySearch(int[] nums, int left, int right, int target) {
    //     int ans = 0;
    //     while (left <= right) {
    //         int mid = (left + right) / 2;
    //         if (nums[mid] == target) {
    //             return mid;
    //         } else if (nums[mid] < target) {
    //             left = mid + 1;
    //         } else {
    //             right = mid - 1;
    //         }
    //         ans = mid;
    //     }
    //     return ans;
    // }
}
