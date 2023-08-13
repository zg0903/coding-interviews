package zhihu.lianbiao;

import java.util.HashMap;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name zhihu
 * @date 2022-02-28-21:41
 * @Desc: 复杂链表的复制
 * https://www.bilibili.com/video/av95607029?from=search&seid=16889085957967085408&spm_id_from=333.337.0.0
 */
public class CloneLinkedList {
    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    //        方法一 是用hashmap  复制节点和节点信息
    public RandomListNode clooneNde(RandomListNode head) {
        if (head == null) return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
//        复制节点 放进hashmap
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while (head != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }


}

