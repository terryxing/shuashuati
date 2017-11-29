package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xingtianyi on 11/27/17.
 */
public class Anagrams {

//    Given an array of strings, return all groups of strings that are anagrams.


    public static void main(String[] args) {

        String a = "";
        String b = "";
        String[] ab = {"tea", "and", "ate", "eat", "den"};

        Anagrams x = new Anagrams();
        List<String> result = x.anagrams(ab);


    }

    public List<String> anagrams(String[] strs) {

        List<String> result = new ArrayList<String>();

        if (strs == null || strs.length == 0) {
            return result;
        }

        HashMap<String, List<Integer>> hashStr = new HashMap<String, List<Integer>>();

        List<Integer> listOfEmpty = new ArrayList<Integer>();

        for (int i = 0; i < strs.length; i++) {

            String currStr = strs[i];
            char[] currStrCharArray = currStr.toCharArray();
            Arrays.sort(currStrCharArray);

//            String sortedStr;
//            for(int j=0; j<currStrCharArray.length; j++){
//                sortedStr += (String)currStrCharArray[j];
//            }

//            if(currStrCharArray.length<1){
//                listOfEmpty.add(i);
//                continue;
//            }

            String sortedStr = String.valueOf(currStrCharArray);

            if (!hashStr.containsKey(sortedStr)) {
                List<Integer> listOfInt = new ArrayList<Integer>();
                listOfInt.add(i);
                hashStr.put(sortedStr, listOfInt);
            } else {
                List<Integer> listOfInt = hashStr.get(sortedStr);
                listOfInt.add(i);
                hashStr.put(sortedStr, listOfInt);
            }
        }

//        if(listOfEmpty.size()>1){
//            for (Integer currIndex : listOfEmpty) {
//                result.add(strs[currIndex]);
//            }
//            return result;
//        }

        for (String currStr : hashStr.keySet()) {

            if (hashStr.get(currStr).size() > 1) {

                List<Integer> listOfInt = hashStr.get(currStr);

                for (Integer currIndex : listOfInt) {
                    result.add(strs[currIndex]);
                }
            }
        }

        return result;

    }
}
