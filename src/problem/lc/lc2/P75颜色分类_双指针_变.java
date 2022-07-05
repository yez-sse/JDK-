package problem.lc.lc2;

public class P75颜色分类_双指针_变 {

    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length;
        int i = 0;

        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;  //注意two和zero不是对称的
                swap(nums, i, two);
                //这里也没有i++，i此时停留在原地很重要
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //这个自己写了一通都是错的
    public void sortColors2(int[] nums) {
        int left = -1;
        int right = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[left + 1];
                nums[left + 1] = 0;
                nums[i] = temp;
                left--;
            }
            if (nums[i] == 2) {
                int temp = nums[right - 1];
                nums[right - 1] = 2;
                nums[i] = temp;
                right++;
            }
        }
    }
}
