package LinkedList;

import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/19/17
 * Time  :  10:23 PM
 */
public class HasCircle {
    public boolean hasCycle(ListNode head) {
        // write your code here

        if(head==null || head.next == null){
            return false;
        }

        HashSet<ListNode> set = new HashSet<ListNode>();

        while(head!=null){
            if(!set.contains(head)){
                set.add(head);
                head= head.next;
            }else{
                return true;
            }
        }

        return false;

    }
}
