package problem.lc.lc1;

import java.util.Arrays;

public class P33搜索旋转排序数组_二分查找_变 {

    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {  //先判断mid是在大的一段还是小的一段，这是在大的一段
                if (nums[mid] > target && target >= nums[left]) {   //在mid在大段的前提下，只有一种情况往左走
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

//我写的跑不通
//    public int search2(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] < target) {
//                if (target < nums[right]) {
//                    left = mid + 1;
//                } else {
//                    right = right - 1;
//                }
//            } else if (nums[mid] > target) {
//                if (target < nums[left]) {
//                    left = mid + 1;
//                } else {
//                    right = right - 1;
//                }
//            } else {
//                return mid;
//            }
//        }
//        return -1;
//    }

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
