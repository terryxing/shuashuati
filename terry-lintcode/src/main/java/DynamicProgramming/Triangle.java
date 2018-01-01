package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/26/17
 * Time  :  4:39 PM
 */
public class Triangle {


    public int minimumTotal(int[][] triangle) {

        if (triangle == null) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        int lenRow = triangle.length;
        int lenColumn = triangle[0].length;

        if (lenRow == 0 || lenColumn == 0) {
            return 0;
        }

        if (lenRow == 1) {
            return triangle[0][0];
        }

        for (int i = 1; i < lenRow; i++) {
            for (int j = 0; j < i + 1; j++) {

                if (j == 0) {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i][j];

                } else if (j == i) {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i][j];
                } else {
                    triangle[i][j] = Math.min(triangle[i - 1][j - 1], triangle[i - 1][j]) + triangle[i][j];
                }

                if (i == lenRow - 1) {
                    if (triangle[i][j] < min) {
                        min = triangle[i][j];
                    }
                }

            }
        }

        return min;

    }
}
