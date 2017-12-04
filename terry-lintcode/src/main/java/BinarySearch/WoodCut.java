package BinarySearch;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/1/17
 * Time  :  4:13 PM
 */
public class WoodCut {

    public int woodCut(int[] L, int k) {

        if(L==null){
            return 0;
        }

        int len = L.length;

        if(len < 1){
            return 0;
        }

        Arrays.sort(L);

         long last = L[len-1];

        int result = 0;
        long singleVal = 0;

        long left =1;
        long right = last;


        while(left <= right){

            long midVal = (left+right)/2;
            int currSum = 0;

            for(int i=0; i< len; i++){
                currSum += (int)(L[i]/midVal);
            }

            if(currSum >=k && midVal > singleVal){
                singleVal = midVal;
                left = midVal+1;
            }else{
                right = midVal-1;
            }
        }

        return (int)singleVal;

    }

    public static void main(String[] args) {


        int[] L = {232,124,456};
        int k = 7;

        WoodCut x = new WoodCut();
        int result = x.woodCut(L, k);

        System.out.print(result);



    }

}
