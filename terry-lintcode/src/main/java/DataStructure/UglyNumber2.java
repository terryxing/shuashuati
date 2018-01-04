package DataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  1/3/18
 * Time  :  10:46 PM
 */
public class UglyNumber2 {

    public int nthUglyNumber(int o) {
        // write your code here

        List<Integer> list = new ArrayList<Integer>();

        list.add(1);

        int i=0;
        int j=0;
        int l=0;

        int min = Integer.MAX_VALUE;

        for(int x=0; x<o; x++){
            int m =list.get(i)*2;
            int n =list.get(j)*3;
            int k =list.get(l)*5;

            min = Math.min(Math.min(m,n), k);
            list.add(min);

            if(min == m){
                i++;
            }

            if(min == n){
                j++;
            }
            if(min == k){
                l++;
            }
        }

        return list.get(list.size()-2);


    }
}
