package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/27/17
 * Time  :  11:12 AM
 */
public class RobHouse2 {

    public int houseRobber2(int[] A) {

        if (A == null) {
            return 0;
        }

        int len = A.length;

        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return A[0];
        }

        int[] max = new int[len];
        int[] max2 = new int[len];
        max[0] = A[0];
        max[1] = Math.max(A[1], max[0]);
        max2[1] = A[1];
        max2[2] = Math.max(A[2], max2[1]);


        for (int i = 2; i < len; i++) {
            max[i] = Math.max(A[i] + max[i - 2], max[i - 1]);
        }

        if (max[len - 1] == max[len - 2]) {
            return max[len - 1];
        }

        for (int i = 3; i < len; i++) {
            max2[i] = Math.max(A[i] + max2[i - 2], max2[i - 1]);
        }

        return Math.max(max[len - 2], max2[len - 1]);

    }
}
