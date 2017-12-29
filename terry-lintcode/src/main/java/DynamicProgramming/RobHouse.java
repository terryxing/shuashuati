package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/26/17
 * Time  :  10:31 PM
 */
public class RobHouse {
    public long houseRobber(int[] A) {
        // write your code here
        // write your code here
        if (A == null) {
            return 0;
        }

        int len = A.length;

        if (len == 0) {
            return 0;
        }

        long[] max = new long[len];

        for (int i = 0; i < len; i++) {
            if (i < 2) {
                max[i] = A[i];
            } else {
                max[i] = Math.max(A[i] + max[i - 2], max[i - 1]);
            }

        }

        return max[len - 1];
    }
}
