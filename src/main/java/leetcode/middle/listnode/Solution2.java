package leetcode.middle.listnode;

import leetcode.primary.listnode.ListNode;

/**
 * @author yejc
 * @date 2020/1/14 20:14
 */
public class Solution2 {

    /**
     * 两数相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int n = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;

            ListNode node = new ListNode(n);
            curr.next = node;
            curr = node;

            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int n = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;

            ListNode node = new ListNode(n);
            curr.next = node;
            curr = node;

            l1 = l1.next;
        }
        while (l2 != null) {
            int n = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;

            ListNode node = new ListNode(n);
            curr.next = node;
            curr = node;

            l2 = l2.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(1);
            curr.next = node;
            curr = node;
        }
        return dummy.next;
    }

    /**
     * 奇偶链表
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    /**
     * 相交链表
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode headA1 = new ListNode(2);
        ListNode headA2 = new ListNode(3);
        ListNode headA3 = new ListNode(6);
        headA.next = headA1;
        headA1.next = headA2;
        headA2.next = headA3;

        ListNode headB = new ListNode(4);
        headB.next = headA2;

        Solution2 solution2 = new Solution2();
        ListNode node = solution2.getIntersectionNode(headA, headB);
        System.out.println(node.val);
    }
}
