package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-09-03-14:48
 * @Desc:重排链表
 */
public class _0143_reorderList {
    //    https://www.bilibili.com/video/BV1s8411z7zY/?spm_id_from=333.337.search-card.all.click&vd_source=3c982dc7f220f0f353141673bd417f9b
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode middleNode = findMiddleNode(head);
        ListNode leftNode = head;
        ListNode rightNode = middleNode.next;
        middleNode.next = null;
        rightNode = reverListNode(rightNode);
        mergeList(leftNode, rightNode);


    }

    private void mergeList(ListNode leftNode, ListNode rightNode) {
        ListNode l1;
        ListNode l2;
        while (leftNode != null && rightNode != null) {
            l1 = leftNode.next;
            l2 = rightNode.next;
            leftNode.next = rightNode;
            leftNode = l1;
            rightNode.next = leftNode;
            rightNode = l2;

        }
    }

    private ListNode reverListNode(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

        }
        return pre;
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }



//   线性表
    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }


}
