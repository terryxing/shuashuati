package DynamicProgramming;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/29/17
 * Time  :  5:16 PM
 */
public class MinSubArray {


    public int minSubArray(List<Integer> nums) {
        // write your code here
        if(nums==null){
            return 0;
        }

        int len = nums.size();

        int[] dp = new int[len];

        dp[0]=nums.get(0);

        int sum=0;

        int result;

        for(int i=0; i<len; i++){
            sum+=nums.get(i);

            if(i==0){
                dp[i]=sum;
            }else{
                dp[i] = Math.min(dp[i-1], sum);
            }
            if(sum > 0){
                sum =0;
            }
        }
        return dp[len-1];
    }

}
