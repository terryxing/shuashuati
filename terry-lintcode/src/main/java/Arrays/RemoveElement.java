package Arrays;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  11/28/17
 * Time  :  3:30 PM
 */
public class RemoveElement {

//
//    Given an array and a value, remove all occurrences of that value in place and return the new length.
//    The order of elements can be changed, and the elements after the new length don't matter.


    public int removeElement(int[] A, int elem) {

        if (A == null || A.length == 0) {
            return 0;
        }

        int i = 0;
        int j;

        for (j = 0; j < A.length; j++) {
            if (A[j] != elem) {
                A[i] = A[j];
                i++;
            }
        }

        return i;

    }


    public static void main(String[] args) {

    }

}
