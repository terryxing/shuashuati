package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/27/17
 * Time  :  8:23 PM
 */
public class LongestIncreasingContinuousSubarray {

    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here

        if(A==null){
            return 0;
        }

        int len = A.length;
        if(len == 0 || len ==1){
            return len;
        }

        int result = 0;

        int count1 = 1;
        int count2 = 1;
        int prev1 = A[0];
        int prev2 = A[0];
        for(int i=1; i<len; i++){
            if(prev1 > A[i]){
                count1++;
                if(count1 > result){
                    result=count1;
                }
            }else{
                count1=1;
            }
            prev1=A[i];


            if(prev2<A[i]){
                count2++;
                if(count2>result){
                    result=count2;
                }
            }else{
                count2=1;
            }
            prev2=A[i];
        }

        return result;

    }



    //2d search dp+dfs
    public int[] xMove = { 1, 0, 0, -1 };
    public int[] yMove = { 0, 1, -1, 0 };

    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if (A == null || A.length == 0)
            return 0;
        int[][] dp = new int[A.length][A[0].length];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (max < findMaxPath(A, i, j, dp)) {
                    max = findMaxPath(A, i, j, dp);
                }
            }
        }
        return max + 1;
    }

    private int findMaxPath(int[][] A, int x, int y, int[][] dp) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        //go through around x,y
        for (int i = 0; i < 4; i++) {
            //check if in bound
            if (check(A, x + xMove[i], y + yMove[i])) {
                //
                if (A[x + xMove[i]][y + yMove[i]] < A[x][y]) {
                    if (dp[x][y] < findMaxPath(A, x + xMove[i], y + yMove[i], dp) + 1) {
                        dp[x][y] = findMaxPath(A, x + xMove[i], y + yMove[i], dp) + 1;
                    }
                }
            }
        }
        return dp[x][y];
    }

    private boolean check(int[][] A, int x, int y) {
        if (x >= 0 && x < A.length && y >= 0 && y < A[0].length) {
            return true;
        }
        return false;
    }

}
