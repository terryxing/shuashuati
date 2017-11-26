package Strings;

import java.util.HashMap;

/**
 * Created by xingtianyi on 11/25/17.
 */
public class TwoStringsAreAnagrams {

    public boolean anagram(String s, String t) {

        if(s == null && t == null){
            return true;
        } else if(s == null || t == null){
            return false;
        }else if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(char currCh : s.toCharArray()){

            if(!map.containsKey(currCh)){
                map.put(currCh, 1);
            }else{
                map.put(currCh, map.get(currCh)+1);
            }

        }


        for(char currCh : t.toCharArray()){

            if(!map.containsKey(currCh)){
                return false;
            }

            if(map.get(currCh)>1){
                map.put(currCh, map.get(currCh)-1);
            }else{
                map.remove(currCh);
            }
        }

        if(map.size()>0){
            return false;
        }else{
            return true;
        }

    }

    public static void main(String[] args) {

    }



}
