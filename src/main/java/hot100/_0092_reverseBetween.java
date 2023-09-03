package hot100;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-30-23:06
 * @Desc: 反转链表 II  给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * https://leetcode.cn/problems/reverse-linked-list-ii/solutions/1600012/92-by-ren-feiye-htz3/
 */
public class _0092_reverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode end = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
            end = end.next;
        }
        for (int i = 0; i < right - left + 1; i++) {
            end = end.next;
        }
        ListNode start = pre.next;
        ListNode next = end.next;
        end.next = null;
        pre.next = reverse(start);
        start.next = next;
        return dummy.next;

    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    //    递归
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (left == 1) {
            // 沿用reverseN方法
            return reverseN(head, right);
        }
        head.next = reverseBetween2(head.next, left - 1, right - 1);
        return head;
    }

    ListNode lastNext = null;

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            lastNext = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, n - 1);
        head.next.next = head;
        // 将原来的head的next指向原来的第N+1个节点
        head.next = lastNext;
        return newHead;
    }


}
