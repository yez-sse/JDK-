package problem.lc.lc2;

import problem.struct.Node;

import java.util.HashMap;
import java.util.Map;

public class P134复制带随机指针的链表_map {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            if (temp == head) {
                dummy.next = newNode;
            }
            map.put(temp, newNode);
            temp = temp.next;
        }
        temp = head;
        Node temp2 = dummy.next;
        while (temp != null) {
            temp2.next = map.get(temp.next);
            temp2.random = map.get(temp.random);
            temp = temp.next;
            temp2 = temp2.next;
        }
        return dummy.next;
    }
}
