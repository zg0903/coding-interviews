package zhihu.lianbiao;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name zhihu
 * @date 2022-02-27-16:52
 * @Desc:
 */
public class reverseList {


    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;

        while (cur != null) {
            // 当前结点的后一结点需要保存下来
            next = cur.next;
            // 反转
            cur.next = pre;
            // 指针前移
            pre = cur;
            cur = next;
        }

        return pre;


    }

    //递归
    public ListNode reverseListRecur(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode revHead = reverseListRecur(head.next);
        ListNode nextNode = head.next;
        nextNode.next = head;
        head.next = null;
        return revHead;
    }


}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}