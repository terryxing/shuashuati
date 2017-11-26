package Strings;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by xingtianyi on 11/27/17.
 */
public class CompareStrings {


    public boolean compareStrings(String A, String B) {


        if (A == null && B == null) {
            return true;
        } else if (B == null || B.length() == 0) {
            return true;
        }


        ArrayList<Character> sChars = new ArrayList<Character>();
        for (char c : A.toCharArray()) {
            sChars.add(c);
        }

        ArrayList<Character> tChars = new ArrayList<Character>();
        for (char c : B.toCharArray()) {
            tChars.add(c);
        }

        HashMap<Character, Integer> sHash = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tHash = new HashMap<Character, Integer>();

        for (Character currS : sChars) {
            if (sHash.containsKey(currS)) {
                sHash.put(currS, sHash.get(currS) + 1);
            } else {
                sHash.put(currS, new Integer(1));
            }
        }

        for (Character currT : tChars) {
            if (tHash.containsKey(currT)) {
                tHash.put(currT, tHash.get(currT) + 1);
            } else {
                tHash.put(currT, new Integer(1));
            }
        }

        if (tHash.size() > sHash.size()) {
            return false;
        }

        for (Character currT : tHash.keySet()) {
            if (!sHash.containsKey(currT) || sHash.get(currT) < tHash.get(currT)) {
                return false;
            } else {
                if (sHash.get(currT) > 1) {
                    sHash.put(currT, sHash.get(currT) - 1);
                } else {
                    sHash.remove(currT);
                }
            }
        }


        return true;
    }

    public static void main(String[] args) {

    }

}
