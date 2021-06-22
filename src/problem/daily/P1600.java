package problem.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1600 {
    class Node {
        String name;
        Node next;
        Node last;
        boolean isDeleted = false;
        Node(String _name) {
            name = _name;
        }
    }

    Map<String, Node> map = new HashMap<>();
    Node head = new Node(""), tail = new Node("");

    public void ThroneInheritance(String name) {
        Node root = new Node(name);
        root.next = tail;
        head.next = root;
        map.put(name, root);
    }

    public void birth(String pName, String cName) {
        Node c = new Node(cName);
        map.put(cName, c);
        Node p = map.get(pName);
        Node tmp = p;
        while (tmp.last != null) {
            tmp = tmp.last;
        }
        c.next = tmp.next;
        tmp.next = c;
        p.last = c;
    }

    public void death(String name) {
        Node node = map.get(name);
        node.isDeleted = true;
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        Node tmp = head.next;
        while (tmp.next != null) {
            if (!tmp.isDeleted) {
                ans.add(tmp.name);
            }
            tmp = tmp.next;
        }
        return ans;
    }
}
