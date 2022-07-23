package problem.lc.lc2;

import problem.struct.ListNode;

public class P160相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            if (p.next == null && q.next == null) {
                return null;    //这个判断是不能少的
            }
            if (p.next == null) {
                p = headB;
            } else {
                p = p.next;
            }
            if (q.next == null) {
                q = headA;
            } else {
                q = q.next;
            }
        }
        return p;
    }
}
