package hot100;

import java.util.LinkedList;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-09-03-14:15
 * @Desc:删除链表的倒数第 N 个结点
 */
public class _0019_removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ;
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        int m = 1;
        while (m <= n) {
            fast = fast.next;
            m++;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode next = slow.next.next;
        slow.next = next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode copeHead = new ListNode(0, head);

        LinkedList<ListNode> stack = new LinkedList<>();

        ListNode current = copeHead;

        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode peek = stack.peek();
        peek.next = peek.next.next;
        ListNode ans = copeHead.next;
        return ans;
    }

}
