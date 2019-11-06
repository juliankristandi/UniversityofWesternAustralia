import java.util.*;
public class KnapsackImp implements Knapsack{
    public class Items implements Comparable<Items>{
        double valueWeight;
        int index;
        public Items(double valueWeight, int index){ //Link the valueWeight and index.
            this.valueWeight = valueWeight;
            this.index = index;
        }
        @Override //Override function to be able to sort.
        public int compareTo(Items x) {
            if (this.valueWeight < x.valueWeight) {
                return -1;
            }
            else if (this.valueWeight == x.valueWeight) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
    public int fractionalKnapsack(int[] weights, int[] values, int capacity) {
        int length = weights.length;
        Items[] itemList = new Items[length];
        for (int i = 0; i < length; i++){ //construct itemList
            double divide = (double) values[i] / weights[i];
            itemList[i] = new Items(divide, i);
        }
        Arrays.sort(itemList, Collections.reverseOrder()); //sort descending order based on value/weight.
        double total = 0.0;
        for (int x = 0; x < length; x++) {        
            if (capacity - weights[itemList[x].index] >= 0) {
                capacity = capacity - weights[itemList[x].index];
                total = total + values[itemList[x].index];
            }
            else {
                total = total + ((double) capacity / weights[itemList[x].index]) * values[itemList[x].index];
                capacity = 0;
                break;
            }
        }
        return (int)total;
    }
    
    public int discreteKnapsack(int[] weights, int[] values, int capacity) {
        int length = weights.length;
        int[][] table = new int [length + 1][capacity + 1];
        for (int i = 0; i <= length; i++) {
            for (int x = 0; x <= capacity; x++) {
                if (i == 0 || x == 0) {
                    table[i][x] = 0; //initialize zeros in table.
                }
                else if (weights[i - 1] <= x) {
                    table[i][x] = Math.max(values[i - 1] + table[i - 1][x - weights[i - 1]], table[i - 1][x]); //formula as per lecture slide.
                }
                else {
                    table[i][x] = table[i - 1][x]; //out of bounds.
                }
            } 
        }
        return table[length][capacity]; //result = right bottom cell.
    }    
}
