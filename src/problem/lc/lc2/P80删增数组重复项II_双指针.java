package problem.lc.lc2;

public class P80删增数组重复项II_双指针 {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int dup = 1;    //这个地方它是1很重要，如果是0的话就少了一个
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
                dup++;
            }
            if (dup > 2) {  //这里dup确实是重复项一共有多少个
                dup = 2;
            }
            while (dup-- > 0) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}
