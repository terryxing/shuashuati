package DynamicProgramming;

/**
 * Created by xingtianyi on 1/1/18.
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here

        //boolean dp[i][j] denotes s1 0-i, s2 0-j result in s3.
        if(s3==null){
            return false;
        }else if(s1 == null){
            return s3.equals(s2);
        }else if(s2 == null){
            return s3.equals(s1);
        }

        int lenS1 = s1.length();
        int lenS2 = s2.length();

        int lenS3 = s3.length();

        if(lenS3 == 0 && lenS1 == 0 && lenS2 == 0){
            return true;
        }


        if(lenS3 != lenS1+lenS2){
            return false;
        }

        boolean[][] dp = new boolean[lenS1+1][lenS2+1];
        dp[0][0]=true;

        for(int i=1; i<=lenS2; i++){
            if(s3.charAt(i-1) == s2.charAt(i-1)){
                dp[0][i]=true;
            }else{
                dp[0][i]=false;
            }
        }

        for(int i=1; i<=lenS1; i++){
            if(s3.charAt(i-1) == s1.charAt(i-1)){
                dp[i][0]=true;
            }else{
                dp[i][0]=false;
            }
        }


        for(int i=1; i<= lenS1; i++){
            for(int j=1; j<= lenS2; j ++){

                boolean flag = false;
                if(s1.charAt(i-1)==s3.charAt(i+j-1) && dp[i-1][j]){
                    flag= true;
                }

                if(s2.charAt(j-1)==s3.charAt(i+j-1) && dp[i][j-1]){
                    flag= flag || true;
                }
                dp[i][j]=flag;
            }
        }

        return dp[lenS1][lenS2];

    }
}
