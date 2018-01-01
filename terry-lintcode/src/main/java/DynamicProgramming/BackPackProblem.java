package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/28/17
 * Time  :  6:46 PM
 */
public class BackPackProblem {

    public static void main(String[] args) {

        int[] A = {3, 4, 8, 5};
        int m = 10;
        BackPackProblem x = new BackPackProblem();

        int result = x.backPack(m, A);
        int result2 = x.backPack2(m, A, A);


    }


    public int backPack2(int m, int[] A, int[] V) {
        // write your code here
        if (A == null || V == null) {
            return 0;
        }

        int len = A.length;

        if (len == 0 || m == 0 || V.length == 0) {
            return 0;
        }


        int[][] dp = new int[len + 1][m + 1];

        dp[0][0] = 0;

        for (int i = 1; i <= len; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }


        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - A[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], V[i - 1] + dp[i - 1][j - A[i - 1]]);
                }
            }
        }

        return dp[len][m];

    }


    public int backPack(int m, int[] A) {
        // write your code here

        if (A == null) {
            return 0;
        }

        int len = A.length;

        if (len == 0 || m == 0) {
            return 0;
        }


        int[][] dp = new int[len + 1][m + 1];

        dp[0][0] = 0;

        for (int i = 1; i <= len; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }


        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - A[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], A[i - 1] + dp[i - 1][j - A[i - 1]]);
                }
            }
        }

        return dp[len][m];


    }

}
