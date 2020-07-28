package linked;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * 输入: 1->2->3->4->5->NULL
 */
public class Linked {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        //ListNode node = LinkedUtil.reverseList(node1);
        //ListNode node = LinkedUtil.swapPairs(node1);
        //boolean has = LinkedUtil.hasCycle(node1);
        //ListNode node = LinkedUtil.hasCycleTwo(node1);
        ListNode node = LinkedUtil.reverseKGroup(node1, 2);
        System.out.println(node);
    }

}

