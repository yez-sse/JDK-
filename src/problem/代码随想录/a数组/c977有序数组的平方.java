package problem.代码随想录.a数组;

public class c977有序数组的平方 {

    public int[] sortedSquares(int[] nums) {
        int idx = nums.length - 1;
        int[] res = new int[nums.length];   // space for time
        for (int L = 0, R = nums.length - 1; L <= R; ) {
            if (nums[L] * nums[L] > nums[R] * nums[R]) {
                res[idx--] = nums[L] * nums[L];
                L++;
            } else {
                res[idx--] = nums[R] * nums[R];
                R--;
            }
        }
        return res;
    }
}
