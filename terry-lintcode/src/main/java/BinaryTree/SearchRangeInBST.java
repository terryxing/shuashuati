package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/21/17
 * Time  :  9:31 PM
 */
public class SearchRangeInBST {

    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here

        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }

        helper(root, k1, k2, result);

        Collections.sort(result);

        return result;


    }

    public void helper(TreeNode root, int k1, int k2, ArrayList<Integer> result){

        if(root == null){
            return;
        }

        int currVal = root.val;

        if(currVal >=k1 && currVal <=k2){
            result.add(currVal);
        }

        if(currVal < k1){
            helper(root.right, k1, k2, result);
        }else if(currVal >k2){
            helper(root.left, k1, k2, result);
        }else{
            helper(root.left, k1,k2,result);
            helper(root.right, k1, k2, result);
        }



    }
}
