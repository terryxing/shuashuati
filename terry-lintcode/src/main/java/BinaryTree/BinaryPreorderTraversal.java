package BinaryTree;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/20/17
 * Time  :  4:42 PM
 */
public class BinaryPreorderTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here

        ArrayList<Integer> result = new ArrayList<Integer>();

        if(root == null){
            return result;
        }

        helper(root, result);

        return result;

    }

    private void helper(TreeNode root, ArrayList<Integer> result){
        if(root == null){
            return;
        }

        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);

    }




}
