package problem.struct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
//    public static void main(String[] args) {
//        Map<Integer, Node> map = new HashMap<>();
//        map.put(1, new Node(1, 1));
//        map.put(1, new Node(1, 2));
//        System.out.println(map.get(1).val);
//        System.out.println(map.size());
//    }
    public int key;
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;
    public List<Node> neighbors;

    public Node(int val) {
        this.val = val;
        left = null;
        right = null;
        next = null;
        random = null;
        neighbors = new ArrayList<>();
    }

    public Node(int key, int val) {
        this.val = val;
        this.key = key;
        left = null;
        right = null;
        next = null;
        random = null;
        neighbors = new ArrayList<>();
    }
}
