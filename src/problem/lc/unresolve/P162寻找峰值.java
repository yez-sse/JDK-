package problem.lc.unresolve;

public class P162寻找峰值 {


    public int findPeekElement2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }


//    int[] nums2;

    //两两不相等，这个条件要注意
    //下面这个写法有问题
    public int findPeekElement(int[] nums) {
//        this.nums2 = nums;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == 0 || mid == nums.length - 1 || (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])) {
                return mid;
            }
            if (nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            } else if (nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }
        }
        return -1;
    }

//    public void dfs(int left, int right) {
//        int mid = (left + right) / 2;
//        if (mid > 0 && mid < )
//    }
}
