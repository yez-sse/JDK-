package easy;

import java.util.Scanner;

public class P最大子数组和 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] numStr = in.nextLine().split(" ");
        int[] nums = new int[numStr.length];
        for (int i = 0; i < numStr.length; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
        }

        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println(max);
    }
}
