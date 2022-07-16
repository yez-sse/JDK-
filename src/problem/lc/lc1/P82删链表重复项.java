package problem.lc.lc1;

import problem.one.ListNode;

public class P82删链表重复项 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);    //有时候要借助一个新头部
        newHead.next = head;
        ListNode p = newHead;
        ListNode q = head;
        while (q != null && q.next != null) {   //这里注意不要漏掉了q != null
            if (q.val == q.next.val) {
                while (q.next != null && q.val == q.next.val) {
                    q.next = q.next.next;
                }
                p.next = q.next;
                q = q.next;
            } else {
                q = q.next;
                p = p.next;
            }
        }
        return newHead.next;
    }
}
