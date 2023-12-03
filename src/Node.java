package src;

import java.util.LinkedList;

public class Node implements Comparable<Node>{
    public String key;
    public int distance;

    protected boolean visit;
    protected LinkedList<Edge> adj;
    
    public Node(String key){
        this.key = key;
        adj = new LinkedList<>();
        distance = Integer.MAX_VALUE;
    }
    public String getKey(){
        return key;
    }
    public void AddEdgeNode(Edge adj){
        this.adj.add(adj);
    }
    public void setVisit(boolean condition){
        visit = condition;
    }
    
    public boolean isVisited(){
        return visit;
    }
    public boolean isAdjacent(Node otherNode){
        for(Edge edge : adj){
            if(edge.getDestinationNode().key.equals(otherNode.key)){
                return true;
            }
        }
        return false;
    }
    public int getEdgeWeight(Node otherNode){
        for(Edge edge : adj){
            if(edge.getDestinationNode().key.equals(otherNode.key)){
                return edge.getWeight();
            }
        }
        return 0;
    }
    public LinkedList<Edge> getEdgeList(){
        return adj;
    }
    @Override
    public int compareTo(Node otherNode) {
        // Compare nodes based on their distance
        return Integer.compare(this.distance, otherNode.distance);
    }
    public String toString() {
        StringBuilder result = new StringBuilder("Node: " + key + ", Edges: ");
        for (Edge edge : adj) {
            result.append(edge.toString());
        }
        return result.toString();
    }
}
