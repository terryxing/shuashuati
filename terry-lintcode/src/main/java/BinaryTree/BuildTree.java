package BinaryTree;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/21/17
 * Time  :  10:07 PM
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here

        int preStart = 0;
        int preEnd = preorder.length-1;

        int inStart = 0;
        int inEnd = inorder.length-1;

        return helper(preorder, preStart, preEnd, inorder, inStart, inEnd);

    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if(preStart > preEnd || inStart > inEnd){
            return null;
        }


        if(preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }

        int currVal = preorder[preStart];
        TreeNode currNode = new TreeNode(currVal);

        int i = inStart;
        int mid = 0;
        while(i <= inEnd){
            if(inorder[i] == currVal){
                mid = i;
                break;
            }
            i++;
        }

        currNode.left = helper(preorder, preStart+1, preStart+1+mid-inStart-1, inorder, inStart, mid-1);

        currNode.right = helper(preorder, preStart+1+mid-inStart, preEnd, inorder, mid+1, inEnd);

        return currNode;

    }
}
