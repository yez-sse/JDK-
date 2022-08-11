package problem.lc.lc3;

public class P209长度最小的子数组 {

    public int minSubArrayLen2(int target, int[] nums) {
        int end = 0, start = 0, sum = 0, size = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
//            if (sum >= target) {  这里有个很重要的点就是while而不是if
            while (sum >= target) {
                size = Math.min(size, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return size == Integer.MAX_VALUE ? 0 : size;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int temp = nums[0];
        int left = 0;
        int right = 0;
        int size = Integer.MAX_VALUE;

        while (right < nums.length) {
            if (temp >= target) {
                size = Math.min(size, right - left + 1);
                left++;
                temp -= nums[left - 1];
                if (left < nums.length && right < left) {
                    right = left;
                    temp += nums[right];
                }
            } else {
                right++;
                if (right < nums.length) {
                    temp += nums[right];
                }
            }
        }

        return size == Integer.MAX_VALUE ? 0 : size;
    }
}
