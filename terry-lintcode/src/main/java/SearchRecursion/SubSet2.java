package SearchRecursion;

import java.util.*;

/**
 * Created by xingtianyi on 12/25/17.
 */
public class SubSet2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> levelResult = new ArrayList<Integer>();
        result.add(levelResult);

        Arrays.sort(nums);
        int len = nums.length;

        if (nums == null || len < 1) {
            return result;
        }

        Set<List<Integer>> set = new HashSet<List<Integer>>();

        helper(0, nums, len, levelResult, result, set);

        return result;

    }


    private void helper(int index, int[] nums, int len, ArrayList<Integer> levelResult, List<List<Integer>> result, Set<List<Integer>> set) {

        if (index >= len) {
            return;
        }

        for (int i = index; i < len; i++) {
            levelResult.add(nums[i]);
            if (!set.contains(levelResult)) {
                set.add(levelResult);
                result.add(new ArrayList<Integer>(levelResult));
                helper(i + 1, nums, len, levelResult, result, set);
            }

            levelResult.remove(levelResult.size() - 1);
        }
    }
}
