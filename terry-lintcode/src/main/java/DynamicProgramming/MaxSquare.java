package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/27/17
 * Time  :  3:40 PM
 */
public class MaxSquare {

    public int maxSquare(int[][] matrix) {

        if (matrix == null) {
            return 0;
        }

        int lenRow = matrix.length;
        int lenColumn = matrix[0].length;

        int result = 0;

        for (int i = 0; i < lenRow; i++) {
            for (int j = 0; j < lenColumn; j++) {
                if (matrix[i][j] != 0 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i][j - 1], matrix[i - 1][j])) + matrix[i][j];
                }

                if (matrix[i][j] > result) {
                    result = matrix[i][j];
                }
            }
        }

        return result * result;

    }

}
