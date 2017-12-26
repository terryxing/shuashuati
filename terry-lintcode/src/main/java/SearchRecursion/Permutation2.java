package SearchRecursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xingtianyi on 12/25/17.
 */
public class Permutation2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> levelResult = new ArrayList<Integer>();

        if(nums==null && nums.length==0){
            return result;
        }

        int len = nums.length;
        Set<Integer> set = new HashSet<Integer>();
        Set<List<Integer>> setList = new HashSet<List<Integer>>();

        helper(nums, len, levelResult, result, set, setList);

        return result;

    }

    private void helper(int[] nums, int len, List<Integer> levelResult, List<List<Integer>> result, Set<Integer> set, Set<List<Integer>> setList){

        if(levelResult.size() == len){

            if(setList.contains(levelResult)){
                return;
            }

            result.add(new ArrayList<Integer>(levelResult));
            setList.add(levelResult);
            return;
        }

        for(int i=0; i<len; i++){
            if(set.contains(i)){
                continue;
            }
            levelResult.add(nums[i]);
            set.add(i);
            helper(nums, len, levelResult, result, set, setList);
            levelResult.remove(levelResult.size()-1);
            set.remove(i);
        }
    }


}
