package hot100;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-31-22:39
 * @Desc:K 个一组翻转链表
 */
public class _0025_reverseKGroup {


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode next = null;
        int count = 1;
        while (count < k) {
            curr = curr.next;
            if (curr == null) {
                return head;
            }
            count++;
        }
        next = curr.next;
        curr.next = null;

        reseverSigleListNode(head);


        if (next != null) {
            head.next = reverseKGroup(next, k);

        }
        return curr;


    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reseverSigleListNode(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }


    public ListNode reseverSigleListNode(ListNode signode) {
        ListNode prev = null; // prev : 指向反转好节点的最后一个节点
        ListNode curr = signode;    //指向反转链表的第一个节点
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

}
