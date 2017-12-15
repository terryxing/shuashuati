package Greedy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/14/17
 * Time  :  3:41 PM
 */
public class MajorityNumber {

    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if(nums == null){
            return -1;
        }

        int len = nums.size();

        Collections.sort(nums);

        int mid = len/2;

        return nums.get(mid);


    }
}
