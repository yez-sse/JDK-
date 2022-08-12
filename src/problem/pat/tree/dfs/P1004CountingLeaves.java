package problem.pat.tree.dfs;

import java.util.*;

public class P1004CountingLeaves {

    //树的高度
    private static int height = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        //map存储某个节点和它的子节点，最多n个
        Map<Integer, List<Integer>> map = new HashMap<>();
        //记录每层的叶子节点数，最多n个
        int[] record = new int[n];

        //很正常的初始化
        for (int i = 0; i < m; i++) {
            int id = in.nextInt();
            int k = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                list.add(in.nextInt());
            }
            map.put(id, list);
        }

        //题目规定根节点是1
        dfs(map, record, 1, 0);
        for (int i = 0; i <= height; i++) {
            System.out.print(record[i]);
            if (i != height) {
                System.out.print(" ");
            }
        }
    }

    public static void dfs(Map<Integer, List<Integer>> map, int[] record, int curNode, int level) {
        if (map.get(curNode) == null) {
            record[level]++;
            height = Math.max(height, level);
            return;
        }
        for (int i = 0; i < map.get(curNode).size(); i++) {
            dfs(map, record, map.get(curNode).get(i), level + 1);
        }
    }
}
