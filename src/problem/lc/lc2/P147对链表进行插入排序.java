package problem.lc.lc2;

import problem.struct.ListNode;

public class P147对链表进行插入排序 {

    public ListNode insertionSortList2(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val < pre.val) {
                ListNode temp = cur.next;

                ListNode start = dummy;
                while (cur.val > start.next.val) {
                    start = start.next;
                }
                pre.next = cur.next;
                cur.next = start.next;
                start.next = cur;

                cur = temp;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }


    //下面这个自己写的，能行但是480ms，抄答案3ms
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (true) {
            boolean flag = isSorted(dummy);
            if (flag) {
                break;
            }
        }
        return dummy.next;
    }

    public boolean isSorted(ListNode dummy) {
        boolean flag = true;
        ListNode p = dummy;
        ListNode q = dummy.next;
        while (q.next != null) {
            if (q.val > q.next.val) {
                flag = false;
                break;
            } else {
                p = p.next;
                q = q.next;
            }
        }
        if (!flag) {
            p.next = q.next;
            q.next = null;
            while (p.next != null && p.next.val <= q.val) {
                p = p.next;
            }
            q.next = p.next;
            p.next = q;
        }
        return flag;
    }
}
