package problem.lc.lc2;

import problem.struct.ListNode;

import java.util.HashMap;
import java.util.Map;

public class P143重排链表 {

    public void reorderList2(ListNode head) {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        head = head.next;
        tail.next = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        return tail;    //return head 那就是null了已经
    }

    //自己写的暴力，击败了8.9%
    public void reorderList(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode p = head;
        int idx = 1;
        while (p != null) {
            map.put(idx, p);
            idx++;
            p = p.next;
        }
        int left = 1, right = idx - 1;
        ListNode dummy = new ListNode(-1);
        while (left <= right) {
            dummy.next = map.get(left);
            dummy = dummy.next;
            if (left < right) {
                dummy.next = map.get(right);
                dummy = dummy.next;
            }
            left++;
            right--;
        }
        dummy.next = null;  //避免有环
    }
}
