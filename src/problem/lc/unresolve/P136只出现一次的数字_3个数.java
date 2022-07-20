package problem.lc.unresolve;

public class P136只出现一次的数字_3个数 {


    //这只是有两个数重复，三个数重复呢？？
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res |= nums[i];
        }
        return res;
    }
}
