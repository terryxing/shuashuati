package SearchRecursion;

import java.util.ArrayList;

/**
 * Created by xingtianyi on 12/25/17.
 */
public class DirectedGraphNode {

    int label;
    ArrayList<DirectedGraphNode> neighbors;

    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }

}
