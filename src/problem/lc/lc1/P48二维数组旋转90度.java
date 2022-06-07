package problem.lc.lc1;

public class P48二维数组旋转90度 {
//    public void rotate(int[][] matrix) {
//        int len = matrix.length;
//        for (int i = 0; i < len; i++) {
//            for (int j = i; j < len; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }
//    }
    public void rotate(int[][] matrix) {
        int innerIdx = 0;
        int outerIdx = matrix.length - 1;
        while (innerIdx < outerIdx) {
            int curLen = 0;
            while (curLen < outerIdx - innerIdx) {
                int temp = matrix[innerIdx][innerIdx+curLen];
                matrix[innerIdx][innerIdx+curLen] = matrix[outerIdx-curLen][innerIdx];
                matrix[outerIdx-curLen][innerIdx] = matrix[outerIdx][outerIdx-curLen];
                matrix[outerIdx][outerIdx-curLen] = matrix[innerIdx+curLen][outerIdx];
                matrix[innerIdx+curLen][outerIdx] = temp;
                curLen++;
            }
            innerIdx++;
            outerIdx--;
        }
    }
}
