package SearchRecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingtianyi on 12/25/17.
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        // write your code here

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (k > n) {
            return result;
        }

        List<Integer> levelResult = new ArrayList<Integer>();

        helper(1, n, k, result, levelResult, 0);

        return result;

    }

    private void helper(int i, int n, int k, List<List<Integer>> result, List<Integer> levelResult, int count) {

        if (count == k) {
            result.add(new ArrayList<Integer>(levelResult));
            return;
        }

        for (int x = i; x <= n; x++) {
            levelResult.add(x);
            count++;
            helper(x + 1, n, k, result, levelResult, count);
            levelResult.remove(levelResult.size() - 1);
            count--;
        }
    }

}
