package problem.lc.unresolve;

import problem.lc.lc1.P8;

public class P81搜索旋转排序数组II {

    public boolean search(int[] nums, int target) {
        return false;
    }



    //这题下面这个做法不行，33题是没有重复值的互不相同的。有重复值的不能这么写why？？
    public boolean search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] >= nums[left]) {  //先判断在大段还是小段，这里是在大段里面
                if (nums[mid] > target && target >= nums[left]) {   //这里仅用前一个条件，不能判断target是在大段还是小段。后一个也是
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
            //这个自己写的有问题，这个流程搞错了
//            if (nums[mid] > target) {
//                if (nums[mid] >= nums[left]) {
//                    right = mid - 1;
//                } else {    //如果left比mid小，则表明mid在小的那一段
//                    left = mid + 1;
//                }
//            }
//            if (nums[mid] < target) {
//                if (nums[mid] <= nums[right]) {
//                    left = mid + 1;
//                } else {
//                    right = mid - 1;
//                }
//            }
        }
        return false;
    }
}
