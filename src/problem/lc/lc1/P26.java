package problem.lc.lc1;

public class P26 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 2, 2, 1, 1, 5, 5, 5, 4, 6};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            nums[index] = nums[nums.length - 1];
        }

        return index + 1;  // 返回去重后的数组长度
    }

    public static void quickSort(int[] nums, int L, int R) {
        int i = partition(nums, L, R);
        quickSort(nums, L, i - 1);
        quickSort(nums, i + 1, R);
    }

    public static int partition(int[] nums, int L, int R) {
        if (L == R) {
            return L;
        }
        int pivot = nums[L];
        while (L < R) {
            while (R > L && nums[R] >= pivot) {
                R--;
            }
            nums[L] = nums[R];
            while (L < R && nums[L] <= pivot) {
                L++;
            }
            nums[R] = nums[L];
        }
        nums[L] = pivot;
        return L;
    }
}
