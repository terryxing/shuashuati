package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/27/17
 * Time  :  10:33 PM
 */
public class CoinInALine {


    public static void main(String[] args) {

        CoinInALine x = new CoinInALine();

        int[] values = {1, 2, 4};

        boolean result = x.firstWillWin2(values);

    }

    public boolean firstWillWin(int n) {
        // write your code here

        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n == 2) {
            return true;
        }

        if (n == 3) {
            return false;
        }


        boolean first = true;
        boolean second = false;

        for (int i = 4; i <= n; i++) {
            boolean third = !(first && second);
            first = second;
            second = third;
        }

        return second;

    }

    public boolean firstWillWin2(int[] values) {
        // write your code here

        if (values == null) {
            return false;
        }

        int len = values.length;

        if (len == 0) {
            return false;
        }

        if (len == 1 || len == 2) {
            return true;
        }

        int[] dp = new int[len];
        dp[0] = values[len - 1];
        dp[1] = values[len - 1] + values[len - 2];
        int sum = values[len - 1] + values[len - 2];

        for (int i = 2; i < len; i++) {
            sum += values[len - 1 - i];
            dp[i] = Math.max(sum - dp[i - 1], sum - dp[i - 2]);
        }

        return dp[len - 1] * 2 > sum;


    }

}
