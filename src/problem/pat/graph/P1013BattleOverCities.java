package problem.pat.graph;

import java.util.*;

public class P1013BattleOverCities {

    private static int n;
    //数组长度肯定是要看题的啊，啥题不审题啊
    private static int[][] e = new int[1010][1010];

    private static boolean[] visit = new boolean[1010];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            e[a][b] = 1;
            e[b][a] = 1;
        }

        for (int i = 0; i < k; i++) {
            //本次失陷的城市
            int a = in.nextInt();
            //a被拿掉后，图中的联通分量
            int cnt = 0;
            //拿掉a！
            Arrays.fill(visit, false);
            visit[a] = true;

            for (int j = 1; j <= n; j++) {
                if (!visit[j]) {
                    dfs(j);
                    cnt++;
                }
            }
            System.out.println(cnt - 1);
        }
    }

    public static void dfs(int idx) {
        visit[idx] = true;
        for (int i = 1; i <= n; i++) {
            if (!visit[i] && e[idx][i] == 1) {
                dfs(i);
            }
        }
    }
}
