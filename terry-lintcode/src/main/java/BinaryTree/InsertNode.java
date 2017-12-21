package BinaryTree;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/20/17
 * Time  :  5:39 PM
 */
public class InsertNode {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null){
            return node;
        }

        helper(root, node);

        return root;
    }

    public void helper(TreeNode root, TreeNode node){

        if(root==null){
            return;
        }

        if(root.right == null && node.val > root.val){
            root.right = node;
            return;
        }

        if(root.left == null && node.val < root.val){
            root.left = node;
            return;
        }

        if(node.val >= root.val){
            helper(root.right, node);
        }else{
            helper(root.left, node);
        }

        return;

    }
}
