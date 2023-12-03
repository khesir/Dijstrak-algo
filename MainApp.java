import java.io.FileReader;
import java.util.Scanner;

import src.Graph;
import src.Node;

/**
 * MainApp
 */
public class MainApp {
    static Graph graph = new Graph();

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){
            GenerateData(new FileReader("graph.txt"));
            DisplayData();
        }catch(Exception e){
            System.out.println("Exception: "+ e);
        }
    }
    public static void DisplayData() throws StringIndexOutOfBoundsException{
        // graph.printGraph();
        graph.showNodes();
        dijkstraAlgo();
        // System.out.println("BreadthFirst");
        // graph.breadthFirstSearch();
        // System.out.println();
        // System.out.println("DepthFirst");
        // graph.depthFirstSearch();
    }
    public static void dijkstraAlgo(){
        System.out.println("Dijkstra Algorithm");
        System.out.println("What node is you start node? ");
        try (Scanner sc = new Scanner(System.in)){
            String key = sc.nextLine();
            
            Node startNode = graph.getNode(key);;
            
            graph.printShortestPath(startNode);
        }catch (Exception e){
            System.out.println("Exception: "+ e);
        }

    }
    public static void GenerateData(FileReader fr){
        try(Scanner sc = new Scanner(fr)){
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(" ");
                
                if(data.length > 1){
                    // Edge data
                    Node start = new Node(data[0]);
                    Node end = new Node(data[1]);
                    int weight = Integer.parseInt(data[2]);

                    graph.addEdge(start, end, weight);
                }else{ 
                    // Nodes data
                    graph.addNode(data[0]);
                }
            }
            //System.out.println("Data has been loaded to the list");
        } catch(Exception e){
            System.out.println("Exception: "+ e);
        }
    }
}