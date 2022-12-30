package problem.代码随想录.b链表;

import problem.struct.ListNode;

public class d两两交换 {

    // Recursion version
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newNode = swapPairs(next.next);
        next.next = head;
        head.next = newNode;

        return next;
    }

    // Iteration version
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {
            ListNode temp = head.next.next;
            //todo
        }
        return dummy.next;
    }
}
