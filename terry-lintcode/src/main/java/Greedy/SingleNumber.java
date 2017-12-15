package Greedy;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/14/17
 * Time  :  3:40 PM
 */
public class SingleNumber {


    public int singleNumber(int[] A) {

        if(A==null || A.length==0){
            return 0;
        }

        int result = 0;

        for(int i=0; i< A.length; i++){

            result = result ^ A[i];

        }

        return result;

    }

}
