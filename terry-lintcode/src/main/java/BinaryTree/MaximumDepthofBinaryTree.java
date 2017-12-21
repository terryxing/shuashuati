package BinaryTree;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/20/17
 * Time  :  3:59 PM
 */
public class MaximumDepthofBinaryTree {



    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        return maxRecursion(root);

    }

    public int maxRecursion(TreeNode root){

        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        return  Math.max(maxRecursion(root.left), maxRecursion(root.right))+1;

    }

    public static void main(String[] args) {

        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);

        p1.left = p2;
        p1.right = p3;
        p2.left = p4;

        MaximumDepthofBinaryTree x = new MaximumDepthofBinaryTree();
        int result = x.maxDepth(p1);

    }


}
