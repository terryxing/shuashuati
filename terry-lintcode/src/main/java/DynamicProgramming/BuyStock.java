package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/29/17
 * Time  :  5:52 PM
 */
public class BuyStock {

    public static void main(String[] args) {

        int[] d = {2,1};
        BuyStock x = new BuyStock();

        int result = x.maxProfit(d);
        System.out.print(result);

    }
    public int maxProfit(int[] prices) {

        if(prices == null){
            return 0;
        }

        int len = prices.length;

        if(len ==0){
            return 0;
        }

        int[][] dp = new int[len][len];

        return search(prices, 0, len-1, dp);

    }

    public int search(int[] prices, int i, int j, int[][] dp){

        if(i>=j){
            return 0;
        }

        if(dp[i][j]!=0){
            return dp[i][j];
        }

        if(prices[i] < prices[j]){
            dp[i][j] = prices[j]-prices[i];
        }

        if(i==j-1){
            return dp[i][j];
        }

        for(int k=i; k<=j; k++){
            dp[i][j] = Math.max(search(prices, i, k, dp) + search(prices, k+1, j, dp), dp[i][j]);
        }

        return dp[i][j];
    }

}
