package problem.代码随想录.a数组;

public class a704_二分查找 {

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;    // 闭区间 [left, right]
        while (left <= right) { // left==right is meaningful
            int mid = left + ((right - left) / 2);  // prevent left+right overflow
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;    // 开区间 [left, right)
        while (left < right) { // left==right isn't meaningful
            int mid = left + ((right - left) / 2);
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
