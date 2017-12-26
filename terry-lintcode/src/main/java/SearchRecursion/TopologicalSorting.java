package SearchRecursion;

import java.util.*;

/**
 * Created by xingtianyi on 12/25/17.
 */
public class TopologicalSorting {

    public static void main(String[] args) {

        DirectedGraphNode l0 = new DirectedGraphNode(0);
        DirectedGraphNode l1 = new DirectedGraphNode(1);
        DirectedGraphNode l2 = new DirectedGraphNode(2);
        DirectedGraphNode l3 = new DirectedGraphNode(3);
        DirectedGraphNode l4 = new DirectedGraphNode(4);
        DirectedGraphNode l5 = new DirectedGraphNode(5);

        ArrayList<DirectedGraphNode> list2 = new ArrayList<DirectedGraphNode>();
        list2.add(l1);
        list2.add(l2);
        list2.add(l3);
        l0.neighbors = list2;

        ArrayList<DirectedGraphNode> list3 = new ArrayList<DirectedGraphNode>();
        list3.add(l4);
        l1.neighbors = list3;

        ArrayList<DirectedGraphNode> list4 = new ArrayList<DirectedGraphNode>();
        list4.add(l4);
        list4.add(l5);

        l2.neighbors = list4;
        l3.neighbors = list4;


        ArrayList<DirectedGraphNode> graph = new ArrayList<DirectedGraphNode>();
        graph.add(l0);
        graph.add(l1);
        graph.add(l2);
        graph.add(l3);
        graph.add(l4);
        graph.add(l5);


        TopologicalSorting x = new TopologicalSorting();

        ArrayList<DirectedGraphNode> result = x.topSort(graph);

    }

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here


        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();

        if (graph == null || graph.size() == 0) {
            return result;
        }

        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();

        for (DirectedGraphNode currNode : graph) {

            if (!map.containsKey(currNode)) {
                map.put(currNode, 0);
            }
            ArrayList<DirectedGraphNode> neighbors = currNode.neighbors;

            for (DirectedGraphNode eachNeighbor : neighbors) {
                if (map.containsKey(eachNeighbor)) {
                    map.put(eachNeighbor, map.get(eachNeighbor) + 1);
                } else {
                    map.put(eachNeighbor, 1);
                }
            }
        }

        DirectedGraphNode root = null;

        for (DirectedGraphNode currNode : map.keySet()) {
            if (map.get(currNode) == 0) {
                if (root == null) {
                    root = currNode;
                }
                q.add(currNode);
                result.add(currNode);
            }
        }

        if (root == null) {
            return result;
        }

        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    result.add(n);
                    q.add(n);
                }
            }
        }
        return result;
    }

}
