package problem.lc.lc2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P77组合_DFS_不重复_典 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    public void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, res);    //dfs中遍历不重复前面已遍历元素的时候，就要用这个begin！
            path.removeLast();
        }
    }

    //以下是我写的dfs，能a，但是只能打败5.02%的用户
//    List<List<Integer>> res;
//    List<Integer> path;
//    boolean[] visited;
//
//    public List<List<Integer>> combine(int n, int k) {
//        res = new ArrayList<>();
//        path = new ArrayList<>();
//        visited = new boolean[n + 1];
//        dfs(n, k);
//        return res;
//    }
//
//    public void dfs(int n, int k) {
//        for (int i = 1; i <= n; i++) {
//            if (path.size() == k) {
//                res.add(new ArrayList<>(path));
//                return;
//            }
//            if (visited[i]) {
//                continue;
//            }
//            if (path.size() > 0 && i < path.get(path.size() - 1)) {
//                continue;
//            }
//            path.add(i);
//            visited[i] = true;
//            dfs(n, k);
//            visited[i] = false;
//            path.remove(path.size() - 1);
//        }
//    }
}
