package Arrays;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  11/28/17
 * Time  :  3:43 PM
 */
public class SubArraySum {
//
//    Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.
//

    public static void main(String[] args) {

        SubArraySum x = new SubArraySum();

        int[] nums = {-3, 1, 2, -3, 4};

        ArrayList<Integer> arrayList = x.subarraySum(nums);

        System.out.print(arrayList);

    }

    public ArrayList<Integer> subarraySum(int[] nums) {

        ArrayList<Integer> result = new ArrayList<Integer>();

        if (nums == null || nums.length == 0) {
            return result;
        }


        int len = nums.length;

        for (int i = 0; i < len; i++) {

            int first = 0;
            int j = i;

            while (j < len) {
                first = first + nums[j];
                if (first == 0) {
                    result.add(i);
                    result.add(j);
                    return result;
                }
                j++;
            }
        }


        return result;
    }

}
