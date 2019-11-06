import java.util.*;
import java.io.*;
import static java.lang.Math.pow;
public class Project
{
    String file;
    int size = 0;
    Set<Integer> set;
    ArrayList<Integer> arraylist = new ArrayList<Integer>();
    List<Integer> list;
    public Project(){}
    
    public void main(String fileName){
        try{   
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNextInt()){
                arraylist.add(scanner.nextInt());
            }
            set = new HashSet<>(arraylist);
            list = new ArrayList<Integer>(set);
            size = set.size();
            file = fileName;
        }
        catch(Exception error){
            System.out.println("File not found.");
        }
    }
    
    public class Graph{
        int size;
        int[][] matrix;
        public Graph(int size){
            this.size = size;
            matrix = new int[size][size];
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        public void addEdge(int first, int second){
            matrix[first][second] = 1;
            matrix[second][first] = 1;
        }
        
        public boolean isNeighbor(int vertex, int neighbor){
            return matrix[vertex][neighbor] == 1;
        }
    }
    
    private List<Integer> BFS(int a, Graph graph, boolean[] gcheck){           
        int[] x = new int[size];
        for(int i = 0; i < size; i++){
            x[i] = -1; 
        }        
        Queue<Integer> l = new LinkedList<Integer>();
        l.add(a);
        gcheck[a] = true;
        while(!l.isEmpty()){
            int y = l.remove();
            for(int i = 0; i < size; i++){
                if(gcheck[i] == false && graph.matrix[y][i] != 0){
                    x[i] = y;
                    l.add(i);
                    gcheck[i] = true;
                }
            }
        }
        List<Integer> sp = new ArrayList<>(); 
        if(gcheck[a] == false){
           List<Integer> shortestPath = new ArrayList<>();
           int node = x[a];
           while(node != -1){
               shortestPath.add(node);
               node = x[node];
           }
           sp = shortestPath;
        }
        return sp;
    }    
    
    public void DegreeCentrality(){
        // Graph graph = new Graph(size);  
        // List<Integer> dclist = new ArrayList<>();
        // Set<Integer> dcset = new HashSet<Integer>();
        // for(int i = 0; i < arraylist.size() - 1; i = i + 2){ 
            // graph.addEdge(list.indexOf(arraylist.get(i)), list.indexOf(arraylist.get(i + 1)));
        // }        
        // System.out.println("Degree Centrality - Component 1:");
        // Degree(set);        
        // boolean[] gcheck = new boolean[size];
        // for(int i = 0; i < size; i++){
            // gcheck[i] = false;
        // }      
        // for(int i = 0; i < size; i++){
            // if(i == 0){
                // dclist = BFS(i, graph, gcheck);
            // }            
            // else if(gcheck[i] == false){
                // dclist = BFS(i, graph, gcheck);
                // for(int a : dclist){
                    // dcset.add(a);
                // }
                // System.out.println("Degree Centrality - Other Components:");               
                // Degree(dcset);
            // }
        // }   
        // }
        try{
            int count = 0;
            int i = 0;
            int counts[] = new int[size];
            for(int node : set){
                Scanner degreescan = new Scanner(new File(file));                
                while(degreescan.hasNextInt()){
                    if(degreescan.nextInt() == node){
                        count = count + 1;
                    }
                }
                counts[i] = count;
                i++;
                count = 0;
            }
            long one = Integer.MIN_VALUE;
            int one_node = 0;
            long two = Integer.MIN_VALUE;
            int two_node = 0;
            long three = Integer.MIN_VALUE;
            int three_node = 0;
            long four = Integer.MIN_VALUE;
            int four_node = 0;
            long five = Integer.MIN_VALUE;
            int five_node = 0;                        
            for(int j = 0; j < size; j++){
                if(counts[j] > one){
                    five = four;
                    four = three; 
                    three = two; 
                    two = one;
                    one = counts[j];
                    five_node = four_node;
                    four_node = three_node; 
                    three_node = two_node; 
                    two_node = one_node;
                    one_node = j;
                }
                else if(counts[j] > two){
                    five = four;
                    four = three; 
                    three = two;
                    two = counts[j];
                    five_node = four_node;
                    four_node = three_node; 
                    three_node = two_node;
                    two_node = j;                
                }
                else if(counts[j] > three){
                    five = four;
                    four = three; 
                    three = counts[j];
                    five_node = four_node;
                    four_node = three_node; 
                    three_node = j;                
                }
                else if(counts[j] >four){
                    five = four;
                    four = counts[j];
                    five_node = four_node;
                    four_node = j;                
                }     
                else if(counts[j] > five){
                    five = counts[j];
                    five_node = j;
                }            
            }
            System.out.println("Degree Centrality - Component 1:");
            System.out.println(list.get(one_node));
            System.out.println(list.get(two_node));
            System.out.println(list.get(three_node));
            System.out.println(list.get(four_node));
            System.out.println(list.get(five_node));
        }
        catch(Exception e){
        }     
    }
    
    // private void Degree(Set<Integer> n){
        // Graph graph = new Graph(size);
        // for(int i = 0; i < arraylist.size() - 1; i = i + 2){ 
            // graph.addEdge(list.indexOf(arraylist.get(i)), list.indexOf(arraylist.get(i + 1)));
        // }
        // //List<Integer> newlist = new ArrayList<Integer>(n); 
        // int count = 0;
        // int counts[] = new int[size];
        // for(int node : n){            
            // if(n == set){
                // node = list.indexOf(node);
            // }            
            // for(int j = 0; j < size; j++){
                // if(graph.isNeighbor(node, j)){
                    // count = count + 1;
                // }
            // }
            // counts[node] = count;
        // }
        // long one = Integer.MIN_VALUE;
        // int one_node = 0;
        // long two = Integer.MIN_VALUE;
        // int two_node = 0;
        // long three = Integer.MIN_VALUE;
        // int three_node = 0;
        // long four = Integer.MIN_VALUE;
        // int four_node = 0;
        // long five = Integer.MIN_VALUE;
        // int five_node = 0;
        // for(int i = 0; i < size; i++){
            // if(counts[i] > one){
                // five = four;
                // four = three; 
                // three = two; 
                // two = one;
                // one = counts[i];
                // five_node = four_node;
                // four_node = three_node; 
                // three_node = two_node; 
                // two_node = one_node;
                // one_node = i;
            // }
            // else if(counts[i] > two){
                // five = four;
                // four = three; 
                // three = two;
                // two = counts[i];
                // five_node = four_node;
                // four_node = three_node; 
                // three_node = two_node;
                // two_node = i;                
            // }
            // else if(counts[i] > three){
                // five = four;
                // four = three; 
                // three = counts[i];
                // five_node = four_node;
                // four_node = three_node; 
                // three_node = i;                
            // }
            // else if(counts[i] > four){
                // five = four;
                // four = counts[i];
                // five_node = four_node;
                // four_node = i;                
            // }     
            // else if(counts[i] > five){
                // five = counts[i];
                // five_node = i;
            // }            
        // }
        // System.out.println(list.get(one_node));
        // System.out.println(list.get(two_node));
        // System.out.println(list.get(three_node));
        // System.out.println(list.get(four_node));
        // System.out.println(list.get(five_node));
        // // System.out.println(newlist.get(one_node));
        // // System.out.println(newlist.get(two_node));
        // // System.out.println(newlist.get(three_node));
        // // System.out.println(newlist.get(four_node));
        // // System.out.println(newlist.get(five_node));      
    // }    
    
    public void ClosenessCentrality(){
        Graph graph = new Graph(size);  
        List<Integer> dclist = new ArrayList<>();
        Set<Integer> dcset = new HashSet<Integer>();
        for(int i = 0; i < arraylist.size() - 1; i = i + 2){ 
            graph.addEdge(list.indexOf(arraylist.get(i)), list.indexOf(arraylist.get(i + 1)));
        }        
        System.out.println("Closeness Centrality - Component 1:");
        Closeness(set);        
        boolean[] gcheck = new boolean[size];
        for(int i = 0; i < size; i++){
            gcheck[i] = false;
        }      
        for(int i = 0; i < size; i++){
            if(i == 0){
                dclist = BFS(i, graph, gcheck);
            }            
            else if(gcheck[i] == false){
                dclist = BFS(i, graph, gcheck);
                for(int a : dclist){
                    dcset.add(a);
                }
                System.out.println("Closeness Centrality - Other Components:");               
                Closeness(dcset);
            }
        }   
    }
    
    private void Closeness(Set<Integer> n){
        Graph graph = new Graph(size);  
        for(int i = 0; i < arraylist.size() - 1; i = i + 2){ 
            graph.addEdge(list.indexOf(arraylist.get(i)), list.indexOf(arraylist.get(i + 1)));
        }          
        //List<Integer> newlist = new ArrayList<Integer>(n);        
        boolean[] check = new boolean[size];
        int min = 999;
        int next = 0;
        long[] closeness = new long[size];
        int[] distance = new int[size];
        for(int node : n){
            for(int i = 0 ; i < size; i++){
                check[i] = false;
                for(int j = 0; j < size; j++){
                    if(graph.matrix[i][j] == 0){
                        graph.matrix[i][j] = 999;
                    }
                }
            }        
            int totaldistance = 0;
            if(n == set){
                node = list.indexOf(node);
            }
            distance = graph.matrix[node];
            distance[node] = 0;
            check[node] = true;
            for(int x = 0; x < size; x++){
                min = 999;
                for(int i = 0; i < size; i++){
                    if(check[i] == false && min > distance[i]){
                        min = distance[i];
                        next = i;
                    }
                }
                check[next] = true;
                for(int j = 0; j < size; j++){
                    if(check[j] == false){
                        if(distance[j] > (min + graph.matrix[next][j])){
                            distance[j] = min + graph.matrix[next][j];
                        }
                    }
                }
            }
            for(int i = 0; i < size; i++){
                totaldistance += distance[i];
            }
            closeness[node] = totaldistance;
        }
        long one = Integer.MAX_VALUE;
        int one_node = 0;
        long two = Integer.MAX_VALUE;
        int two_node = 0;
        long three = Integer.MAX_VALUE;
        int three_node = 0;
        long four = Integer.MAX_VALUE;
        int four_node = 0;
        long five = Integer.MAX_VALUE;
        int five_node = 0;
        for(int i = 0; i < size; i++){
            if(closeness[i] < one){
                five = four;
                four = three; 
                three = two; 
                two = one;
                one = closeness[i];
                five_node = four_node;
                four_node = three_node; 
                three_node = two_node; 
                two_node = one_node;
                one_node = i;
            }
            else if(closeness[i] < two){
                five = four;
                four = three; 
                three = two;
                two = closeness[i];
                five_node = four_node;
                four_node = three_node; 
                three_node = two_node;
                two_node = i;                
            }
            else if(closeness[i] < three){
                five = four;
                four = three; 
                three = closeness[i];
                five_node = four_node;
                four_node = three_node; 
                three_node = i;                
            }
            else if(closeness[i] < four){
                five = four;
                four = closeness[i];
                five_node = four_node;
                four_node = i;                
            }     
            else if(closeness[i] < five){
                five = closeness[i];
                five_node = i;
            }            
        }
        System.out.println(list.get(one_node));
        System.out.println(list.get(two_node));
        System.out.println(list.get(three_node));
        System.out.println(list.get(four_node));
        System.out.println(list.get(five_node));
        // System.out.println(newlist.get(one_node));
        // System.out.println(newlist.get(two_node));
        // System.out.println(newlist.get(three_node));
        // System.out.println(newlist.get(four_node));
        // System.out.println(newlist.get(five_node));        
    }
    
    public void BetweennessCentrality(){ 
        Graph graph = new Graph(size);  
        List<Integer> dclist = new ArrayList<>();
        Set<Integer> dcset = new HashSet<Integer>();
        for(int i = 0; i < arraylist.size() - 1; i = i + 2){ 
            graph.addEdge(list.indexOf(arraylist.get(i)), list.indexOf(arraylist.get(i + 1)));
        }        
        System.out.println("Betweenness Centrality - Component 1:");
        Betweenness(set);        
        boolean[] gcheck = new boolean[size];
        for(int i = 0; i < size; i++){
            gcheck[i] = false;
        }      
        for(int i = 0; i < size; i++){
            if(i == 0){
                dclist = BFS(i, graph, gcheck);
            }            
            else if(gcheck[i] == false){
                dclist = BFS(i, graph, gcheck);
                for(int a : dclist){
                    dcset.add(a);
                }
                System.out.println("Betweenness Centrality - Other Components:");               
                Betweenness(dcset);
            }
        }          
    }
    
    private void Betweenness(Set<Integer> n){
        Graph graph = new Graph(size);
        for(int i = 0; i < arraylist.size() - 1; i = i + 2){ 
            graph.addEdge(list.indexOf(arraylist.get(i)), list.indexOf(arraylist.get(i + 1)));
        }         
        //List<Integer> newlist = new ArrayList<Integer>(n);
        int bctotal[] = new int[size];        
        for(int node : n){
            for(int target : n){
                if(target == node){
                    continue;
                }  
                if(n == set){                        
                    node = list.indexOf(node);
                    target = list.indexOf(target);
                }                  
                int bc[] = new int[size]; // start here  
                bc[node] = 0;                   
                for(int s : n){
                    if(n == set){
                        s = list.indexOf(s);
                    }
                    if(s == target || s == node){
                        continue;
                    }                    
                    Stack<Integer> S = new Stack<Integer>();
                    int P[] = new int[size];
                    int ww = 0;
                    int o[] = new int[size];
                    int d[] = new int[size];
                    o[target] = 0;
                    o[s] = 1;
                    d[target] = -1;
                    d[s] = 0;
                    Queue<Integer> Q = new LinkedList<Integer>();
                    Q.add(s);
                    while(!Q.isEmpty()){
                        Q.remove(node);
                        S.push(node);
                        for(int w : n){                            
                            if(n == set){
                                w = list.indexOf(w);
                            }
                            if(graph.isNeighbor(node, w)){
                                if(d[w] < 0){
                                    Q.add(w);
                                    d[w] = d[node] + 1;
                                    ww = w;
                                }
                                if(d[w] == d[node] + 1){
                                    o[w] = o[w] = o[node];
                                    P[w] = node;
                                    ww = w;
                                }                            
                            }
                        }
                    }
                    int D[] = new int[size];
                    D[node] = 0;
                    while(!S.isEmpty()){
                        ww = S.pop();
                        for(int v : P){
                            D[node] = D[node] + ((o[node] / o[ww]) * (1 + D[ww]));
                        }
                            if(ww != s){
                            bc[ww] = bc[ww] + D[ww];
                        }                    
                    }
                }
                bctotal = bc;
            }
        }
        long one = Integer.MIN_VALUE;
        int one_node = 0;
        long two = Integer.MIN_VALUE;
        int two_node = 0;
        long three = Integer.MIN_VALUE;
        int three_node = 0;
        long four = Integer.MIN_VALUE;
        int four_node = 0;
        long five = Integer.MIN_VALUE;
        int five_node = 0;
        for(int i = 0; i < size; i++){
            if(bctotal[i] > one){
                five = four;
                four = three; 
                three = two; 
                two = one;
                one = bctotal[i];
                five_node = four_node;
                four_node = three_node; 
                three_node = two_node; 
                two_node = one_node;
                one_node = i;
            }
            else if(bctotal[i] > two){
                five = four;
                four = three; 
                three = two;
                two = bctotal[i];
                five_node = four_node;
                four_node = three_node; 
                three_node = two_node;
                two_node = i;                
            }
            else if(bctotal[i] > three){
                five = four;
                four = three; 
                three = bctotal[i];
                five_node = four_node;
                four_node = three_node; 
                three_node = i;                
            }
            else if(bctotal[i] >four){
                five = four;
                four = bctotal[i];
                five_node = four_node;
                four_node = i;                
            }     
            else if(bctotal[i] > five){
                five = bctotal[i];
                five_node = i;
            }            
        }
        System.out.println(list.get(one_node));
        System.out.println(list.get(two_node));
        System.out.println(list.get(three_node));
        System.out.println(list.get(four_node));
        System.out.println(list.get(five_node));
        // System.out.println(newlist.get(one_node));
        // System.out.println(newlist.get(two_node));
        // System.out.println(newlist.get(three_node));
        // System.out.println(newlist.get(four_node));
        // System.out.println(newlist.get(five_node));       
    }
    
    public void KatzCentrality(double alpha){
        Graph graph = new Graph(size);  
        List<Integer> dclist = new ArrayList<>();
        Set<Integer> dcset = new HashSet<Integer>();
        for(int i = 0; i < arraylist.size() - 1; i = i + 2){ 
            graph.addEdge(list.indexOf(arraylist.get(i)), list.indexOf(arraylist.get(i + 1)));
        }        
        System.out.println("Katz Centrality - Component 1:");
        Katz(set, alpha);        
        boolean[] gcheck = new boolean[size];
        for(int i = 0; i < size; i++){
            gcheck[i] = false;
        }      
        for(int i = 0; i < size; i++){
            if(i == 0){
                dclist = BFS(i, graph, gcheck);
            }            
            else if(gcheck[i] == false){
                dclist = BFS(i, graph, gcheck);
                for(int a : dclist){
                    dcset.add(a);
                }
                System.out.println("Katz Centrality - Other Components:");               
                Katz(dcset, alpha);
            }
        }            
    } 
    
    private void Katz(Set<Integer> n, double a){        
        double katzarray[] = new double[size];
        int neighborslevelone = 0;
        int neighborsleveltwo = 0;
        int neighborslevelthree = 0;
        double hop = 0.0;
        //List<Integer> newlist = new ArrayList<Integer>(n);
        Graph graph = new Graph(size);
        for(int i = 0; i < arraylist.size() - 1; i = i + 2){ 
           graph.addEdge(list.indexOf(arraylist.get(i)), list.indexOf(arraylist.get(i + 1)));
        }        
        for(int node : n){
            double katztotal = 0.0;
            if(n == set){
                node = list.indexOf(node);
            }        
            for(int i = 0; i < size; i++){
                if(graph.isNeighbor(node,i)){
                    neighborslevelone = neighborslevelone + 1;
                    hop = 1.0;                    
                    for(int j = 0; j < size; j++){
                        if(graph.isNeighbor(i, j)){
                            neighborsleveltwo = neighborsleveltwo + 1;
                            hop = 2.0;
                            for(int k = 0; k < size; k++){
                                if(graph.isNeighbor(j, k)){
                                    neighborslevelthree = neighborslevelthree + 1;
                                    hop = 3.0;
                                }
                            }                             
                            katztotal = katztotal + neighborslevelthree * Math.pow(a, hop);
                            neighborslevelthree = 0;
                        }
                    }                    
                    katztotal = katztotal + neighborsleveltwo * Math.pow(a, hop);
                    neighborsleveltwo = 0;
                }
            }
            katztotal = katztotal + neighborslevelone * Math.pow(a, hop);
            neighborslevelone = 0;
            katzarray[node] = katztotal;
        }
        double one = Integer.MIN_VALUE;
        int one_node = 0;
        double two = Integer.MIN_VALUE;
        int two_node = 0;
        double three = Integer.MIN_VALUE;
        int three_node = 0;
        double four = Integer.MIN_VALUE;
        int four_node = 0;
        double five = Integer.MIN_VALUE;
        int five_node = 0;
        for(int x = 0; x < size; x++){
            if(katzarray[x] > one){
                five = four;
                four = three; 
                three = two; 
                two = one;
                one = katzarray[x];
                five_node = four_node;
                four_node = three_node; 
                three_node = two_node; 
                two_node = one_node;
                one_node = x;
            }
            else if(katzarray[x] > two){
                five = four;
                four = three; 
                three = two;
                two = katzarray[x];
                five_node = four_node;
                four_node = three_node; 
                three_node = two_node;
                two_node = x;                
            }
            else if(katzarray[x] > three){
                five = four;
                four = three; 
                three = katzarray[x];
                five_node = four_node;
                four_node = three_node; 
                three_node = x;                
            }
            else if(katzarray[x] > four){
                five = four;
                four = katzarray[x];
                five_node = four_node;
                four_node = x;                
            }     
            else if(katzarray[x] > five){
                five = katzarray[x];
                five_node = x;
            }            
        }
        System.out.println(list.get(one_node));
        System.out.println(list.get(two_node));
        System.out.println(list.get(three_node));
        System.out.println(list.get(four_node));
        System.out.println(list.get(five_node));
        // System.out.println(newlist.get(one_node));
        // System.out.println(newlist.get(two_node));
        // System.out.println(newlist.get(three_node));
        // System.out.println(newlist.get(four_node));
        // System.out.println(newlist.get(five_node));
    }    
}
