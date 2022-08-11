package problem.lc.lc3;

import java.util.*;

public class P207课程表_拓扑排序 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //<课号，入度>
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }

        //<课号，依赖该课号的后续课程>
        Map<Integer, List<Integer>> adj = new HashMap<>();

        //初始化入度和依赖关系
        for (int[] relate : prerequisites) {
            //pre学完才能cur，pre指向cur，cur就增加一个入度
            int pre = relate[1];
            int cur = relate[0];
//            inDegree.put(cur, inDegree.getOrDefault(cur, 0) + 1); 这么写没有初始化，后面会有问题
            inDegree.put(cur, inDegree.get(cur) + 1);
            //更新前置节点的邻接表
            if (!adj.containsKey(pre)) {
                adj.put(pre, new ArrayList<>());
            }
            adj.get(pre).add(cur);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int key : inDegree.keySet()) {
            //入度为0就是没有前修课程，
            if (inDegree.get(key) == 0) {
                q.offer(key);
            }
        }

        while (!q.isEmpty()) {
            int pre = q.poll();
            if (!adj.containsKey(pre)) {
                continue;
            }
            //递减后继节点的入度，要达到的效果的是，所有节点的入度都为零才对
            List<Integer> successorList = adj.get(pre);
            for (int cur : successorList) {
                inDegree.put(cur, inDegree.get(cur) - 1);
                if (inDegree.get(cur) == 0) {
                    q.offer(cur);
                }
            }
        }

        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}
