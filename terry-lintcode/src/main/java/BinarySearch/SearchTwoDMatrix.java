package BinarySearch;

/**
 * Created by xingtianyi on 11/29/17.
 */
public class SearchTwoDMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int lenRow = matrix.length;

        if(lenRow < 1){
            return false;
        }

        int lenCol = matrix[0].length;


        if(lenCol < 1){
            return false;
        }

        int up=0;
        int down = lenRow-1;

        if(matrix[0][0] > target || matrix[lenRow-1][lenCol-1] < target){
            return false;
        }

        while(up<=down){

            int mid = (up+down)/2;

            if(mid == 0 ){
                if(matrix[mid][0]>target){
                    return false;
                }
            }

            if( mid==lenRow-1){
                if(matrix[mid][lenCol-1]<target){
                    return false;
                }
            }


            if(matrix[mid][0]>target){
                if(target > matrix[mid-1][lenCol-1]){
                    return false;
                }
                down=mid-1;
            }

            if(matrix[mid][lenCol-1]<target){
                if(target < matrix[mid+1][0]){
                    return false;
                }
                up=mid+1;
            }


            if(target>=matrix[mid][0] && target<=matrix[mid][lenCol-1]){

                int left=0;
                int right=lenCol-1;

                if(matrix[mid][0] == target || matrix[mid][lenCol-1] == target){
                    return true;
                }

                while(left<=right){

                    int midIndex = (left+right)/2;

                    if(matrix[mid][midIndex]==target){
                        return true;
                    }

                    if(matrix[mid][midIndex] > target){
                        right = midIndex-1;
                    }

                    if(matrix[mid][midIndex] < target){
                        left = midIndex+1;
                    }
                }
                return false;
            }

        }
        return false;
    }


    public static void main(String[] args) {

//        int[][] m = {{1,5,9,13,18,25,28,33,39,43,44,51,55,56,63,68,73,77,80},
//                {100,117,141,164,181,199,218,241,265,285,310,326,341,354,370,380,397,408,420},
//                {433,453,475,494,506,518,536,550,568,585,609,626,651,662,676,698,716,729,746},
//                {766,791,809,829,844,869,894,916,930,947,967,981,992,1012,1036,1059,1083,1099,1116},
//                {1137,1150,1163,1177,1199,1215,1231,1243,1268,1283,1304,1326,1344,1362,1387,1408,1428,1438,1461},
//                {1533,1548,1563,1586,1609,1634,1656,1667,1681,1706,1731,1746,1760,1778,1794,1815,1830,1846,1861}};

        int[][] xx = {{1,4,5},{6,7,8}};

        SearchTwoDMatrix x = new SearchTwoDMatrix();

        boolean result = x.searchMatrix(xx, 6);

    }

    }
