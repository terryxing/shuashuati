package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xingtianyi on 12/25/17.
 */
public class BSTSerialization {


    public static void main(String[] args) {

        String str = "{1,2,#,3,#,#,#,4}";

        BSTSerialization x = new BSTSerialization();

        TreeNode result = x.deserialize(str);
        System.out.print(result.val);

    }

    public  String serialize(TreeNode root) {
        // write your code here
        if(root == null){
            return null;
        }

        String str = new String();
        str = str + "{";

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);

        str = str  + Integer.toString(root.val);
        str = str + ",";

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0; i<size; i++){

                TreeNode currNode = q.poll();

                if(currNode.left != null){
                    q.add(currNode.left);
                    str= str + Integer.toString(currNode.left.val);
                    str = str + ",";

                }else{
                    str = str + "#";
                    str = str + ",";

                }

                if(currNode.right != null){
                    q.add(currNode.right);
                    str = str + Integer.toString(currNode.right.val);
                    str = str + ",";

                }else{
                    str = str + "#";
                    str = str + ",";

                }
            }
        }

        str = str.substring(0, str.length()-1);
        str = str + "}";

        return str;

    }



    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here

        if(data==null || data.length()<3){
            return null;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        int len = data.length();
        data = data.substring(1, len-1);

        String[] dataArray=data.split(",");

        len = dataArray.length;

        TreeNode parentNode = null;
        TreeNode root = parentNode;
        int i=1;
        int j=0;

        q.add(constructNode(dataArray[0]));

        while(i<len && j<len){

            parentNode = q.poll();

            if(root == null){
                root = parentNode;
            }

            if(parentNode != null){
                if(i<len){
                    parentNode.left = constructNode(dataArray[i]);
                    q.add(parentNode.left);
                }
                if(i+1<len){
                    parentNode.right = constructNode(dataArray[i+1]);
                    q.add(parentNode.right);
                }
            }
            i+=2;
            j+=1;
        }

        return root;
    }

    private TreeNode constructNode(String str){
        if(str == null || str.length() == 0){
            return null;
        }else{
            if(str.equals("#")){
                return null;
            }else{
                return new TreeNode(Integer.parseInt(str));
            }
        }

    }
}
