package LinkedList;

/**
 * Created by xingtianyi on 12/17/17.
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        if(head==null){
            return null;
        }

        if(head.next ==null){
            return head;
        }

        ListNode l1Head=null;
        ListNode l2Head=null;
        ListNode l1Tail=null;
        ListNode l2Tail=null;
        ListNode currNode = head;


        while(currNode!=null){

            if(currNode.val < x){
                if(l1Tail==null){
                    l1Head=currNode;
                    l1Tail=currNode;
                }else{
                    l1Tail.next=currNode;
                    l1Tail = l1Tail.next;
                    // if(currNode.next == null){
                    //     l1Tail.next = null;
                    // }
                }
            }else{
                if(l2Tail==null){
                    l2Head=currNode;
                    l2Tail=currNode;
                }else{
                    l2Tail.next=currNode;
                    l2Tail = l2Tail.next;
                    // if(currNode.next == null){
                    //     l2Tail.next = null;
                    // }
                }
            }
            currNode = currNode.next;
        }



        if(l1Head == null){
            if(l2Tail!=null){
                l2Tail.next = null;
            }            return l2Head;
        }else{
            l1Tail.next = l2Head;
            if(l2Tail!=null){
                l2Tail.next = null;
            }
            return l1Head;
        }


    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = null;

        PartitionList x = new PartitionList();
        ListNode result = x.partition(l1,3);

        System.out.print(result.val);
    }


    }
