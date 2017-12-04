package MatchAndBits;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/4/17
 * Time  :  3:19 PM
 */
public class checkPowerOfTwo {

    public boolean checkPowerOf2(int n) {
        // write your code here

        if(n<1){
            return false;
        }else{
            return (n&(n-1))==0;
        }





    }

    public static void main(String[] args) {


    }

}
