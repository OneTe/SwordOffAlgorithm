package common;

/**
 * Created by wangcheng  on 2018/5/10.
 */
public class ListNode{
   public int val;
   public ListNode next = null;
   public ListNode(int val){
        this.val = val;
    }
    public static ListNode createLinkedList(int arr[], int n){
        if(n == 0){
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode curNode = head;
        for(int i = 1; i < n; i ++){
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode head){
        ListNode curNode = head;
        while (curNode != null){
            System.out.print(curNode.val + " -> ");
            curNode = curNode.next;
        }
        System.out.print("NULL");
        System.out.println();
    }
}
