package problem.lc;

import java.util.Arrays;

public class P33 {
    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        int L = 0, R = nums.length - 1;
        while (L < R) {
            int mid = L + (L + R) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[0]) {
                if (target >= nums[L] && target < nums[mid]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
            if (nums[mid] < nums[0]) {
                if (target < nums[R] && target > nums[mid]) {
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int target) {
        int L = 0, R = nums.length - 1;
        Arrays.sort(nums);
        while (L < R) {
            int mid = L + (L + R) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return -1;
    }
}
