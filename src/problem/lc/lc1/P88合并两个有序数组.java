package problem.lc.lc1;

public class P88合并两个有序数组 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = 0;
        int tempM = m;
        int tempN = n;
        while (m >= 1 && n >= 1) {
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[tempM + tempN - 1 - idx] = nums1[m - 1];
                idx++;
                m--;
            } else {
                nums1[tempM + tempN - 1 - idx] = nums2[n - 1];
                idx++;
                n--;
            }
        }
        if (m > 0) {
            while (m > 0) {
                nums1[tempM + tempN - 1 - idx] = nums1[m - 1];
                idx++;
                m--;
            }
        }
        if (n > 0) {
            while (n > 0) {
                nums1[tempM + tempN - 1 - idx] = nums2[n - 1];
                idx++;
                n--;
            }
        }
    }
}
