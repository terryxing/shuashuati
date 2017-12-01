package BinarySearch;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  11/30/17
 * Time  :  3:22 PM
 */
public class FindPeakElement {

    public int findPeak(int[] A) {

        if(A==null){
            return 0;
        }

        int len = A.length;

        if(len < 0){
            return -1;
        }

        int left = 0;
        int right = len-1;
        int mid=0;

        while(left <=right){

            mid = (left+right)/2;
            int midVal = A[mid];

            if(mid-1>=0 && mid+1<len){
                if(A[mid] > A[mid-1] && A[mid] > A[mid+1]){
                    return mid;
                }
            }

            //left is right,
            if(mid-1>0 && A[mid-1] > A[mid]){
                right = mid;
                continue;
            }

            //right is higher
            if(mid+1<len && A[mid+1] > A[mid]){
                left= mid;
            }

        }

        return mid;


    }

    public static void main(String[] args) {

        FindPeakElement x = new FindPeakElement();
        int[] A = {100,102,104,7,9,11,4,3};

        int result = x.findPeak(A);

    }



    }
