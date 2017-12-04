package MatchAndBits;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/4/17
 * Time  :  3:29 PM
 */
public class TrailingZero {

    public long trailingZeros(long n) {
        // write your code here

        long multipleFive = 5;
        long result = 0;
        while (n >= multipleFive) {
            result += n / multipleFive;
            multipleFive *= 5;
        }
        return result;

    }


    public static void main(String[] args) {
        long n = 8;

        TrailingZero x = new TrailingZero();

        long result = x.trailingZeros(n);

    }

}
