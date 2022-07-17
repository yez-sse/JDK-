package problem.one;

import java.util.HashMap;
import java.util.Map;

class UnionFind {
    //记录每个节点的父节点
    private Map<Integer, Integer> parent;

    //这个初始化方法，还有上面那句，不同的题目不同的情况是会变化的，不要写死了
    public UnionFind(int[] nums) {
        parent = new HashMap<>();
        for (int num : nums) {
            parent.put(num, num);   //初始化时的父节点是自己
        }
    }

    //查找父节点
    public Integer find(int x) {
        if (parent.get(x) == null) {    //有时候逻辑上确实会传来不在数组里的，这就要做判断
            return null;
        }
        int temp = x;
        while (temp != parent.get(temp)) {
            temp = parent.get(temp);
        }
        parent.put(x, temp);
        return temp;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        parent.put(rootX, rootY);
    }
}
