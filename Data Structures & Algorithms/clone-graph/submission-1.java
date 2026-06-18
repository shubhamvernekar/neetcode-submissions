/*
Definition for a Node.
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
        if(node == null) return null;
        HashMap<Integer, Node> visited = new HashMap<>();
        Node clone = new Node(node.val);
        copy(node, clone, visited);
        return clone;
    }

    public void copy(Node source, Node clone, HashMap<Integer, Node> visited) {
        visited.put(source.val, clone);

        for(Node node : source.neighbors) {
            if(visited.containsKey(node.val)) {
                clone.neighbors.add(visited.get(node.val));
            } else {
                Node newNode = new Node(node.val);
                copy(node, newNode, visited);
                clone.neighbors.add(newNode);
            }
        }
    }
}