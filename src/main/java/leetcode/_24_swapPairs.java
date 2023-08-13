package leetcode;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name leetcode
 * @date 2022-11-15-22:22
 * @Desc:给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * https://lyl0724.github.io/2020/01/25/1/
 */
public class _24_swapPairs {

    public ListNode swapPairs(ListNode head) {
   /*
        递归法:
        宗旨就是紧紧抓住原来的函数究竟返回的是什么?作用是什么即可
        其余的细枝末节不要细究,编译器会帮我们自动完成
         */
        // base case
        if (head == null || head.next == null) return head;

        // swapPairs(ListNode head) 的意义就是两两翻转链表中的节点+返回翻转后的新的头结点
        // 我们知道翻转后新的头结点必然是第二个节点
        // 举例子:1->2->3->4 翻转后:2->1->4->3
        ListNode newHead = head.next; // 2
        // 此时tmpHead为:4->3
        ListNode tmpHead = swapPairs(newHead.next);
        // 而前面的还粘连着:1->2->(3)  4->3
        // 此时再让1->4 此时链表为:2->(3) 1->4->3
        head.next = tmpHead;
        // 再将2指向1即可 此时链表为:2->1->4->3 已经完成翻转
        newHead.next = head;
        // 返回新的头结点
        return newHead;
    }




    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
            System.out.println("下" + listNode.val);
        }

        System.out.println("===========" + listNode.val);
        ListNode copy = listNode;
        System.out.println(copy.val);
        while (copy.next != null) {
            System.out.println(copy.val);
            copy = copy.next;
            System.out.println("下" + copy.val);
        }


    }
}
