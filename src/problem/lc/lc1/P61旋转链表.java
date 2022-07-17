package problem.lc.lc1;

import problem.struct.ListNode;

public class P61旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        int len = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            len++;
        }
        int add = len - k % len;
        if (add == len) {
            return head;
        }

        iter.next = head;   //成环了
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;

        //我写的，也能通过
//        int len = 0;
//        ListNode p = head;
//        ListNode t = head;
//        while (p != null) {
//            len++;
//            p = p.next;
//            t = t.next;
//        }
//        p = head;
//        k = k % len;
//
//        for (int i = 0; i < len - k - 1; i++) {
//            p = p.next;
//        }
//        ListNode res = p.next;
//        if (res != null) {
//            t.next = head;
//            return res;
//        }
//        return head;
    }
}
