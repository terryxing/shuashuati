package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/26/17
 * Time  :  9:48 PM
 */
public class MaxProductSubArray {

    public int maxProduct(int[] nums) {

        if (nums == null) {
            return 0;
        }

        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }

        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < len; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);

            if (result < max) {
                result = max;
            }
        }

        return result;
    }

}
