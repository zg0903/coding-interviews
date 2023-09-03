package hot100;

import java.util.HashSet;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-09-02-22:27
 * @Desc:环形链表
 */
public class _141_hasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            boolean add = hashSet.add(curr);
            if (!add) {
                return true;
            }
            curr = curr.next;

        }
        return false;
    }

}
