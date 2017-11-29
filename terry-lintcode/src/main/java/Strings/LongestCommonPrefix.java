package Strings;

/**
 * Created by xingtianyi on 11/27/17.
 */
public class LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {

        StringBuilder sb = new StringBuilder();

        if (strs == null || strs.length == 0) {
            return "";
        }

        int shortestLen = Integer.MAX_VALUE;
        int shortestIndex = 0;

        for (int i = 0; i < strs.length; i++) {
            String currStr = strs[i];
            if (currStr.length() < shortestLen) {
                shortestLen = currStr.length();
                shortestIndex = i;
            }
        }

        for (int i = 0; i < shortestLen; i++) {

            String currStr = strs[shortestIndex];

            for (int j = 0; j < strs.length; j++) {

                if (j == shortestIndex) {
                    continue;
                }

                String toCompare = strs[j];

                if (currStr.charAt(i) != toCompare.charAt(i)) {
                    return sb.toString();
                }
            }

            sb.append(currStr.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String[] str = {};

        LongestCommonPrefix x = new LongestCommonPrefix();

        String result = x.longestCommonPrefix(str);

    }

}
