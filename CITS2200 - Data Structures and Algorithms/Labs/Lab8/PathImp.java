import CITS2200.*;
import java.util.*;
/**
 * Lab 8
 * @author Julian
 */
public class PathImp implements Path
{
    /**
     * Finds the minimum weight of a spanning tree for the given graph.
     * @param Graph g to be searched
     * @return weight of the minimum spanning tree, else -1
     */
    public int getMinSpanningTree(Graph g){
        int size = g.getNumberOfVertices();
        int m[][] = g.getEdgeMatrix();
        boolean[] check = new boolean[size];    
        int min = 9999;
        int a = 0;
        int b = 0;
        int weight = 0;
        for(int i = 0; i < size; i++){
            check[i] = false;
            for(int j = 0; j < size; j++){
                if(m[i][j] == 0){
                    m[i][j] = 9999;
                }
            }
        }
        check[0] = true;
        for(int x = 0; x < size - 1; x++){
            min = 9999;
            for(int i = 0; i < size; i++){
                if(check[i] == true){
                    for(int j = 0; j < size; j++){
                        if(check[j] == false){
                            if(min > m[i][j]){
                                min = m[i][j];
                                a = i;
                                b = j;
                            }
                        }
                    }
                }
            }
            check[b] = true;
            weight = weight + min;
            m[a][b] = 9999;
        }
        if(weight == 0){
            return -1;
        }
        else{
            return weight;        
        }
    }
    
    /**
     * Runs Dijkstra's algorithm on a given undirected, 
     * non-negative weighted graph to find the distances to all vertices from the specified source vertex
     * @param Graph g to be searched and source the vertex to start
     * @return array listing the distance to each vertex, else -1
     */
    public int[] getShortestPaths(Graph g, int source){
        int size = g.getNumberOfVertices();
        int m[][] = g.getEdgeMatrix();
        boolean[] check = new boolean[size];
        int min = 9999;
        int next = 0;
        for(int i = 0 ; i < size; i++){
            check[i] = false;
            for(int j = 0; j < size; j++){
                if(m[i][j] == 0){
                    m[i][j] = 9999;
                }
            }
        }
        int distance[] = m[source];
        distance[source] = 0;
        check[source] = true;
        for(int x = 0; x < size; x++){
            min = 9999;
            for(int i = 0; i < size; i++){
                if(check[i] == false && min > distance[i]){
                    min = distance[i];
                    next = i;
                }
            }
            check[next] = true;
            for(int j = 0; j < size; j++){
                if(check[j] == false){
                    if(distance[j] > (min + m[next][j])){
                        distance[j] = min + m[next][j];
                    }
                }
            }
        }
        for(int i = 0; i < size; i++){
            if(distance[i] == 9999){
                distance[i] = -1;
            }
        }
        return distance;
    }
}
