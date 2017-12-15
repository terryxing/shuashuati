package MatchAndBits;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/4/17
 * Time  :  4:58 PM
 */
public class UniqueBinarySearchTree {

    public int numTrees(int n) {

        if(n==0 || n==1){
            return 1;
        }

        int[] result = new int[n+1];

        result[0]=1;
        result[1]=1;

        for(int i=2; i<n+1; i++){
            for(int j=0; j<i; j++){
                result[i] = result[i] + result[j] * result[i-j-1];
            }
        }

        return result[n];

    }


}
