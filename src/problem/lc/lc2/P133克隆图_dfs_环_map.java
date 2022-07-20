package problem.lc.lc2;

import problem.struct.Node;

import java.util.HashMap;
import java.util.Map;

public class P133克隆图_dfs_环_map {

    Map<Integer, Node> visited = new HashMap<>();
    //不加hash是会陷入死循环的，hash判断是否访问过，可以当作破除死循环的方式

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }
        Node root = new Node(node.val);
        visited.put(node.val, root);
        for (int i = 0; i < node.neighbors.size(); i++) {
            root.neighbors.add(cloneGraph(node.neighbors.get(i)));
        }
        return root;
    }
}
