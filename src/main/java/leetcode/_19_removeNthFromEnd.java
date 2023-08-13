package leetcode;


import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name leetcode
 * @date 2022-10-30-11:12
 * @Desc:给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class _19_removeNthFromEnd {


    //方法一：计算链表长度 时间复杂度：O(L)O(L)O(L)，其中 LLL 是链表的长度。空间复杂度：O(1)O(1)O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);
        ListNode copyHead = new ListNode(0, head);
        ListNode current = copyHead;

        for (int i = 1; i < length - n + 1; ++i) {
            current = current.next;
        }
        current.next = current.next.next;
        ListNode node = copyHead.next;
        return node;

    }

    //方法二：栈
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode copeHead = new ListNode(0, head);

        LinkedList<ListNode> stack = new LinkedList<>();

        ListNode current = copeHead;

        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode peek = stack.peek();
        peek.next = peek.next.next;
        ListNode ans = copeHead.next;
        return ans;


    }


    public int getLength(ListNode head) {
        int i = 0;
        while (head != null) {
            ++i;
            head = head.next;
        }
        return i;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}



