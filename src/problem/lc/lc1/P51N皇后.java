package problem.lc.lc1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P51N皇后 {
    private int n;
    private boolean[] col;
    private boolean[] diagonal1;
    private boolean[] diagonal2;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        this.n = n;
        col = new boolean[n];
        diagonal1 = new boolean[2 * n - 1];
        diagonal2 = new boolean[2 * n - 1];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, path);
        return res;
    }

    private void dfs(int row, Deque<Integer> path) {
        if (row == n) {
            List<String> board = convert(path);
            res.add(board);
            return;
        }

        //针对下表为row的每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            //每条主对角线上的坐标差固定且对称分布，每条副对角线上的和固定
            if (!col[i] && !diagonal1[row - i + n - 1] && !diagonal2[row + i]) {
                path.addLast(i);
                col[i] = true;
                diagonal1[row - i + n - 1] = true;
                diagonal2[row + i] = true;

                dfs(row + 1, path);

                diagonal2[row + i] = false;
                diagonal1[row - i + n - 1] = false;
                col[i] = false;
                path.removeLast();
            }
        }
    }

    private List<String> convert(Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder rowStr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                rowStr.append(".");
            }
            rowStr.replace(num, num + 1, "Q");
            board.add(rowStr.toString());
        }
        return board;
    }
}
