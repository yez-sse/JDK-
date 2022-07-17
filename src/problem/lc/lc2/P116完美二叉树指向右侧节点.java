package problem.lc.lc2;

import problem.struct.Node;

import java.util.LinkedList;
import java.util.Queue;

public class P116完美二叉树指向右侧节点 {

    //层次遍历这个就可以适用于所有二叉树，但这里不需要queue，一个指针就够了
    public Node connect3(Node root) {
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node(-1);  //当前层节点，把下一层节点串成一个列表
            Node pre = dummy;

            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }

            cur = dummy.next;
        }
        return root;
    }


    //这是完美二叉树的情况，那一般的二叉树呢
    public Node connect(Node root) {
        Node ptr = root;
        while (ptr.left != null) {  //ptr管理的是下一层，所以要先看下一层是否为空，为空就算了
            Node nextIdx = ptr;
            while (nextIdx != null) {
                nextIdx.left.next = nextIdx.right;

                if (nextIdx.right != null) {
                    nextIdx.right.next = nextIdx.next.left;
                }

                nextIdx = nextIdx.next;
            }
            ptr = ptr.left;
        }
        return root;
    }

    //这个我写的，比较好想，OnOn的复杂度
    public Node connect2(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int tempSize = queue.size();
            for (int i = 0; i < tempSize; i++) {
                Node tempNode = queue.poll();
                if (!queue.isEmpty()) {
                    tempNode.next = queue.peek();
                } else {
                    tempNode.next = null;
                }
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
        return root;
    }
}
