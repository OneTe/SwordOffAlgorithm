package Problem16;

import common.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * Created by wangcheng  on 2018/5/11.
 */
/*
    合并过程：
    ---------------------
    | [1]->[3]->[5]->[7] |
    | [2]->[4]->[6]->[8] |
    ---------------------

         ----------------------
         | [3]->[5]->[7]      |
    [1]->|                    |
         | [2]->[4]->[6]->[8] |
         ----------------------

              ----------------------
              | [3]->[5]->[7]      |
    [1]->[2]->|                    |
              | [4]->[6]->[8]      |
              ----------------------
 */
public class Merge {
    public ListNode merge(ListNode list1,ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode res = null;
        if(list1.val < list2.val){
            res = list1;
            res.next = merge(list1.next,list2);
        }else {
            res = list2;
            res.next = merge(list1,list2.next);
        }
        return res;
        /*
        或者：
        if(list1.val <= list2.val){
           list1.next = Merge(list1.next, list2);
           return list1;
        }else{
           list2.next = Merge(list1, list2.next);
           return list2;
       }
         */
    }
}






