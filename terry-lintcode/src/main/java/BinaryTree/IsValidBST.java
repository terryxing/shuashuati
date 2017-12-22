package BinaryTree;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/21/17
 * Time  :  9:29 PM
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        // write your code here

        if(root == null){
            return true;
        }

        return helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);

    }

    public boolean helper(TreeNode root, double min, double max){

        if(root == null){
            return true;
        }

        if(root.val <= min || root.val >= max){
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);


    }


}
