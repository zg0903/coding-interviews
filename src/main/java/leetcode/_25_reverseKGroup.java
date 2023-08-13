package leetcode;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name leetcode
 * @date 2022-11-20-15:34
 * @Desc:给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表
 */
public class _25_reverseKGroup {
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
