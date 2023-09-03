package hot100;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-09-03-15:56
 * @Desc:两数相加
 */
public class _0002_addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1!= null){
                l1 = l1.next ;
            }
            if (l2!= null){
                l2 = l2.next ;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);

        }
        return pre.next;
    }
}
