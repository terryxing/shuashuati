package BinarySearch;

/**
 * Created by xingtianyi on 11/29/17.
 */
public class SearchInsertPosition {

    public int searchInsert(int[] A, int target) {

        if(A==null || A.length==0){
            return 0;
        }

        int len = A.length;

        int left = 0;
        int right =len;

        while(left <= right){

            int mid = (left+right)/2;
            int midVal = A[mid];

            if(mid==0){
                if(A[mid] >= target){
                    return 0;
                }else{
                    return 1;
                }
            }

            if(mid==len-1){
                if(A[mid]<target){
                    return len;
                }else{
                    return len-1;
                }
            }

            int midLeft = A[mid-1];
            int midRight = A[mid+1];


            if(midLeft < target && midVal >= target){
                return mid;
            }

            if(midVal < target && midRight >= target){
                return mid+1;
            }

            if(midVal > target){
                right = mid;
            }

            if(midVal < target){
                left=mid;
            }
        }

        return -1;

    }


    public static void main(String[] args) {


        int[] A = {-1,0,1,2};
        int target = 2;

        SearchInsertPosition x = new SearchInsertPosition();
        int result = x.searchInsert(A, target);

    }


}
