package LinkedList;

/**
 * Created by xingtianyi on 12/16/17.
 */
public class RemoveNthNodeFromEndofList {

    ListNode removeNthFromEnd(ListNode head, int n) {




        if(head==null){
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        for(int i = 0; i<n; i++){
            p2=p2.next;

            if(p2==null){
                if(i==n-1){
                    return head.next;
                }else{
                    return null;
                }
            }
        }

        while(p2!=null && p2.next!=null){
            p2=p2.next;
            p1=p1.next;
        }

        if(p1==head){
            head = head.next;
        }else{
            p1.next = p1.next.next;

        }

        return head;

    }

}
