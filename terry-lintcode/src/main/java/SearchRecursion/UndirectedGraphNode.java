package SearchRecursion;

import java.util.ArrayList;

/**
 * Created by xingtianyi on 12/25/17.
 */
public class UndirectedGraphNode {

    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

}
