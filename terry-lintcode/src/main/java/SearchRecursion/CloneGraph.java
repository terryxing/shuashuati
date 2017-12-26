package SearchRecursion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by xingtianyi on 12/25/17.
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here


        if (node == null) {
            return null;
        }


        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();

        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        map.put(node, head);
        q.add(node);


        while (!q.isEmpty()) {
            UndirectedGraphNode currNode = q.poll();

            for (UndirectedGraphNode nei : currNode.neighbors) {

                if (!map.containsKey(nei)) {
                    q.add(nei);
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(nei.label);
                    map.put(nei, newNeighbor);

                }
                map.get(currNode).neighbors.add(map.get(nei));
            }

        }

        return head;

    }
}
