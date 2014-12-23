/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        HashMap<Integer, UndirectedGraphNode> clone = new HashMap<Integer, UndirectedGraphNode>();
        return cloneGraph(node, clone);
    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> clone){
        if (clone.containsKey(node.label)){
            return clone.get(node.label);
        }
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        clone.put(newNode.label, newNode);
        for (UndirectedGraphNode temp: node.neighbors){
            newNode.neighbors.add(cloneGraph(temp, clone));
        }
        return newNode;
    }
}