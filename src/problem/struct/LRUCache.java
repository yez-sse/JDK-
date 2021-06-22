package problem.struct;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    /**
     * cache的结构是什么样的，是Map<Key, Node>，通过key值来找到对应node，一对一
     *
     * capacity是我们设置的cache的容量，size表示当前cache中有多少插入进去的节点
     *
     * head和tail是每个LRUCache对象在创建时都要有的
     */
    private Map<Integer, DLinkedNode> cache;
    private int capacity, size;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void moveToHead(DLinkedNode node) {
        remove(node);
        addToHead(node);
    }

    public void remove(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void addToHead(DLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            addToHead(newNode);
            cache.put(key, newNode);

            ++size;
            if (size > capacity) {
                DLinkedNode listTail = tail.prev;

            }
        }
    }

    public void removeTail() {

    }
}
