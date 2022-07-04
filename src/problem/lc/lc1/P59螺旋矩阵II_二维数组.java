package problem.lc.lc1;

public class P59螺旋矩阵II_二维数组 {

    public static void main(String[] args) {
        generateMatrix(3);
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][];
        for (int i = 0; i < n; i++) {
            res[i] = new int[n];
        }
        int idx = 1;
        int len = 0;
        int temp = n;
        while (temp > 1) {
            for (int i = len; i < n - 1 - len; i++) {
                res[len][i] = idx;
                idx++;
            }
            for (int i = len; i < n - 1 - len; i++) {
                res[i][n - 1 - len] = idx;
                idx++;
            }
            for (int i = n - 1 - len; i > len; i--) {
                res[n - 1 - len][i] = idx;
                idx++;
            }
            for (int i = n - 1 - len; i > len; i--) {
                res[i][len] = idx;
                idx++;
            }
            len++;
            temp -= 2;
        }
        if (idx == n * n) {
            res[n - 1 - n/2][n - 1 - n/2] = idx;
        }
        return res;
    }
}
