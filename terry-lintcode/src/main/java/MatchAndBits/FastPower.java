package MatchAndBits;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/4/17
 * Time  :  4:53 PM
 */
public class FastPower {

    public int fastPower(int a, int b, int n) {
        // write your code here
        if (n == 1) {
            return a % b;
        }
        if (n == 0) {
            return 1 % b;
        }

        long product = fastPower(a, b, n / 2);
        product = (product * product) % b;
        if (n % 2 == 1) {
            product = (product * a) % b;
        }
        return (int) product;

    }

    public static void main(String[] args) {


    }

}
