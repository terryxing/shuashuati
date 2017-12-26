import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xingtianyi on 12/25/17.
 */
public class PlayGround {

    public static void main(String[] args) {

        Set<List<Integer>> set = new HashSet<List<Integer>>();

        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        l1.add(2);
        l1.add(3);

        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(1);
        l2.add(2);
        l2.add(3);


        set.add(l1);

        System.out.println(set.contains(l2));
        System.out.println(l1.equals(l2));
        System.out.println(l1==l2);




    }
}
