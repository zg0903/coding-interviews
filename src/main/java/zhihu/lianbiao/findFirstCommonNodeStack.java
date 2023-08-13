package zhihu.lianbiao;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name zhihu
 * @date 2022-03-01-21:11
 * @Desc:两个链表的第一个公共结点
 */
public class findFirstCommonNodeStack {
    public ListNode findFirstCommonNodeSet(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        while (cur1 != null) {
            set.add(cur1);
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            if (!set.add(cur2)) return cur2;
            cur2 = cur2.next;
        }
        return null;
    }


    public static ListNode firstCommonNode01(ListNode head1, ListNode head2) {
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int len1 = 0;
        int len2 = 0;
        while (cur1 != null) {
            len1++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            len2++;
            cur2 = cur2.next;
        }
        cur1 = head1;
        cur2 = head2;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                cur1 = cur1.next;
            }
        }

        if (len1 < len2) {
            for (int i = 0; i < len2 - len1; i++) {
                cur2 = cur2.next;
            }
        }
        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return null;
    }


    public ListNode firstCommonNode02(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }
        return p1;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(13);
        ListNode listNode6 = new ListNode(20);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;


        ListNode istNode1 = new ListNode(3);
        ListNode istNode2 = new ListNode(6);
        ListNode istNode3 = new ListNode(9);
        ListNode istNode4 = new ListNode(13);
        ListNode istNode5 = new ListNode(20);
        istNode1.next = listNode3;
//        istNode2.next = listNode3;
//        istNode3.next = listNode4;
//        istNode4.next = listNode5;
//        istNode5.next = listNode6;

        ListNode cur1 = listNode1;
        ListNode cur2 = istNode1;
        while (cur1 != null) {
            System.out.println(cur1.val);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            System.out.println(cur2.val);
            cur2 = cur2.next;
        }
        System.out.println("----------------------相交----------------");
        System.out.println(findFirstCommonNodeStack.firstCommonNode01(listNode1, istNode1).val);


    }


}
