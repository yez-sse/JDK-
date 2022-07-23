package problem.lc.lc2;

public class P153寻找排序数组中的最小值 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }
        return nums[left];
        //or return nums[right + 1];
    }
}
