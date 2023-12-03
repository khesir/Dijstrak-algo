package src;

public class Edge {
    private Node destination;
    private int weight;

    public Edge(Node destination, int weight){
        this.destination = destination;
        this.weight = weight;
    }
    public Node getDestinationNode(){
        return destination;
    }
    public int getWeight(){
        return weight;
    }
    @Override
    public String toString() {
        return "[" + destination.key + ", " + weight + "] ";
    }
}
