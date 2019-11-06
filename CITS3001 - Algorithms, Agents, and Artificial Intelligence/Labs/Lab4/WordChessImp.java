import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
public class WordChessImp implements WordChess {
    /**
    * Finds a shortest sequence of words in the dictionary such that the first word is the startWord, 
    * the last word is the endWord, and each word is equal to the previous word with one letter changed.
    * All words in the sequence are the same length. If no sequence is possible, an empty array is returned.
    * It is assumed that both startWord and endWord are elements of the dictionary.
    * @param dictionary The set of words that can be used in the sequence; all words in the dictionary are capitalised.
    * @param startWord the first word on the sequence.
    * @param endWord the last word in the sequence.
    * @return an array containing a shortest sequence from startWord to endWord, in order, 
    * using only words from the dictionary that differ by a single character.
    **/
    public String[] findPath(String[] dictionary, String startWord, String endWord){
        HashMap<String, String> dict = new HashMap<String, String>();
	HashSet<String> newDict = new HashSet<String>(Arrays.asList(dictionary));
        ArrayList<String> tempresult = new ArrayList<String>(); 
        LinkedHashSet<String> visited = new LinkedHashSet<String>();
        visited.add(startWord);
        LinkedList<String> queue = new LinkedList<String>();
        queue.push(startWord);
        boolean found = false;
        while(!queue.isEmpty() && !found) {
            String temp = queue.poll();
            for(int i = 0; i < startWord.length(); i++){
                for(char x = 'A'; x <= 'Z'; x++) {
                    StringBuilder words = new StringBuilder(temp);
                    words.setCharAt(i, x);
                    String word = words.toString();
                    if(visited.contains(word)){
                        continue;
                    }
                    if(word.equals(endWord)){
                        found = true;
                    }
                    if(newDict.contains(word)){
                        queue.add(word);
                        visited.add(word);
                        dict.put(word, temp);
                    }
                }
            }
        }
        if(!found){
            String[] error = new String[0];
            return error;
        }
        String last = endWord;
        while(!last.equals(startWord)){
            tempresult.add(last);
            last = dict.get(last);
        }
        tempresult.add(last);
        Collections.reverse(tempresult);
        String[] result = new String[tempresult.size()];
        return tempresult.toArray(result);                    
    }    
    
    // /**
    // * A binary search function to search if a word is in a 'dictionary' array.
    // * @param word the word to search for in the dictionary.
    // * @param dict the dictionary being used.
    // * @return true of false whether the word is within the dictionary.
    // **/    
    // public boolean binarySearch(String word, String[] dict){
        // int left = 0;
        // int right = dict.length - 1;
        // while(left <= right) {
            // int mid = 1 + (right - 1) / 2;
            // if (word.compareTo(dict[mid]) < 0) {
                // right = mid - 1;
            // }
            // else if (word.compareTo(dict[mid]) > 0) {
                // left = mid + 1;
            // }
            // else {
                // return true;
            // }
        // }
        // return false;
    // }
    
    // /**
    // * Finds a shortest sequence of words in the dictionary such that the first word is the startWord, 
    // * the last word is the endWord, and each word is equal to the previous word with one letter changed.
    // * All words in the sequence are the same length. If no sequence is possible, an empty array is returned.
    // * It is assumed that both startWord and endWord are elements of the dictionary.
    // * @param dictionary The set of words that can be used in the sequence; all words in the dictionary are capitalised.
    // * @param startWord the first word on the sequence.
    // * @param endWord the last word in the sequence.
    // * @return an array containing a shortest sequence from startWord to endWord, in order, 
    // * using only words from the dictionary that differ by a single character.
    // **/
    // public String[] xfindPath(String[] dictionary, String startWord, String endWord){
        // ArrayList<String> tempresult = new ArrayList<String>(); //arraylist to contain word chess list
        // tempresult.add(startWord);
        
        // LinkedList<String> queue = new LinkedList<String>(); //queue to store words being examined
        // queue.push(startWord);

        // ArrayList<String> words = new ArrayList<String>(); //arraylist containing 'neighbouring' words

        // String temp;
        // String word;
        // boolean found = false;
        
        // while (!queue.isEmpty() && !found){ //main loop
            // temp = queue.pop();
            
            // words = wordList(temp, dictionary);
            // int size = words.size();
            
            // for (int i = 0; i < size; i++) {                
                // word = words.get(i);
                // if(!tempresult.contains(word)) {
                    // queue.push(word);
                    // tempresult.add(word);
                    // if(words.get(i) == endWord){
                        // found = true;
                        // break;
                    // }
                // }
            // }
        // }
        
        // if (!found) {
            // String[] error = new String[0];
            // return error;
        // }
        
        // String[] result = new String[tempresult.size()];
        // return tempresult.toArray(result);                            
    // }

    // /**
    // * Function used to check whether two strings are 'neighbours' with each other, meaning that only one character
    // * difference exists between them.
    // * @param a First string to compare.
    // * @param b Second string to compare against.
    // * @return true or false whether the only have one character difference.
    // **/    
    // public boolean neighbour(String a, String b) {
        // int count = 0;
        // for (int i = 0; i < a.length(); i++) {
            // if(a.charAt(i) != b.charAt(i)){
                // count++;
            // }
            // if (count > 1) {
                // return false;
            // }
        // }
        // return true;
    // }

    // /**
    // * Function used to build a list of 'neighbours' from a word.
    // * @param word word to check.
    // * @param dict dictionary to search for.
    // * @return arraylist containing all neighbouring words
    // **/        
    // public ArrayList<String> wordList(String word, String[] dict) {
        // int length = word.length();
        // ArrayList<String> list = new ArrayList<String>();
        // StringBuilder asd = new StringBuilder(word);
        // ArrayList<String> dictionary = new ArrayList<String>(Arrays.asList(dict));
        // for(int i = 0; i < length; i++){
            // for(char x = 'A'; x <= 'Z'; x++) { 
                // asd.setCharAt(i, x);
                // if (asd.equals(word)){
                    // continue;
                // }
                // else if (binarySearch(asd.toString(), dict)){
                    // list.add(asd.toString());
                // }
            // }
        // }
        // return list;
    // }        
}

