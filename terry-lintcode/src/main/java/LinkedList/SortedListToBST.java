package LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/19/17
 * Time  :  9:54 PM
 */
public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        // write your code here

        if(head == null){
            return null;
        }

        int len = 0;

        ListNode p = head;

        while(p!=null){
            len++;
            p=p.next;
        }

        int[] array = new int[len];

        for(int i=0; i<len; i++){
            array[i]=head.val;
            head=head.next;
        }

        TreeNode result = sortedArrayToBST(array, 0, len-1);

        return result;

    }


    public TreeNode sortedArrayToBST(int[] array, int start, int end){


        if(start > end){
            return null;
        }

        if(start == end){
            return new TreeNode(array[start]);
        }

        int mid = (start+end)/2;
        TreeNode midNode = new TreeNode(array[mid]);

        midNode.left = sortedArrayToBST(array, start, mid-1);
        midNode.right = sortedArrayToBST(array, mid+1, end);

        return midNode;
    }


    public static void main(String[] args) {


    }



    }
