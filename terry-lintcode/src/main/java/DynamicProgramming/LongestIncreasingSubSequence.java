package DynamicProgramming;

/**
 * Created by xingtianyi on 1/1/18.
 */
public class LongestIncreasingSubSequence {

    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here

        if(nums == null){
            return 0;
        }

        int len = nums.length;

        if(len == 0){
            return 0;
        }

        int[] dp = new int[len];
        dp[0]=1;
        int max = 0;
        for(int i=1;i<len; i++){
            int maxValue = 0;
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    maxValue = Math.max(maxValue, dp[j]);
                }
            }
            dp[i] = maxValue +1;
            max = Math.max(max, dp[i]);

        }

        return max;

    }
}
