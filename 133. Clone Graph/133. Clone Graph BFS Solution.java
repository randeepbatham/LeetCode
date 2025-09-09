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
        if (node == null) return null;

        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);
        queue.offer(node);

        while (!queue.isEmpty()){
            Node curr = queue.poll();

            for (Node nei : curr.neighbors){
                if (!visited.containsKey(nei)){
                    // create clone
                    visited.put(nei, new Node(nei.val));
                    queue.offer(nei);
                }
                visited.get(curr).neighbors.add(visited.get(nei));
            }
        }
        return visited.get(node);
    }
}
