package MatchAndBits;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  12/4/17
 * Time  :  4:30 PM
 */
public class UpdateBits {

    int updateBits(int n, int m, int i, int j) {
        int mask;
        if (j < 31) {
            mask = ~((1 << (j + 1)) - (1 << i));
        } else {
            mask = (1 << i) - 1;
        }
        return (m << i) + (mask & n);
    }

    public static void main(String[] args) {


    }

    }
