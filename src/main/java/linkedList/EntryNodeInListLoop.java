package linkedList;

import common.ListNode;

/**
 * 23：链表中环的入口结点
 * // 题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
 * // 环的入口结点是结点3。
 * <p>
 * Created by wangcheng on 9/18/2019
 */
public class EntryNodeInListLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode fast = pHead;//快指针每次走两步
        ListNode slow = pHead;//每次走一步
        while (fast != null && fast.next != null)//因为fast每次要走两步，所有需要判断fast的下一个是否为空
        {
            slow = slow.next;
            fast = fast.next.next;
            //判断是否相遇 相遇后让快指针从头开始走，每次都是走一步，第二次相遇的节点就是环的入口
            if (fast.val == slow.val) {
                fast = pHead;
                while (fast.val != slow.val) {
                    fast = fast.next;
                    slow = slow.next;
                }
            }
            if (fast.val == slow.val) {
                return slow;
            }
        }
        return null;//要是没有相遇，此链表没有环返回空
    }
    /*
    这类问题还可以延伸出来求

（1）环的长度、（2）整个链表的长度、（3）两个无环链表第一次相交的公共节点

（1）环的长度，当快慢指针第一次相遇的时候，把该节点保存下来，让慢指针接着走，当再次到达刚才相遇的节点时所走过的步数就是环的长度。

（2）利用第二步求出环以外的长度再加上环的长度，就是整个链表的长度

（3）先分别求出两个链表的长度，让长的链表先走两个链表长度差的步数，再让两个链表一起走，当走到节点值相同的那个节点时，就是相交的第一个公共节点。
     */
}
