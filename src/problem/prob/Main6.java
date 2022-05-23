package problem.prob;

public class Main6 {
    public static void main(String[] args) {
        int[] a = {-1, -1, 1, 2, 3, -2, 3};
        System.out.println(maxSubArray(a));
    }

    public static int maxSubArray(int[] array) {
        int temp = 0, max = 0;
        for (int i = 0; i < array.length; i++) {
            if (temp + array[i] >= 0) {
                temp += array[i];
                max = Math.max(max, temp);
            } else {
                temp = 0;
            }
        }
        return max;
    }
}
