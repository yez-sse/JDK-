package problem.lc.lc2;

import problem.struct.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class P146LRU缓存 {

    LinkedList<Node> list;
    Map<Integer, Node> map;
    int size;
    int capacity;
    Node head;
    Node tail;

    public P146LRU缓存(int capacity) {
        list = new LinkedList<>();
        map = new HashMap<>();
        size = 0;
        this.capacity = capacity;
        head = new Node(-1);
        tail = new Node(-1);
        head.right = tail;
        tail.left = head;
    }

    public int get(int key) {
        int value = -1;
        if (map.get(key) != null) {
            value = map.get(key).val;
            moveToHead(removeNode(map.get(key)));
        }
        return value;
    }

    public Node removeNode(Node node) {
        node.left.right = node.right;
        node.right.left = node.left;
        node.left = null;
        node.right = null;
        return node;
    }

    public void moveToHead(Node node) {
        node.right = head.right;
        node.left = head;
        head.right.left = node;
        head.right = node;
    }

    public void put(int key, int value) {
        Node node = new Node(value);
        if (map.get(key) != null) {
            removeNode(map.get(key));
        }
        map.put(key, node);
        moveToHead(node);
        if (map.size() > capacity) {
            removeNode(tail.left);
        }
    }
}
