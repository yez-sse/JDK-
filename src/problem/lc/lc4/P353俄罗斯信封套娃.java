package problem.lc.lc4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P353俄罗斯信封套娃 {

    private int max = 0;
    private List<int[]> list;
    private boolean[] visited;

    public int maxEnvelopes(int[][] envelopes) {
        list = new ArrayList<>();
        visited = new boolean[envelopes.length];
        dfs(envelopes);
        return max;
    }

    public void dfs(int[][] envelopes) {
        if (list.size() > max) {
            max = list.size();
        }
        if (list.size() == envelopes.length) {
            return;
        }
        for (int i = 0; i < envelopes.length; i++) {
            if (list.size() > 0 &&
                    (list.get(list.size() - 1)[0] <= envelopes[i][0]
                            || list.get(list.size() - 1)[1] <= envelopes[i][1])) {
//                return;
                continue;
            }
            if (visited[i]) {
                continue;
            }
            list.add(envelopes[i]);
            visited[i] = true;
            dfs(envelopes);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }


    // 上面那个超时，下面是标准答案
    public int maxEnvelopes2(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int len = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[]t1, int[] t2) {
                if (t1[0] != t2[0]) {
                    return t1[0] - t2[0];
                } else {
                    return t1[1] - t2[1];
                }
            }
        });

        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
