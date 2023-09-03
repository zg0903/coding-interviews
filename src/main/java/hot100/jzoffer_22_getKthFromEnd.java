package hot100;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-09-03-14:38
 * @Desc:剑指 Offer 22. 链表中倒数第k个节点
 */
public class jzoffer_22_getKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummpy = new ListNode(-1, head);
        ListNode fast = dummpy;
        ListNode slow = dummpy;
        int i = 1;
        while (i <= k) {
            fast = fast.next;
            i++;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.next;
    }
}
