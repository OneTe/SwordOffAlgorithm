package Problem3;

import common.ListNode;

import java.util.ArrayList;



/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 *
 * Created by wangcheng  on 2018/4/19.
 */
public class PrintListNode {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> printValue(ListNode listNode){
        if(listNode != null){
            this.printValue(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
