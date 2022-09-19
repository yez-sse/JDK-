package problem.lc.lc9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class P827最大人工岛 {

    private int left = 1;

    public int largestIsland(int[][] grid) {
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

    int getArea(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] == 2) {
            return 0;
        } else if (grid[r][c] == 0 && left == 0) {
            return 0;
        } else if (grid[r][c] == 0 && left == 1) {
            left--;
            grid[r][c] = 2;
        } else {
            grid[r][c] = 2;
        }

        return 1 + getArea(grid, r, c)
                 + getArea(grid, r, c)
                 + getArea(grid, r, c)
                 + getArea(grid, r, c);
    }

    boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}

class Solution2 {

    public int largestIsland(int[][] grid) {
        int res = 0;
        int idx = 53;   // 大于0或1的任意一个数都可以
        Map<Integer, Integer> idxArea = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = getArea(grid, i, j, idx);
                    idxArea.put(idx, area);
                    idx++;
                    res = Math.max(res, area);
                }
            }
        }

        if (res == 0) {
            return 1;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> set = findNeighbour(grid, i, j);
                    if (set.size() < 1) {
                        continue;
                    }
                    int twoIsland = 1;
                    for (Integer tempIdx : set) {
                        twoIsland += idxArea.get(tempIdx);
                    }
                    res = Math.max(res, twoIsland);
                }
            }
        }
        return res;
    }

    private HashSet<Integer> findNeighbour(int[][] grid, int r, int c) {
        HashSet<Integer> set = new HashSet<>();
        if (inArea(grid, r - 1, c) && grid[r - 1][c] != 0) {
            set.add(grid[r - 1][c]);
        }
        if (inArea(grid, r + 1, c) && grid[r + 1][c] != 0) {
            set.add(grid[r + 1][c]);
        }
        if (inArea(grid, r, c - 1) && grid[r][c - 1] != 0) {
            set.add(grid[r][c - 1]);
        }
        if (inArea(grid, r, c + 1) && grid[r][c + 1] != 0) {
            set.add(grid[r][c + 1]);
        }
        return set;
    }

    private int getArea(int[][] grid, int r, int c, int idx) {
        if (!inArea(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = idx;
        return 1 + getArea(grid, r - 1, c, idx)
                 + getArea(grid, r + 1, c, idx)
                 + getArea(grid, r, c - 1, idx)
                 + getArea(grid, r, c + 1, idx);
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
