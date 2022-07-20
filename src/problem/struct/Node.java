package problem.struct;

import java.util.ArrayList;
import java.util.List;

public class Node {
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
}
