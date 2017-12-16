package Greedy;

/**
 * Created by xingtianyi on 12/16/17.
 */
public class JumpGame {

    public boolean canJump(int[] A) {

        int len = A.length;

        if(len <= 1){
            return true;
        }

        int max = A[0];

        for(int i=0; i<len; i++){
            int currMax = A[i]+i;
            if(currMax > max){
                max = currMax;
            }

            if(max <= i && A[i] == 0){
                return false;
            }

            if(max >= len-1){
                return true;
            }

        }

        return true;


    }

    public static void main(String[] args) {

    }

}
