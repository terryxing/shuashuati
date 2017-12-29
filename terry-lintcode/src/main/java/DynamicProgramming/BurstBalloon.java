package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/28/17
 * Time  :  9:31 PM
 */
public class BurstBalloon {

    public int maxCoins(int[] nums) {
        // write your code here

        if(nums == null || nums.length == 0){
            return 0;
        }

        int len = nums.length;

        if(len==1){
            return nums[0];
        }

        int[][] dp = new int[len][len];

        search(nums,0, len-1, dp);

        return dp[0][len-1];

    }

    public int search(int[] nums, int i, int j, int[][] dp){

        if(i>j){
            return 0;
        }

        if(dp[i][j]>0){
            return dp[i][j];
        }

        if(i==j){
            dp[i][j]=cost(i, nums, i, j);
            return dp[i][j];
        }

        for(int k=i; k<=j; k++){
            dp[i][j] = Math.max(dp[i][j], search(nums, i, k-1, dp) + search(nums, k+1, j, dp) + cost(k, nums, i, j));
        }
        return dp[i][j];
    }

    private int cost(int k, int[] nums, int i, int j){
        int len = nums.length;

        int left=1;
        int right = 1;

        if(i-1>=0){
            left = nums[i-1];
        }
        if(j+1<=nums.length-1){
            right = nums[j+1];
        }
        return nums[k]*left*right;

    }
}
