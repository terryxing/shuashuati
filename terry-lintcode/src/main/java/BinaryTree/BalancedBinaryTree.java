package BinaryTree;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/20/17
 * Time  :  4:16 PM
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        return maxDepthDiff(root)!=-1;

    }

    public int maxDepthDiff(TreeNode root){

        if(root == null){
            return 0;
        }


        int left = maxDepthDiff(root.left);
        int right = maxDepthDiff(root.right);

        if(left == -1 || right == -1 || Math.abs(left-right)>1){
            return -1;
        }

        return Math.max(left, right)+1;


    }




    }
