package problem.代码随想录.b链表;

import problem.struct.ListNode;

public class c206翻转链表 {

    // reverse the list without head-insertion method

    // double point method
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {   // weird, noticed pre at the end
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // how to use Iteration method ?
}
