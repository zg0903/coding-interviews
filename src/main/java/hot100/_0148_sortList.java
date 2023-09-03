package hot100;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-31-23:29
 * @Desc: 排序链表
 */
public class _0148_sortList {

//    归并排序1   自顶向下归并排序

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middleNode = findMiddleListNode(head);

        ListNode right = middleNode.next;
        middleNode.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(right);
        ListNode re = mergeListNode(l, r);
        return re;
    }

    private ListNode mergeListNode(ListNode left, ListNode right) {
        ListNode temp = new ListNode(-1);
        ListNode cur = temp;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return temp.next;
    }


    private ListNode findMiddleListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //    归并排序（从底至顶直接合并）
//    链接：https://leetcode.cn/problems/sort-list/solutions/1713438/by-nuo-nuo-zi-4-xrok/
    public ListNode sortList2(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        // 获取链表的长度
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        // 循环遍历
        // 外层遍历step 内层处理每step个元素进行一次merge
        for (int step = 1; step < len; step *= 2) {
            ListNode tail = dummy;
            curr = dummy.next;
            while (curr != null) {
                ListNode left = curr;
                ListNode right = cut(left, step);
                curr = cut(right, step);
                tail.next = mergeListNode(left, right);
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return dummy.next;
    }

    // 将链表从from开始切掉前step个元素，返回后一个元素
    public ListNode cut(ListNode from, int step) {
        step--;
        while (from != null && step > 0) {
            from = from.next;
            step--;
        }
        if (from == null) {
            return null;
        } else {
            ListNode next = from.next;
            from.next = null;
            return next;
        }
    }


}
