package LinkedList;

/**
 * Created by xingtianyi on 12/17/17.
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode first = head;
        ListNode last = null;

        ListNode prev = head;
        ListNode currNode = head;
        int len=0;

        while(currNode!=null){
            len++;
            currNode = currNode.next;
        }

        k=k%len;

        if(k==len || k==0){
            return head;
        }

        int i=0;
        ListNode currNode2 = head;
        while(currNode2!=null){
            i++;
            if(i==len-k){
                prev=currNode2;
            }

            if(currNode2.next == null){
                last = currNode2;
            }
            currNode2 = currNode2.next;
        }

        ListNode newHead = prev.next;

        last.next = first;
        prev.next = null;

        return newHead;


    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next =  null;

        RotateList x = new RotateList();
        ListNode result = x.rotateRight(l1,1);

    }



    }
