package listnode;

public class Solution {
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
        // 双指针法，先让尾指针领先头指针n个节点，然后进行遍历，每次遍历首尾指针都向后一个节点，等到尾指针指向空节点，首指针值向的即为要删除的节点
        ListNode tail = head;
        for (int k = 0; k < n; k++) {
            tail = tail.next;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (tail != null) {
            prev = curr;
            curr = curr.next;
            tail = tail.next;
        }
        if (prev == null) {
            return head.next;
        }
        prev.next = prev.next.next;
        curr.next = null;
        return head;
    }
}
