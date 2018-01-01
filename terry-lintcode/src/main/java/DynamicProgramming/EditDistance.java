package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/27/17
 * Time  :  11:13 AM
 */
public class EditDistance {

    public static void main(String[] args) {
        String str1 = "ab";
        String str2 = "a";

        EditDistance x = new EditDistance();

        int result = x.minDistance(str1, str2);

    }

    public int minDistance(String word1, String word2) {
        // write your code here

        if (word1 == null || word2 == null) {
            return 0;
        }

        int len1 = word1.length();
        int len2 = word2.length();

        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }

        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;

        for (int i = 1; i < len1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        for (int i = 1; i < len2 + 1; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                int cost = 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cost = 0;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + cost);
            }
        }

        return dp[len1][len2];

    }


}
