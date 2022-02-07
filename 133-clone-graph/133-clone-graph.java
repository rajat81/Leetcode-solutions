/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Map<Node, Node> mapping = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        q.offer(node);
        mapping.put(node, new Node(node.val));
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            for(Node adj: current.neighbors) {
                if(!mapping.containsKey(adj)) {
                    mapping.put(adj, new Node(adj.val));
                    q.add(adj);
                }
                
                mapping.get(current).neighbors.add(mapping.get(adj));
            }
        }
        
        return mapping.get(node);
    }
}