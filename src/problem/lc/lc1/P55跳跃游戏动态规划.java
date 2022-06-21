package problem.lc.lc1;

public class P55跳跃游戏动态规划 {
    public boolean canJump(int[] nums) {
//        if (nums.length <= 1) {
//            return true;
//        }
//        boolean res = false;
//        for (int i = 0; i < nums.length - 1; i++) {
//            int pos = i;
//            while (true) {
//                int next = pos + nums[pos];
//                if (next >= nums.length - 1) {
//                    res = true;
//                    break;
//                }
//                if (nums[next] == 0) {
//                    if (next <= i) {
//                        return false;
//                    }
//                    break;
//                }
//                pos = next;
//            }
//            if (res) {
//                break;
//            }
//        }
//        return res;
        // 上面我写的这个，[3,0,8,2,0,0,1]这个用例过不了

        // Solution1

        int curMax = 0; //前面n-1个元素能跳到的最远距离
        for (int i = 0; i < nums.length; i++) {
            //人家这个代码真好啊
            if (i > curMax) {
                return false;
            }
            curMax = Math.max(curMax, i + nums[i]);
        }
        return true;

        // Solution2，对上面的解释

//        int k = 0;
//        for (int i = 0; i <= k; i++) {
//            //第i个元素能够跳到的最远距离
//            int temp = i + nums[i];
//            //更新最远距离
//            k = Math.max(k, temp);
//            //如果最远距离已经大于或等于最后一个元素的下标,则说明能跳过去,退出. 减少循环
//            if (k >= nums.length - 1) {
//                return true;
//            }
//        }
//        //最远距离k不再改变,且没有到末尾元素
//        return false;
    }
}
