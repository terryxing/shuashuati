package BinarySearch;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  11/30/17
 * Time  :  3:51 PM
 */
public class FirstBadVersion {

    public static void main(String[] args) {

        FirstBadVersion x = new FirstBadVersion();

        int A = 2147483647;

        int result = x.findFirstBadVersion(A);

    }

    public int findFirstBadVersion(int n) {

        if (n <= 0) {
            return n;
        }

        long left = 1;
        long right = n;

        int mid = 1;

        while (left <= right) {

            mid = (int) ((left+right)/2);

            boolean curr = SVNRepo.isBadVersion(mid);

            if (curr && mid == 1) {
                return mid;
            }

            if (mid - 1 > 0 && curr && !SVNRepo.isBadVersion(mid - 1)) {
                return mid;
            }

            if (mid + 1 <= n && !curr && SVNRepo.isBadVersion(mid + 1)) {
                return mid + 1;
            }

            if (curr) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return mid;

    }

    public static class SVNRepo {


        public static boolean isBadVersion(int x) {
            if(x==2147483647){
                return true;
            }
            return false;

        }


    }


}
