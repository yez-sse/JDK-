package problem.lc.lc1;

import java.util.ArrayList;
import java.util.List;

public class P54二维数组螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();

        while (true) {
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            if (++top > bottom) {
                break;  //本题中四种情况，任意一种break就是全局的break，贪吃蛇属于是
            }
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (--right > left) {
                break;
            }
            for (int j = right; j >= left; j--) {
                res.add(matrix[bottom][j]);
            }
            if (--bottom > top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
