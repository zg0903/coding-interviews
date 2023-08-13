package zhihu.lianbiao;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name zhihu
 * @date 2022-02-28-20:56
 * @Desc:表中环的入口结点 https://zhuanlan.zhihu.com/p/103626709
 * 设置快慢指针，假如有环，他们最后一定相遇在环中。
 * 两个指针相遇后，让两个指针分别从链表头和相遇点重新出发，每次走一步，最后一定相遇于环入口。
 */
public class EntryNodeOfLoop {


    public ListNode EntryNodeOfLoop(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = fast.next;
//            说明到此有环
            if (fast == slow) {
                fast = head;
//                //如果有环，两个指针分别从链表头和相遇点出发，最终必定在环入口相遇
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;

            }
        }
        return null;
    }


}
