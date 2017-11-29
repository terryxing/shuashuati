package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by xingtianyi on 11/28/17.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = numbers.length;

        if(numbers==null || numbers.length<3){
            return result;
        }

        Arrays.sort(numbers);

        HashSet<List<Integer>> hashset = new HashSet<List<Integer>>();

        for (int i = 0; i < len - 2; i++) {

            int first = numbers[i];

            int p1 = i + 1;
            int p2 = len - 1;

            while (p1 < p2) {

                int sum = first + numbers[p1] + numbers[p2];


                if (sum == 0) {

                    List<Integer> currList = new ArrayList<Integer>();
                    currList.add(first);
                    currList.add(numbers[p1]);
                    currList.add(numbers[p2]);

                    if(!hashset.contains(currList)){
                        result.add(currList);
                        hashset.add(currList);
                    }
                }

                if (sum < 0) {
                    p1++;
                } else{
                    p2--;
                }
            }

        }

        return result;



    }

    public static void main(String[] args) {

        ThreeSum x = new ThreeSum();

        int[] nums = {-1, 0, 1, 2, -1, -4};

//        ArrayList<ArrayList<Integer>> result = x.threeSum(nums);

    }
    }
