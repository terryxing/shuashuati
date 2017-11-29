package Arrays;

import java.util.HashSet;

/**
 * Created by xingtianyi on 11/28/17.
 */
public class FirstMissingPositive {

    //Given an unsorted integer array, find the first missing positive integer.

    public int firstMissingPositive(int[] A) {

        if(A==null || A.length==0){
            return 1;
        }


        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        HashSet<Integer> set = new HashSet<Integer>();

        for(int i=0;i<A.length; i++){

            set.add(A[i]);

            if(A[i]< min){
                min = A[i];
            }
            if(A[i]> max){
                max = A[i];
            }
        }

        if(max<=0){
            return 1;
        }

        if(min >1){
            return min-1;
        }

        for(int i=1; i<=A.length; i++){
            if(!set.contains(i)){
                return i;
            }
        }

        return A.length+1;


    }

    public static void main(String[] args) {

    }


}
