package DynamicProgramming;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/27/17
 * Time  :  4:38 PM
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        // write your code here

        if(grid == null){
            return 0;
        }

        int lenRow = grid.length;
        int lenColumn = grid[0].length;

        for(int i=1; i<lenRow; i++){
            grid[i][0] = grid[i-1][0]+grid[i][0];
        }

        for(int i=1; i<lenColumn; i++){
            grid[0][i] = grid[0][i-1]+grid[0][i];
        }


        for(int i=1; i<lenRow; i++){
            for(int j=1; j<lenColumn; j++){

                grid[i][j]= Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];

            }
        }

        return grid[lenRow-1][lenColumn-1];


    }
}
