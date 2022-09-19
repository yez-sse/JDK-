package problem.lc.lc2;

import problem.struct.UnionFind2;

public class P200岛屿数量_并查集 {

    private int res;
    public int numIslands2(char [][]grid) {
        res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfsGrid(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfsGrid(char[][] grid, int row, int col) {
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0
            || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '2';
        dfsGrid(grid, row - 1, col);
        dfsGrid(grid, row + 1, col);
        dfsGrid(grid, row, col - 1);
        dfsGrid(grid, row, col + 1);
    }




    public int numIslands(char [][]grid) {
        int row = grid.length;
        int col = grid[0].length;
        //'0'的地方
        int spaces = 0;
        int[][] directions = {{1, 0}, {0, 1}};
        UnionFind2 uf2 = new UnionFind2(row * col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    spaces++;
                } else {
                    for (int[] direction : directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (x < row && y < col && grid[x][y] == '1') {
                            uf2.union(i * col + j, x * col   + y);
                        }
                    }
                }
            }
        }
        return uf2.getCount() - spaces;
    }
}

class Solution2 {
    public int numIslands(char[][] grid) {
        int resNum = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    resNum++;
                    countIsland(grid, r, c);
                }
            }
        }
        return resNum;
    }

    void countIsland(char[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return;
        }
        if (grid[r][c] != '1') {
            return;
        }

        grid[r][c] = '2';

        countIsland(grid, r - 1, c);
        countIsland(grid, r + 1, c);
        countIsland(grid, r, c - 1);
        countIsland(grid, r, c + 1);
    }

    boolean inArea(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
