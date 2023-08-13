package zhihu.lianbiao;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name zhihu
 * @date 2022-02-27-12:23
 * @Desc:
 */
public class FromTail2Head {

     static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (ListNode node = listNode; node != null; node = node.next) {
            stack.push(node.val);
        }
        return new ArrayList<>(stack);
    }

    public static void main(String[] args) {
        FromTail2Head fromTail2Head = new FromTail2Head();
        ListNode ListNode1 = new ListNode(1);
        ListNode ListNode2 = new ListNode(2);
        ListNode ListNode3 = new ListNode(3);
        ListNode ListNode4 = new ListNode(4);
        ListNode ListNode5 = new ListNode(5);
        ListNode1.next=ListNode2;
        ListNode2.next=ListNode3;
        ListNode3.next=ListNode4;
        ListNode4.next=ListNode5;
        ArrayList<Integer> integers = fromTail2Head.printListFromTailToHead(ListNode1);
        System.out.println(integers);


    }


}
