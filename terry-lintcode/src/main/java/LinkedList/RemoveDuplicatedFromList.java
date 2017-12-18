package LinkedList;

/**
 * Created by xingtianyi on 12/16/17.
 */
public class RemoveDuplicatedFromList {
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here


        if(head==null ){
            return null;
        }

        if(head.next == null){
            return head;
        }

        int preVal = head.val;
        ListNode tail = head;
        ListNode currNode = head;

        while(currNode.next!=null){
            if(currNode.next.val!=preVal){
                tail.next=currNode.next;
                tail=tail.next;
                preVal=tail.val;
            }
            currNode=currNode.next;
        }

        tail.next=null;

        return head;



    }
}
