package problem.lc.lc2;

import problem.struct.ListNode;

public class P203移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (p != null) {
            while (p.next != null && p.next.val == val) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return dummy.next;
    }

    //P206反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = head;
        ListNode q = head.next;
        while (p != null) {
            p.next = dummy.next;
            dummy.next = p;
            p = q;
            if (q != null) {
                q = q.next;
            }
        }
        return dummy.next;
    }
}
