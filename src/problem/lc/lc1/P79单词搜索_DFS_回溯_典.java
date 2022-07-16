package problem.lc.lc1;

public class P79单词搜索_DFS_回溯_典 {

    private static final int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private boolean[][] visited;
    private char[] charArray;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        charArray = word.toCharArray();
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, word.length())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int idx, int len) {
//        if (idx == len) {   //如果这么写的话，[["a"]] "a"，这种情况过不了
//            return true;
//        }
        if (idx == len - 1) {
            return board[i][j] == charArray[len - 1];
        }
        if (board[i][j] == charArray[idx]) {
            visited[i][j] = true;
            for (int[] direction : directions) {
                int newI = i + direction[0];
                int newJ = i + direction[1];
                if (inArea(newI, newJ) && !visited[newI][newJ]) {   //注意这里是新的
                    if (dfs(newI, newJ, idx+1, len)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    public boolean inArea(int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
