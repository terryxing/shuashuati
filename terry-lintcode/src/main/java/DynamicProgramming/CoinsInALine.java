package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/27/17
 * Time  :  9:34 PM
 */
public class CoinsInALine {

    public boolean firstWillWin(int n) {
        // write your code here

        if(n==0){
            return false;
        }

        if(n==1){
            return true;
        }

        if(n==2){
            return true;
        }

        if(n==3){
            return false;
        }


        boolean first = true;
        boolean second = false;

        for(int i=4; i<=n; i++){
            boolean third = !(first&&second);
            first=second;
            second=third;
        }

        return second;

    }

}
