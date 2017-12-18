package LinkedList;

/**
 * Created by xingtianyi on 12/16/17.
 */
public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here

        if(l1==null && l2==null){
            return null;
        }else if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;

        while(l1!=null && l2!=null){

            if(l1.val < l2.val){
                tail.next = l1;
                tail=tail.next;
                l1=l1.next;
            }else{
                tail.next = l2;
                tail=tail.next;
                l2=l2.next;
            }
        }

        if(l1!=null){
            tail.next = l1;
        }

        if(l2!=null){
            tail.next=l2;
        }

        return head.next;

    }
}
