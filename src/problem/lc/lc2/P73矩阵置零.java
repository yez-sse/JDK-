package problem.lc.lc2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class P73矩阵置零 {

    //将第一行第一列置为0，只需要记录第一行第一列种是否本身就由0
    public void setZeros2(int[][] matrix) {

    }

    //这个方法很弱智，不过好在学了下iterator
    public void setZeros(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (Iterator<Integer> iterator = rows.iterator(); iterator.hasNext(); ) {
            int row = iterator.next();
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }
        for (Iterator<Integer> iterator = cols.iterator(); iterator.hasNext(); ) {
            int col = iterator.next();
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
