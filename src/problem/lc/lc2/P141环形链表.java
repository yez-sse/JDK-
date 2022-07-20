package problem.lc.lc2;

import problem.struct.ListNode;

public class P141环形链表 {

    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (q != null && p == q) {
                return true;
            }
        }
        return false;
    }

    //走a+nb步一定是在环入口，第一次相遇时慢指针已经走了nb步
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (q != null && p == q) {
                break;
            }
        }
        if (q != null && q.next != null) {
            q = head;
            while (p != q) {
                p = p.next;
                q = q.next;
            }
            return p;
        }
        return null;
    }

    //自己写的，这么想稍微想复杂了
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;    //这道题要考虑的细节很多
        }
        ListNode p = head;
        ListNode q = head;
        int circleLength = 0;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            circleLength++;
            if (q != null && p == q) {
                break;
            }
        }
        if (q != null && q.next != null) {  //这道题要考虑的细节很多
            p = head;
            q = head;
            for (int i = 0; i < circleLength; i++) {
                q = q.next;
            }
            while (p != q) {
                p = p.next;
                q = q.next;
            }
            return p;
        }
        return null;
    }
}
