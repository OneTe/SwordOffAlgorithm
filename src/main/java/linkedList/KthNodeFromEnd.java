package linkedList;

import common.ListNode;

/**
 * 22：链表中倒数第k个结点
 * // 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
 * // 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
 * // 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
 * // 值为4的结点。
 * Created by wangcheng on 9/18/2019
 */
public class KthNodeFromEnd {

    //假设k取值是1-链表的长度之间
    public ListNode FindKthToTail(ListNode head, int k){
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < k ; i ++){
            q = q.next;
        }
        while (q != null){
            p = p.next;
            q = q.next;
        }

        return p;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = arr.length;
        ListNode l1 = ListNode.createLinkedList(arr, k);
        ListNode.printLinkedList(l1);
        KthNodeFromEnd kthNodeFromEnd = new KthNodeFromEnd();
        ListNode n = kthNodeFromEnd.FindKthToTail(l1, 5);
        ListNode.printLinkedList(n);
    }
}
