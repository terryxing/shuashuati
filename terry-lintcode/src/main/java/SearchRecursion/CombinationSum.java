package SearchRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xingtianyi on 12/25/17.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(candidates.length == 0){
            return result;
        }

        int len = candidates.length;

        List<Integer> levelResult = new ArrayList<Integer>();

        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet<List<Integer>>();

        helper(0, 0, target, candidates, levelResult, result, set, len);

        return result;

    }


    private void helper(int index, int sum, int target, int[] candidates, List<Integer> levelResult, List<List<Integer>> result, Set<List<Integer>> set, int len){

        if(sum > target){
            return;
        }

        if(sum == target){
            if(!set.contains(levelResult)){
                result.add(new ArrayList<Integer>(levelResult));
                set.add(levelResult);
            }
            return;
        }

        for(int i=index; i<len; i++){
            sum += candidates[i];
            levelResult.add(candidates[i]);
            helper(i, sum, target, candidates, levelResult, result, set, len);
            sum = sum-candidates[i];
            levelResult.remove(levelResult.size()-1);
        }
    }

    public static void main(String[] args) {

        int[] candidates = {2,2,4};

        CombinationSum x= new CombinationSum();

        List<List<Integer>> result = x.combinationSum(candidates, 4);

        System.out.print("ge");

    }
}
