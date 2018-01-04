package DataStructure;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  1/3/18
 * Time  :  9:53 PM
 */
public class WordSearch {

    public static void main(String[] args) {

        char[][] input ={{'A','B','C','E'},{'S','F', 'E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";

        WordSearch x = new WordSearch();
        boolean result = x.exist(input, word);

    }

    public boolean exist(char[][] board, String word) {
        // write your code here
        if(word == null){
            return false;
        }

        if(board == null){
            return false;
        }

        int len1 = board.length;
        int len2 = board[0].length;

        if(len1 == 0 || len2 == 0){
            return false;
        }


        for(int i=0; i<len1; i++){
            for(int j=0; j<len2; j++){
                boolean[][] dp = new boolean[len1][len2];

                if(board[i][j]==word.charAt(0)){
                    dp[i][j] = true;
                    boolean flag1 = helper(board, i-1,j,word, 1, dp);
                    boolean flag2 = helper(board, i+1,j,word, 1, dp) ;
                    boolean flag3 = helper(board, i,j-1,word, 1, dp);
                    boolean flag4 = helper(board, i,j+1,word, 1, dp);

                    if(flag1 || flag2 || flag3 || flag4){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean helper(char[][] board, int i, int j, String word, int index, boolean[][] dp){



        if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1){
            return false;
        }

        if(index==word.length()){
            return true;
        }

        if(dp[i][j]){
            return false;
        }


        if(board[i][j]==word.charAt(index)){
            dp[i][j] = true;
            boolean flag1 = helper(board, i-1,j,word, index+1, dp);
            boolean flag2 = helper(board, i+1,j,word, index+1, dp) ;
            boolean flag3 = helper(board, i,j-1,word, index+1, dp);
            boolean flag4 = helper(board, i,j+1,word, index+1, dp);

            if(flag1 || flag2 || flag3 || flag4){
                return true;
            }else{
                dp[i][j]=false;
                return false;
            }
        }else{
            return false;
        }
    }
}
