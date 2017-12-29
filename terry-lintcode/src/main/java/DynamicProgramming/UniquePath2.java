package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/26/17
 * Time  :  3:13 PM
 */
public class UniquePath2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here

        if (obstacleGrid == null) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] matrix = new int[m][n];

        if (obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            matrix[0][0] = 1;
        }


        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                matrix[i][0] = 0;
            } else {
                matrix[i][0] = matrix[i - 1][0];
            }
        }


        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                matrix[0][i] = 0;
            } else {
                matrix[0][i] = matrix[0][i - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                }
            }
        }

        return matrix[m - 1][n - 1];

    }
}
