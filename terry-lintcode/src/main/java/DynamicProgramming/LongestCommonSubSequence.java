package DynamicProgramming;

/**
 * Created by xingtianyi on 1/1/18.
 */
public class LongestCommonSubSequence {

    public int longestCommonSubsequence(String s1, String s2) {
        // write your code here
        if(s1 == null || s2==null){
            return 0;
        }

        int lenS1 = s1.length();
        int lenS2 = s2.length();

        if(lenS1 == 0 || lenS2 == 0){
            return 0;
        }

        int[][] dp = new int[lenS1+1][lenS2+1];

        dp[0][0]=0;

        for(int i=1; i<=lenS2; i++){
            dp[0][i]=0;
        }

        for(int i=1; i<=lenS1; i++){
            dp[i][0]=0;
        }


        for(int i=1; i<=lenS1; i++){
            for(int j=1; j<=lenS2; j ++){
                int curr = 0;
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
                }else{
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[lenS1][lenS2];


    }
}
