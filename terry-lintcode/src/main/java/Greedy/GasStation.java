package Greedy;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/14/17
 * Time  :  5:19 PM
 */
public class GasStation {

    public static void main(String[] args) {

        int[] gas = {1,2,3,3};
        int[] cost = {2,1,5,1};

        GasStation x = new GasStation();

        int result = x.canCompleteCircuit(gas, cost);


    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here

        if(gas == null || cost == null){
            return -1;
        }

        int gasLen = gas.length;
        int costLen = cost.length;

        if(gasLen<2 || costLen<2  || gasLen!=costLen){
            return -1;
        }


        int[] leftOver = new int[gasLen];

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int total = 0;

        for(int i=0; i<gasLen; i++){

            leftOver[i]=gas[i]-cost[i];
            total+=leftOver[i];
            if(leftOver[i] > max){
                max=leftOver[i];
                maxIndex = i;
            }
        }

        for(int i=0; i<gasLen; i++){

            int tempSum = 0;
            boolean finishLoop = true;
            for(int j=i; j<gasLen; j++){
                tempSum += leftOver[j];
                if(tempSum<0){
                    finishLoop = false;
                    break;
                }
            }

            if(tempSum<0){
                continue;
            }

            for(int j=0; j<i; j++){
                tempSum+=leftOver[j];
                if(tempSum<0){
                    finishLoop = false;
                    break;
                }
            }

            if(finishLoop){
                return i;
            }

        }

        if(max>=0 && total>=0){
            return maxIndex;
        }else{
            return -1;
        }


    }

}
