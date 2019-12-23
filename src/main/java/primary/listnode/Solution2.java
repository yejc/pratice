package primary.listnode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: pratice
 * @description: 链表第二次练习
 * @author: yejc
 * @create: 2019-11-17 09:41
 **/
public class Solution2 {

    /**
     * 删除链表中的节点
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 删除链表的倒数第N个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode prev = null;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            prev = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        // 如果删除的是头结点，返回头结点下一个节点
        if (prev == null) {
            return head.next;
        }
        // 如果删除的不是头结点，删除节点后返回头结点
        prev.next = p1.next;
        p1.next = null;
        return head;
    }

    /**
     * 反转链表（递归）
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rehead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return rehead;
    }

    /**
     * 反转链表（迭代）
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    /**
     * 回文链表
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        // 利用快慢指针找到链表中间节点，然后反转后半部分链表，迭代对比
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p1 = dummy, p2 = dummy;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // 切断后半部分链表
        p2 = p1.next;
        p1.next = null;

        // 反转后半部分链表
        ListNode pre = null;
        while (p2 != null) {
            ListNode next = p2.next;
            p2.next = pre;
            pre = p2;
            p2 = next;
        }

        // 两个链表迭代对比
        p1 = head;
        while (pre != null) {
            if (p1.val != pre.val) {
                return false;
            }
            p1 = p1.next;
            pre = pre.next;
        }
        return true;
    }

    /**
     * 全排列
     */
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        helper(nums, arr);
        return result;
    }

    public void helper(int[] nums, List<Integer> arr) {
        if (arr.size() == nums.length) {
            result.add(arr);
            return;
        }
        for (int i : nums) {
            if (!arr.contains(i)) {
                List<Integer> newArr = new ArrayList<>(arr);
                newArr.add(i);
                helper(nums, newArr);
            }
        }
    }

    /**
     * 环形链表
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head, p2 = head.next;
        while (p2 != null && p2.next != null) {
            if (p1 == p2) {
                return true;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return false;
    }
}
