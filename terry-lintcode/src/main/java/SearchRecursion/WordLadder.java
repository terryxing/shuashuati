package SearchRecursion;

import java.util.*;

/**
 * Created by xingtianyi on 12/25/17.
 */
public class WordLadder {


    public int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        //Set<String> h = new HashSet<String>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
        Set<String> h = new HashSet<String>(Arrays.asList("qq"));

        String start = "qa";
        String end = "sq";

        WordLadder x = new WordLadder();

        int result = x.ladderLength(start, end, h);

        System.out.print(result);

    }

    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here

        if (start == null || end == null || dict == null) {
            return 0;
        }


        int len1 = start.length();
        int len2 = end.length();

        if (len1 != len2) {
            return 0;
        }

        List<String> list = new ArrayList<String>();
        list.add(start);
        Set<String> set = new HashSet<String>();
        set.add(start);
        set.add(end);

        if (start.length() == 1) {
            for (String c : dict) {
                if (!c.equals(start) && !c.equals(end)) {
                    return 2;
                }
            }

            return 0;
        }

        helper(start, end, list, set, dict);

        return min;
    }

    private void helper(String curr, String end, List<String> list, Set<String> set, Set<String> dict) {

        if (ifTwoWord(curr, end)) {
            if (list.size() + 1 < min) {
                min = list.size() + 1;
            }
            return;
        }

        for (String currStr : dict) {
            if (set.contains(currStr) || !ifTwoWord(currStr, curr)) {
                continue;
            } else {
                list.add(currStr);
                set.add(currStr);
                helper(currStr, end, list, set, dict);
            }

            set.remove(currStr);
            list.remove(currStr);
        }


    }


    private boolean ifTwoWord(String str1, String str2) {
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();

        if (char1.length != char2.length) {
            return false;
        }

        int count = 0;

        for (int i = 0; i < char1.length; i++) {
            if (char1[i] != char2[i]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

}
