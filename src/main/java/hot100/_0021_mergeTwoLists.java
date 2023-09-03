package hot100;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-09-02-22:00
 * @Desc:
 */
public class _0021_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode temp = new ListNode(-1);
        ListNode cur = temp;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b.next;
                b = b.next;
            }
            cur = cur.next;

        }

        cur.next = a != null ? a : b;
        return temp.next;
    }
}
