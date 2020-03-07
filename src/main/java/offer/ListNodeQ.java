package offer;

import leetcode.primary.listnode.ListNode;

/**
 * @author yejc
 * @date 2020/3/7 14:47
 */
public class ListNodeQ {

    /**
     * 从尾到头打印链表
     *
     * @param listNode
     */
    public void reversePrint(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        reversePrint(listNode.next);
        System.out.print(listNode.val + "->");
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        ListNodeQ listNodeQ = new ListNodeQ();
        listNodeQ.reversePrint(n1);
    }
}
