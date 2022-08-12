package problem.pat.graph;

import java.util.*;
import java.util.function.Consumer;

public class P1021DeepestRoot {

    private static int n;
    private static int maxH = 0;
    private static boolean[] vis = new boolean[10010];
    private static List<List<Integer>> e;
    private static List<Integer> tops = new ArrayList<>();
    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        e = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            e.add(new ArrayList<>());
        }
        //反正就是审题啊，题目说了n-1条边
        for (int i = 1; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            e.get(a).add(b);
            e.get(b).add(a);
        }

        int cnt = 0;
        int top1 = 0; //正着反着来一遍，集合才是全的
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(i, 1);
                if (i == 1) {   //如果是只有一个联通图（树，因为只有n-1条边）的话，那i为1的时候就有了
                    if (tops.size() != 0) {
                        top1 = tops.get(0);
                    }
                    for (int j = 0; j < tops.size(); j++) {
                        set.add(tops.get(i - 1));
                    }
                }
                cnt++;
            }
        }
        if (cnt > 1) {
            System.out.printf("Error: %d components", cnt);
        } else {
            //反着再来一遍
            tops.clear();
            maxH = 0;
            Arrays.fill(vis, false);
            dfs(top1, 1);
            for (int i = 0; i < tops.size(); i++) {
                set.add(tops.get(i));
            }
            for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext(); ) {
                System.out.println(iterator.next());
            }
        }
    }

    public static void dfs(int idx, int height) {
        if (height > maxH) {
            tops.clear();
            tops.add(idx);
            maxH = height;
        } else if (height == maxH) {
            tops.add(idx);
        }
        vis[idx] = true;
        for (int i = 0; i < e.get(idx).size(); i++) {
            if (!vis[e.get(idx).get(i)]) {
                dfs(e.get(idx).get(i), height + 1);
            }
        }
    }
}
