package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/28/17
 * Time  :  5:16 PM
 */
public class DistinctSubsequences {

    public int numDistinct(String S, String T) {
        // write your code here

        if(S==null || T==null){
            return 0;
        }

        int lenS = S.length();
        int lenT = T.length();

        int[][] dp = new int[lenT+1][lenS+1];

        if(lenT == 0){
            return 1;
        }

        for(int i=0; i<=lenS; i++){
            dp[0][i]=1;
        }

        for(int j=1; j<=lenT; j++){
            dp[j][0]=0;
        }

        for(int i=1; i<=lenT; i++) {
            for(int j=1; j<=lenS; j++) {
                if(T.charAt(i-1)!=S.charAt(j-1)){
                    dp[i][j] = dp[i][j-1];
                }else{
                    if(dp[i-1][j-1]==0){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = dp[i][j-1]+dp[i-1][j-1];
                    }

                }
            }
        }

        return dp[lenT][lenS];

    }
}
