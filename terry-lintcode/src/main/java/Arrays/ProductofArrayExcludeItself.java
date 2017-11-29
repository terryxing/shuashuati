package Arrays;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  11/28/17
 * Time  :  4:58 PM
 */
public class ProductofArrayExcludeItself {

    public static void main(String[] args) {

    }

    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {

        ArrayList<Long> result = new ArrayList<Long>();

        if (A == null || A.size() == 0) {
            return result;
        }

        int len = A.size();

        for(int i=0; i<len; i++){
            long currResult=1;

            for(int j=0; j<len; j++){
                long currValue = (long) A.get(j);

                if(j==i){
                    continue;
                }
                currResult = currResult* currValue;
            }

            result.add(currResult);
        }

        return result;
    }

}
