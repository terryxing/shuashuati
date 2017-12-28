package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/27/17
 * Time  :  8:23 PM
 */
public class LongestIncreasingContinuousSubarray {

    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here

        if(A==null){
            return 0;
        }

        int len = A.length;
        if(len == 0 || len ==1){
            return len;
        }

        int result = 0;

        int count1 = 1;
        int count2 = 1;
        int prev1 = A[0];
        int prev2 = A[0];
        for(int i=1; i<len; i++){
            if(prev1 > A[i]){
                count1++;
                if(count1 > result){
                    result=count1;
                }
            }else{
                count1=1;
            }
            prev1=A[i];


            if(prev2<A[i]){
                count2++;
                if(count2>result){
                    result=count2;
                }
            }else{
                count2=1;
            }
            prev2=A[i];
        }

        return result;

    }
}
