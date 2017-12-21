package BinaryTree;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/20/17
 * Time  :  4:51 PM
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<ArrayList<TreeNode>> resultTree = new ArrayList<ArrayList<TreeNode>>();


        if (root == null) {
            return result;
        }

        ArrayList<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        resultTree.add(level);

        while (level.size() != 0) {

            ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();

            for (TreeNode currNode : level) {
                if (currNode.left != null) {
                    nextLevel.add(currNode.left);
                }
                if (currNode.right != null) {
                    nextLevel.add(currNode.right);
                }
            }

            if (nextLevel.size() != 0) {
                resultTree.add(nextLevel);
            }

            level = nextLevel;
        }

        for (ArrayList<TreeNode> currLevel : resultTree) {

            ArrayList<Integer> currLevelInt = new ArrayList<Integer>();

            for (TreeNode currNode : currLevel) {
                currLevelInt.add(currNode.val);
            }
            result.add(currLevelInt);
        }

        return result;
    }


    public static void main(String[] args) {

    }

}
