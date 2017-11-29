package Arrays;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  11/28/17
 * Time  :  4:46 PM
 */
public class MergeTwoSortedArrays {

    public void mergeSortedArray(int[] A, int m, int[] B, int n) {

        int lenA =A.length;
        int lenB = B.length;

        int i=m-1;
        int j=n-1;

        while(i>=0 && j>=0){

            if(A[i]>=B[j]){
                A[i+j+1]=A[i];
                i--;
            }else{
                A[i+j+1]=B[j];
                j--;
            }
        }

        while(j>=0){
            A[i+j+1]=B[j];
            j--;
        }


    }

    public static void main(String[] args) {


    }

    }
