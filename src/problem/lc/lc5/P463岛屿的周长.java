package problem.lc.lc5;

public class P463岛屿的周长 {

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // 题目说的只有一个岛屿，跟着题目的来
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return 1;
        }
        if (grid[r][c] == 0) {
            return 1;
        }

        if (grid[r][c] ==2) {
            return 0;
        }
        grid[r][c] = 2;

        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
