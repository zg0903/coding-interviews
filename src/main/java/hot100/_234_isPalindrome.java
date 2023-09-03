package hot100;

import java.util.ArrayList;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-31-22:54
 * @Desc:回文链表
 */
public class _234_isPalindrome {


    //利用数组 + 双指针
//    利用数组，将链表元素依次存入。
//    然后再使用两个指针，一个指向数组开始位置，一个指向数组结束位置。
//    依次判断首尾对应元素是否相等，如果都相等，则为回文链表。如果不相等，则不是回文链表。
    public boolean isPalindrome1(ListNode head) {
        if (head == null) {
            return false;
        }
        ArrayList<Integer> ints = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            ints.add(cur.val);
            cur = cur.next;

        }
        int m = 0;
        int n = ints.size() - 1;
        while (m < n) {
            if (ints.get(m) != ints.get(n)) {
                return false;
            }
            m++;
            n--;
        }
        return true;
    }


//1.先使用快慢指针的方式查找到链表的中间节点 2.反转链表中间节点后面的所有节点 例:[1,2,3,3,2,1]
// 反转完:[1,2,3,1,2,3] 3.两个指针一个指向链表的第一个一个指向链表的中间节点，依次往后去比较，如果期间不相同直接返回false
    public boolean isPalindrome2(ListNode head) {
        ListNode left=head;
        ListNode right=head;
        while(right!=null&&right.next!=null){
            right=right.next.next;
            left=left.next;
        }
        if(right!=null){
            left=left.next;
        }
        left=reversal(left);
        right=head;
        while(left!=null){
            if(left.val!=right.val)
                return false;
            right=right.next;
            left=left.next;
        }
        return true;
    }
    public ListNode reversal(ListNode head){
        ListNode temp=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=temp;
            temp=head;
            head=next;
        }
        return temp;
    }


}
