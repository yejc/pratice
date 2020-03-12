package offer;

import leetcode.primary.listnode.ListNode;

/**
 * 链表中倒数第k个节点
 *
 * @author yejc
 * @date 2020/3/12 22:28
 */
public class BackwardK {
    public ListNode find(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        int i = 0;
        while (p1 != null) {
            p1 = p1.next;
            i++;
            if (i > k) {
                p2 = p2.next;
            }
        }
        if (i < k) {
            return null;
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        BackwardK backwardK = new BackwardK();
        ListNode listNode = backwardK.find(n1, 4);
        System.out.println(listNode.val);
    }
}
