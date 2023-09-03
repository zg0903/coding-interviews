package hot100;

import java.util.HashSet;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-09-02-22:53
 * @Desc:环形链表 II给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class _0142_detectCycle {


    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            boolean add = hashSet.add(curr);
            if (!add) {
                return curr;
            }
            curr = curr.next;

        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode ans = head;
                while (ans != slow) {
                    ans = ans.next;
                    slow = slow.next;
                }
                return ans;
            }
        }
        return null;
    }


}
