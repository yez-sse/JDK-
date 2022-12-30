package problem.代码随想录.b链表;

import problem.struct.ListNode;

public class b707设计链表 {
    // you must have a head node, right?
    ListNode head;

    public b707设计链表() {
        // you have your variable initialized in Constructor, right?
        head = new ListNode(-1);
    }

    public int get(int index) {
        ListNode cur = head;
        while (cur != null && index-- > 0) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next = node;
    }

    public void addAtTail(int val) {
        ListNode cur = head;
        ListNode node = new ListNode(val);
        while (cur.next != null) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
    }

    public void addAtIndex(int index, int val) {
        ListNode cur = head;
        ListNode node = new ListNode(val);
        while (--index > 0) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
    }

    public void deleteAtIndex(int index) {
        ListNode cur = head;
        while (--index > 0) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }
}
