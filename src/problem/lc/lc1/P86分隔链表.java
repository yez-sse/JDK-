package problem.lc.lc1;

import problem.struct.ListNode;

public class P86分隔链表 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode tail1 = newHead;
        ListNode tail2 = newHead;
        ListNode p = head;
        ListNode q = p.next;
        while (p != null) {
            if (p.val < x) {
                p.next = tail1.next;
                tail1.next = p;
                p = q;
                if (q != null) {
                    q = q.next;
                }
                tail1 = tail1.next;
                if (tail2.next != null && tail2.next.val < x) {
                    tail2 = tail1;
                }
            } else {
                p.next = tail2.next;
                tail2.next = p;
                p = q;
                if (q != null) {
                    q = q.next;
                }
                tail2 = tail2.next;
            }
        }
        return newHead.next;
    }
}
