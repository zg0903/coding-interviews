package zhihu.lianbiao;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name zhihu
 * @date 2022-02-28-20:31
 * @Desc:链表中倒数第k个结点 https://blog.csdn.net/u013132035/article/details/80467023
 */

public class FindKthToTailInLinkedList {
    public static ListNode FinkKth(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode a = head;
        ListNode b = head;
        //第一个指针先移动k -1步
        for (int i = 0; i < k - 1; i++) {
            if (a.next == null) {
                return null;
            }
            a = a.next;
        }
//两个指针同事移动 直到末尾
        while (a.next != null) {
            a = a.next;
            b = b.next;
        }
        return b;
    }

}



