package zhihu.lianbiao;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name zhihu
 * @date 2022-02-27-15:18
 * @Desc:
 */
public class DeleteNode {
    private Node first;

    public void deleteNode_2(Node toBeDel) {
//        常规方法，从first开始找到要删除结点的前一个结点，时间复杂度为O(n)
        if (first == null || toBeDel == null) {
            return;
        }
        // 要删除的就是链表头，它没有前一个结点
        if (first == toBeDel) {
            first = first.next;
        } else {
            Node cur = first;
            // 找到被删除结点的前一个结点
            while (cur != null && cur.next != toBeDel) {
                cur = cur.next;
            }
            if (cur != null) {
                // cur为toBeDel的前一个结点
                cur.next = cur.next.next;
            }
        }
    }


    public void deleteNode(Node toBeDel) {
        if (toBeDel.next == null) {
            return;
        }
        toBeDel.val = toBeDel.next.val;
        toBeDel.next = toBeDel.next.next;
    }


    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 建立一个头结点代替原来的pHead
        ListNode first = new ListNode(pHead.val - 1);
        first.next = pHead;
        // 当前结点的前一个结点
        ListNode pre = first;
        // 当前结点
        ListNode cur = pHead;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                int val = cur.val;
                while (cur != null && (cur.val == val)) {
                    cur = cur.next;
                }
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        // 这里不能返回pHead，因为pHead也可能被删除了
        return first.next;
    }


}


class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
