package offer;

import leetcode.primary.listnode.ListNode;

/**
 * 删除链表的节点
 *
 * @author yejc
 * @date 2020/3/11 20:05
 */
public class DeleteNode {
    /**
     * 给定链表的头节点和要删除的节点，O(1)删除节点
     *
     * @param head
     * @param node
     */
    public void delete(ListNode head, ListNode node) {
        if (node.next != null) {
            // 如果要删除的节点不是尾节点，可以将下一个节点的值复制到当前节点，然后当前节点的next指针指向下下节点
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;
        } else {
            // 如果删除的是尾节点，需要遍历
            ListNode curr = head;
            while (curr.next != node) {
                curr = curr.next;
            }
            curr.next = null;
        }
    }

    /**
     * 删除重复节点
     *
     * @param head
     * @return
     */
    public ListNode deleteRepeatedNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val != curr.next.val) {
                curr = curr.next;
            }
            ListNode node = curr;
            while (node.next != null && node.val == node.next.val) {
                node = node.next;
            }
            curr.next = node.next;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        DeleteNode deleteNode = new DeleteNode();
        ListNode head = deleteNode.deleteRepeatedNode(n1);
        System.out.println(head);
    }
}
