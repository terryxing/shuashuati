package SearchRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xingtianyi on 12/25/17.
 */
public class SubSet {

    public List<List<Integer>> subsets(int[] nums) {
        // write your code here

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> levelResult = new ArrayList<Integer>();
        result.add(levelResult);

        Arrays.sort(nums);
        int len = nums.length;

        if (nums == null || len < 1) {
            return result;
        }

        helper(0, nums, len, levelResult, result);

        return result;

    }


    private void helper(int index, int[] nums, int len, ArrayList<Integer> levelResult, List<List<Integer>> result) {

        if (index >= len) {
            return;
        }

        for (int i = index; i < len; i++) {
            levelResult.add(nums[i]);
            result.add(new ArrayList<Integer>(levelResult));
            helper(i + 1, nums, len, levelResult, result);
            levelResult.remove(levelResult.size() - 1);
        }
    }
}
