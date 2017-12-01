package BinarySearch;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/1/17
 * Time  :  1:52 PM
 */
public class SearchInRotatedSortedArrays {

    public int search(int[] A, int target) {

        if(A == null || A.length < 1){
            return -1;
        }

        int len = A.length;

        int left = 0;
        int right = len-1;

        int minIndex = 0;
        int minVal = 0;

        if(target == A[0]){
            return 0;
        }

        if(target == A[len-1]){
           return len-1;
        }

        while(left <= right){

            int mid = (left+right)/2;
            int midVal = A[mid];
            int leftVal = A[left];
            int rightVal = A[right];

            if(midVal == target){
                return mid;
            }

            if(leftVal < rightVal){
                minIndex = 0;
                minVal = A[0];
                break;
            }

            if( (mid-1) >= 0  && A[mid-1]>midVal){
                minIndex = mid;
                minVal = A[minIndex];
                break;
            }

            if( mid+1 < len && A[mid+1]< midVal){
                minIndex = mid+1;
                minVal = A[mid+1];
                break;
            }

            if(A[0] < A[mid]){
                left = mid+1;
            }else{
                right = mid-1;
            }

        }

        if(target == minVal){
            return minIndex;
        }

        if(target > minVal && target < A[len-1]){
            left = minIndex;
            right = len-1;
        }else{
            left = 0;
            right = minIndex;
        }

        while(left <=right){
            int mid = (left+right)/2;
            int midVal = A[mid];

            if(target == midVal){
                return mid;
            }

            if(midVal > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return -1;


    }

    public static void main(String[] args) {

        int[] A = {6,8,9,1,3,5};

        SearchInRotatedSortedArrays x = new SearchInRotatedSortedArrays();

        int result = x.search(A, 5);

        System.out.print(result);


    }





    }
