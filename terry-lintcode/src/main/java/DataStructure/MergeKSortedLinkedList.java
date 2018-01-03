package DataStructure;

import LinkedList.ListNode;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by xingtianyi on 1/3/18.
 */

public class MergeKSortedLinkedList {

    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if(lists==null||lists.size()==0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });

        ListNode head = new ListNode(0);
        ListNode p = head;

        for(ListNode list: lists){
            if(list!=null)
                queue.offer(list);
        }

        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            p.next = n;
            p=p.next;

            if(n.next!=null)
                queue.offer(n.next);
        }

        return head.next;

    }
}
