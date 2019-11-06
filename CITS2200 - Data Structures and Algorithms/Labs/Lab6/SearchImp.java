import CITS2200.*;
import java.util.*;
/**
 * Lab 6
 * @author Julian
 */
public class SearchImp implements CITS2200.Search
{
    /**
     * Output an array specifying the parent vertex for each vertex     
     * (or -1 if there is no parent), assuming a Breadth First Search.
     * @param Graph g, int startVertex
     * @return array listing parent of each vertex or -1.
     */
    public int[] getConnectedTree(Graph g, int startVertex){
        int size = g.getNumberOfVertices();
        int[] x = new int[size];
        int[] check = new int[size];
        int m[][] = g.getEdgeMatrix();
        for(int i = 0; i < size; i++){
            x[i] = -1;
            check[i] = 0;
        }
        check[startVertex] = 1;
        java.util.Queue<Integer> l = new LinkedList<Integer>();
        l.add(startVertex);
        while(!l.isEmpty()){
            int y = l.remove();
            for(int i = 0; i < size; i++){
                if(check[i] == 0 && m[y][i] != 0){
                    x[i] = y;
                    check[i] = 1;
                    l.add(i);
                }
            }
            check[startVertex] = 2;
        }
        x[startVertex] = -1;
        return x;
    }
    
    /**
     * Output an array specifying the distance each vertex 
     * is from the starting vertex, or -1 if it is not reachable.
     * @param Graph g, int startVertex
     * @return array listing the distance of each vertex from the start or -1.
     */
    public int[] getDistances(Graph g, int startVertex){
        int size = g.getNumberOfVertices();
        int x[] = new int[size];
        int check[] = new int[size];
        int m[][] = g.getEdgeMatrix(); 
        for(int i = 0; i < size; i++){
            x[i] = -1;
            check[i] = 0;
        }
        check[startVertex] = 1;
        x[startVertex] = 0;        
        java.util.Queue<Integer> l = new LinkedList<Integer>();
        l.add(startVertex);
        while(!l.isEmpty()){
            int y = l.remove();
            for(int i = 0; i < size; i++){
                if(check[i] == 0 && m[y][i] != 0){
                    x[i] = x[y] + 1;
                    check[i] = 1;
                    l.add(i);
                }
            }
            check[y] = 2;
        }
        return x;
    }
    
    /**
     * Output start and finish times for each vertex
     * @param Graph g, int startVertex
     * @return 2D array with start and end time
     */
    public int[][] getTimes(Graph g, int startVertex){
        return (DFS(g, startVertex));
        }
   
    private int[][] DFS(Graph g, int startVertex){
        int size = g.getNumberOfVertices();
        int time = 0;
        int times[][] = new int[size][2];
        int check[] = new int [size];
        int x[] = new int[size];
        int m[][] = g.getEdgeMatrix();
        for(int i = 0; i < size; i++){
            times[i][0] = times[i][1] = -1;
            check[i] = 0;
        }
        check[startVertex] = 1;
        times[startVertex][0] = time;        
        time = time + 1; 
        java.util.Stack s = new java.util.Stack();
        for(int i = 0; i< size; i++){
            if(check[i] == 0){
                x[i] = startVertex;
                DFS(g, i);
            }
        }
        check[startVertex] = 2;
        time = time + 1;
        times[startVertex][1] = time;
        return times;
    }
}
