package problem.prob;

import java.util.*;

public class Main {

    private static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] n = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                n[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (n[0][i] == 0) {
                dfs(n, 0, i);
            }
            if (n[0][i] == 0) {
                dfs(n, 0, i);
            }
        }
    }

    public static void dfs(int[][] n, int i, int j) {

    }
}