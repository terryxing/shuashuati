package DynamicProgramming;

/**
 * Created by xingtianyi on 12/26/17.
 */
public class ClimbStair {

    public int climbStairs(int n) {

        if (n == 1 || n == 2) {
            return n;
        }

        int[] x = new int[n];

        x[0] = 1;
        x[1] = 2;
        for (int i = 2; i < n; i++) {
            x[i] = x[i - 1] + x[i - 2];
        }

        return x[n - 1];
    }
}
