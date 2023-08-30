package hot100;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-30-23:06
 * @Desc: 反转链表 II https://leetcode.cn/problems/reverse-linked-list-ii/solutions/1600012/92-by-ren-feiye-htz3/
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
}
