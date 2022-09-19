package problem.lc.lc7;

public class P695岛屿最大面积 {

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = getArea(grid, i, j);
                    res = Math.max(area, res);
                }
            }
        }
        return res;
    }

    private int getArea(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = 2;

        return 1 + getArea(grid, r - 1, c)
                + getArea(grid, r + 1, c)
                + getArea(grid, r, c - 1)
                + getArea(grid, r, c + 1);
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
