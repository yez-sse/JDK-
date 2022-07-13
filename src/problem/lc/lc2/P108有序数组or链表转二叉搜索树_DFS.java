package problem.lc.lc2;

import problem.one.ListNode;
import problem.prob.TreeNode;

import java.util.Arrays;

public class P108有序数组or链表转二叉搜索树_DFS {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode quick = head;
        ListNode preSlow = null;
        while (quick != null && quick.next != null) {
            preSlow = slow;
            slow = slow.next;
            quick = quick.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if (preSlow != null) {
            preSlow.next = null;
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
