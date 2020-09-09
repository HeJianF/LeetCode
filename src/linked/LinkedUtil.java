package linked;

import java.util.Arrays;
import java.util.List;

class LinkedUtil {

    /**
     * 反转链表
     * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null, next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 两两交换链表
     * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
     *
     * @param head
     * @return
     */
    static ListNode swapPairs(ListNode head) {
        //方法一 递归
        /*if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode scenod = head.next;

        first.next = swapPairs(scenod.next);
        scenod.next = first;

        return scenod;*/

        //方法二
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode preNode = dummy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            preNode.next = second;
            first.next = second.next;
            second.next = first;

            preNode = first;
            head = head.next;
        }
        return dummy.next;
    }

    /**
     * 判断链表是否有环
     * https://leetcode-cn.com/problems/linked-list-cycle/
     *
     * @param head
     * @return
     */
    static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast, slow;
        fast = slow = head;
        while (true) {
            if (slow != null) {
                slow = slow.next;
            } else {
                return false;
            }
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }
    }

    /**
     * 找到有环链表的的第一个位置
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/
     *
     * @param head
     * @return
     */
    static ListNode hasCycleTwo(ListNode head) {
        if (head == null) return null;
        ListNode fast, slow;
        fast = slow = head;
        while (true) {
            if (slow != null) {
                slow = slow.next;
            } else {
                return null;
            }
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (slow == fast) {
                slow = head;
                break;
            }
        }
        while (true) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
    }

    /**
     * 反转链表 k个一组
     * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
     *
     * @param head
     * @param k
     * @return
     */
    static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode newHead = reverseList(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    static ListNode reverseList(ListNode head, ListNode tail) {
        ListNode pre = null, next;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[] sum = new int[]{10, 11, 12, 13, 51, 101, 16};
        System.out.println(Arrays.toString(sortArrayByParity(sum)));
    }

    public static int[] sortArrayByParity(int[] A) {
        if (A == null) return null;
        int pre = 0, next = A.length - 1;
        while (pre < next) {
            if (A[pre] % 2 != 0 && A[next] % 2 == 0) {
                int a = A[pre];
                A[pre] = A[next];
                A[next] = a;
            }
            if (A[pre] % 2 == 0) {
                pre++;
            }
            if (A[next] % 2 != 0) {
                next--;
            }
        }
        return A;
    }
}
