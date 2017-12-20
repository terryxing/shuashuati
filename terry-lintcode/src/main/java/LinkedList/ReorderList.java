package LinkedList;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/20/17
 * Time  :  10:47 AM
 */
public class ReorderList {

    public void reorderList(ListNode head) {


        if(head == null || head.next == null){
            return;
        }

        Stack<ListNode> st = new Stack<ListNode>();

        ListNode p = head;
        int count = 0;

        while(p!=null) {
            st.push(p);
            p=p.next;
            count++;
        }


        ListNode curr = head;

        int i=0;
        int mid = count/2;

        ListNode newHead = null;
        ListNode tail = null;

        //只需要走前一半儿，因为后一半儿可以从stack里面获取。
        //如果头指针为null说明第一个，设置头指针
        //设置尾指针同时
        //
       while(i<mid){

           if(newHead == null){
               newHead = curr;
               tail = curr;
               curr = curr.next;
           }else{
               tail.next = curr;
               tail=tail.next;
               curr =curr.next;
           }

           tail.next =st.pop();
            tail = tail.next;
           i++;
       }

        if(count%2==1){
            tail.next = st.pop();
            tail=tail.next;
        }
        tail.next = null;


        return;

    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(-1);
       // ListNode p3 = new ListNode(0);

        p1.next = p2;
        //p2.next = p3;

        ReorderList x = new ReorderList();

        x.reorderList(p1);


    }

}
