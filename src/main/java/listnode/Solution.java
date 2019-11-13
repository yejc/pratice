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
        ListNode nextNode = head.next;
        ListNode reHead = reverseList1(nextNode);
        nextNode.next = head;
        head.next = null;
        return reHead;
    }

    /**
     * 反转链表（迭代）
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
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
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 == null) {
            curr.next = l2;
        }
        if (l2 == null) {
            curr.next = l1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;

        Solution solution = new Solution();
        System.out.println(solution.reverseList2(n1).val);
    }


}
