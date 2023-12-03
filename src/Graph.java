package src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {
    private LinkedList<Node> nodes;
    
    public Graph(){
        nodes = new LinkedList<>();
        
    }
    public Node getNode(String key){
        for(Node node : nodes){
            if(node.key.equals(key)){
                return node;
            }
        }
        return null;
    }
    public Node getNode(Node key){
        for(Node node : nodes){
            if(node.key.equals(key.key)){
                return node;
            }
        }
        return null;
    }
    public void addNode(String data){
        nodes.add(new Node(data));
    }
    public void addEdge(Node start, Node end, int weight){
        Node srcNode = findNode(start);
        Node destNode = findNode(end);

        if(srcNode != null && destNode != null){                       
            srcNode.AddEdgeNode(new Edge(destNode,weight));
        }
    }
    private Node findNode(Node data){
        for(Node node : nodes){
            if (node.key.equals(data.key)){
                
                return node;
            }
        }
        return null;
    }
    public void printGraph() {
        System.out.println("Adjacency Matrix");
        System.out.print("   ");
        // Print header
        for(Node node : nodes){
            System.out.print(node.key + "  ");
        }
        System.out.println();
        // Print each row
        for(Node node : nodes){
            System.out.print(node.key + "  ");
            
            for(Node otherNode: nodes){
                if(node.isAdjacent(otherNode)){
                    //get weight of the edge
                    System.out.print(node.getEdgeWeight(otherNode) + "  ");
                } else {
                    System.out.print("0  ");
                }
            }
            System.out.println();
        }
        System.out.println("==============================================");
    }
    
    public void showNodes(){
        for(Node node : nodes){
            System.out.println(node);
        }
    }
    public void dijkstra(Node start){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        start.distance = 0;
        priorityQueue.offer(start);

        while(!priorityQueue.isEmpty()){;
            Node current = priorityQueue.poll();

            for(Edge edge: current.getEdgeList()){
                Node neighbor = getNode(edge.getDestinationNode());
                int newDistance = current.distance + edge.getWeight();
                if(newDistance < neighbor.distance){
                    neighbor.distance = newDistance;
                    priorityQueue.offer(neighbor);
                }
            }
        }
    }
    public void printShortestPath(Node start){
        dijkstra(start);

        System.out.println("Starting Vertex: "+ start.key);
        for(Node node : nodes){
            if(node.key.equals(start.key))
                continue;
            System.out.println(node.key + " "+ node.distance);
        }
    }
}
//     public void DFS(Node node, StringBuilder st){
//         for(Node adj : node.getAdjacentNode()){
//             if(adj.isVisited() == false){
//                 st.append(adj.key + "-");
//                 adj.setVisit(true);
//                 DFS(adj,st);
//             }
//         }
//     }
//     public void depthFirstSearch(){
//         StringBuilder st = new StringBuilder();
//         resetVisitVal();
//         for(Node node : nodes){
//             if(node.isVisited() == false){
//                 st.append(node.key + "-");
//                 node.setVisit(true);
//             }
//             DFS(node, st);
//         }
//         st.deleteCharAt(st.length()-1);
//         System.out.println(st.toString());
//     }
//     public void breadthFirstSearch(){
//         StringBuilder st = new StringBuilder();
//         Queue<Node> q = new LinkedList<>();
//         Node v;
//         resetVisitVal();
//         for(Node node: nodes){
//             if(node.isVisited() == false)
//             {
//                 node.visit = true;
//                 q.add(node);
//                 while(!q.isEmpty()){
//                     v = q.remove();
//                     st.append(v.key + "-");
//                     for(Node adj: v.getAdjacentNode()){
//                         if(adj.isVisited() == false){
//                             adj.setVisit(true);
//                             q.add(adj);
//                         }
//                     }
//                 }
//             }
//         }
//         st.deleteCharAt(st.length()-1);
//         System.out.println(st.toString());
//     }
//     private void resetVisitVal(){
//         for(Node node : nodes){
//             node.setVisit(false);
//         }
//     }
//    
// }
