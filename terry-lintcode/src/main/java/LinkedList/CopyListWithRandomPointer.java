package LinkedList;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/18/17
 * Time  :  1:35 PM
 */
public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {

        if(head==null){
            return head;
        }

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode currNode = head;

        RandomListNode prev = null;
        RandomListNode newH = null;

        while(currNode!=null){

            int currVal = currNode.label;

            RandomListNode newCurr = new RandomListNode(currVal);

            if(currNode.random!=null){
                RandomListNode randomNext = new RandomListNode(currNode.random.label);
                newCurr.random = randomNext;
                map.put(randomNext, newCurr);
            }

            if (newH==null){
                newH = newCurr;
            }

            if(prev == null){
                prev = newCurr;
            }else{
                prev.next = newCurr;
                prev = prev.next;
            }

            currNode = currNode.next;

        }

        prev.next = null;

        RandomListNode p = newH;

        while(p!=null){

            if(map.containsKey(p)){
                map.get(p).random = p;
            }

            p=p.next;
        }

        return newH;

    }


    public static void main(String[] args) {

        RandomListNode p1 = new RandomListNode(-1);
        p1.next = null;
        p1.random = null;

        CopyListWithRandomPointer x = new CopyListWithRandomPointer();

        RandomListNode result = x.copyRandomList(p1);

    }

}