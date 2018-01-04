package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/26/17
 * Time  :  7:48 PM
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        // write your code

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += nums[i];

            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }

        }
        return max;
    }


    public int maxSubArray2(int[] nums) {
        // write your code

        if(nums==null){
            return 0;
        }

        int len = nums.length;

        if(len == 0){
            return 0;
        }

        int[] dp = new int[len];
        int sum = 0;
        dp[0]=nums[0];

        if(nums[0]<0){
            sum =0;
        }else{
            sum = nums[0];
        }

        for(int i=1; i<len; i++){
            sum +=nums[i];

            dp[i] = Math.max(dp[i-1], sum);

            if(sum < 0){
                sum =0;
            }

        }

        return dp[len-1];

    }


}
