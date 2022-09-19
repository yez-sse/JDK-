package problem.prob;

import problem.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{9,9,4}, {6,6,8}, {2,1,1}};
        System.out.println(longestIncreasingPath(matrix));
    }

    static int max = 0;
    static List<Integer> path = new ArrayList<>();
    static int[][] directions = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};

    public static int longestIncreasingPath (int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dfs(matrix, i, j);
            }
        }
        return max;
    }

    public static void dfs(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return;
        }
        if (path.size() > 0 && matrix[i][j] < path.get(path.size() - 1)) {
            return;
        }
        path.add(matrix[i][j]);
        if (path.size() > max) {
            max = path.size();
        }
        for (int k = 0; k < 4; k++) {
            dfs(matrix, i + directions[k][0], j + directions[k][1]);
        }
        path.remove(path.size() - 1);
    }

}
