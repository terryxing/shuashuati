package BinarySearch;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/1/17
 * Time  :  3:50 PM
 */
public class SearchForARange {

    public static void main(String[] args) {

        int[] A = {1,3,5,6,8,9};

        SearchForARange x = new SearchForARange();

        int[] result = x.searchRange(A, 7);

    }

    public int[] searchRange(int[] A, int target) {

        int[] result = new int[2];

        result[0] = -1;
        result[1] = -1;


        if (A == null || A.length == 0) {
            result[0] = -1;
            result[1] = -1;
            return result;

        }

        int len = A.length;


        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (A[mid] == target) {

                result[0] = mid;
                result[1] = mid;

                int p1 = mid;
                int p2 = mid;
                while (p1 >= 0) {
                    if (A[p1] == A[mid]) {
                        result[0] = p1;
                        p1--;
                    } else {
                        break;
                    }
                }

                while (p2 < len) {
                    if (A[p2] == A[mid]) {
                        result[1] = p2;
                        p2++;
                    } else {
                        break;
                    }

                }
                break;

            } else {
                if (A[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return result;

    }


}
