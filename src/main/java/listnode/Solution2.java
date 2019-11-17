package listnode;

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
}
