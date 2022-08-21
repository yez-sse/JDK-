package problem.prob;

import java.util.*;

class Point2 {
    int x;
    int y;
    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution2 {

    private int res = Integer.MAX_VALUE;
    private ArrayList<Point2> list = new ArrayList<>();
    private ArrayList<Point2> resList = new ArrayList<>();

    public ArrayList<Point2> winMazeGift(int[][] maze) {
        for (int i = 0; i < 3; i++) {
            if (maze[0][i] == 0) {
                dfs(maze, 0, i, 1);
            }
            if (maze[i][3] == 0) {
                dfs(maze, i, 3, 1);
            }
            if (maze[3][3-i] == 0) {
                dfs(maze, 3, 3 - i, 1);
            }
            if (maze[3-i][0] == 0) {
                dfs(maze, 3 - i, 0, 1);
            }
        }
        return resList;
    }

    public void dfs(int[][] maze, int i, int j, int sum) {
        if (i < 0 || i > 3 || j < 0 || j > 3) {
            return;
        }
        if (maze[i][j] == 1) {
            return;
        }
        if (maze[i][j] == 8) {
            if (sum < res) {
                res = sum;
                list.add(new Point2(i, j));
                resList = new ArrayList<>(list);
                list.remove(list.size() - 1);
            }
            return;
        }
        if (maze[i][j] == 0) {
            list.add(new Point2(i, j));
            dfs(maze, i - 1, j, sum + 1);
            dfs(maze, i + 1, j, sum + 1);
            dfs(maze, i, j - 1, sum + 1);
            dfs(maze, i, j + 1, sum + 1);
            list.remove(list.size() - 1);
        }
    }
}
