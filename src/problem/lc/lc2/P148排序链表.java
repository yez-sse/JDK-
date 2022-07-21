package problem.lc.lc2;

import problem.struct.ListNode;

public class P148排序链表 {

    public ListNode sortList(ListNode head) {
        return dfs(head);
    }

    public ListNode dfs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head;
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        ListNode right = dfs(p.next);
        p.next = null;
        ListNode left = dfs(head);

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                pre.next = left;
                left = left.next;
                pre = pre.next;
                pre.next = null;
            } else {
                pre.next = right;
                right = right.next;
                pre = pre.next;
                pre.next = null;
            }
        }
        while (left != null) {
            pre.next = left;
            left = left.next;
            pre = pre.next;
            pre.next = null;
        }
        while (right != null) {
            pre.next = right;
            right = right.next;
            pre = pre.next;
            pre.next = null;
        }
        return dummy.next;
    }
}
