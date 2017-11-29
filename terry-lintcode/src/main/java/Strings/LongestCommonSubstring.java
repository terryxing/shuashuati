package Strings;

/**
 * Created by xingtianyi on 11/27/17.
 */
public class LongestCommonSubstring {


    public static void main(String[] args) {

        LongestCommonSubstring x = new LongestCommonSubstring();


    }

    public int longestCommonSubstring(String A, String B) {

        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }


        int lenA = A.length();
        int lenB = B.length();

        int[][] matrix = new int[lenB + 1][lenA + 1];

        for (int i = 0; i < lenA + 1; i++) {
            matrix[0][i] = 0;
        }


        for (int i = 0; i < lenB + 1; i++) {
            matrix[i][0] = 0;
        }

        int max = 0;

        for (int i = 0; i < lenB; i++) {
            for (int j = 0; j < lenA; j++) {
                if (A.charAt(j) != B.charAt(i)) {
                    matrix[i + 1][j + 1] = 0;
                } else {
                    matrix[i + 1][j + 1] = matrix[i][j] + 1;
                    if (matrix[i + 1][j + 1] > max) {
                        max = matrix[i + 1][j + 1];
                    }
                }
            }
        }

        return max;
    }


}
