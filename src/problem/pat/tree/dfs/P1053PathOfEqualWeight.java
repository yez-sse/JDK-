package problem.pat.tree.dfs;

import java.util.*;

class Node1053 {
    int w;
    List<Integer> child;

    public Node1053(int w, ArrayList<Integer> child) {
        this.w = w;
        this.child = child;
    }
}

public class P1053PathOfEqualWeight {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int target = in.nextInt();

        Node1053[] nodes = new Node1053[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node1053(in.nextInt(), new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int id = in.nextInt();
            int k = in.nextInt();
            for (int j = 0; j < k; j++) {
                nodes[id].child.add(in.nextInt());
            }
            Collections.sort(nodes[i].child, Comparator.comparingInt(t -> nodes[t].w));
        }
        dfs(nodes, target, 0, new ArrayList<>(), 0);
    }

    public static void dfs(Node1053[] nodes, int target, int index, List<Integer> path, int sum) {
        if (sum > target) {
            return;
        }
        path.add(index);
        sum += nodes[index].w;
        if (sum == target) {
            if (nodes[index].child.size() != 0) {
                return;
            }
            for (int i = 0; i < path.size(); i++) {
                System.out.printf("%d%c", nodes[path.get(i)].w, i != path.size() - 1 ? ' ' : '\n');
            }
            return;
        }
        for (int i = 0; i < nodes[index].child.size(); i++) {
            dfs(nodes, target, nodes[index].child.get(i), path, sum);
            path.remove(path.size() - 1);
        }
        sum -= nodes[index].w;
        path.remove(path.size() - 1);
    }
}
