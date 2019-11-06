import CITS2200.*;
import java.util.*;
/**
 * Lab 5
 * @author Julian
 */
public class BinTree<E> extends CITS2200.BinaryTree<E>
{
    /**
     * Constructor
     */
    public BinTree(){
        super();
    }
    
    /** 
     * Constructor
     * @param E item, BinaryTree b1, BinaryTree b2
     */  
    public BinTree(E item, BinaryTree b1, BinaryTree b2){
        super(item,b1,b2);
    }
    
    /**
     * Override the equals method that all objects have and 
     * return true if both binary trees have exactly the same structure.
     * @param Object x
     */
    public boolean equals(Object x){
        if(x == null){ 
            return false; 
        }
        else if(this == x){
            return true;
        }
        else if(!(x instanceof BinaryTree)){
            return false;
        }
        else if(this.isEmpty() && ((BinaryTree)x).isEmpty()){
            return true;
        }
        else if(this.isEmpty() && !((BinaryTree)x).isEmpty()){
            return false;
        }
        else if(!this.isEmpty() && ((BinaryTree)x).isEmpty()){
            return false;
        }
        else if(this.getItem().equals(((BinaryTree)x).getItem())){
            return this.getLeft().equals(((BinaryTree)x).getLeft()) &&
            this.getRight().equals(((BinaryTree)x).getRight());
        }
        else if(this.getLeft() == null){
            return false;
        }
        else if(this.getRight() == null){        
            return false;
        }
        else{
            return false;
        }
    }
    
    /**
     * Provides an instance of CITS2200.Iterator that 
     * returns every element stored in the tree exactly once.
     */
    public CITS2200.Iterator<E> iterator(){
            return new BinTreeIterator(this);
    }
    
    public class BinTreeIterator implements CITS2200.Iterator,CITS2200.Queue{
    private Link first;
    private Link last;
    public BinTreeIterator(BinTree tree){
        first = new Link(tree, null);
        last = first;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public Object dequeue(){
        if(!isEmpty()){
            Object o = first.item;
            first = first.successor;
            if(isEmpty()){
                last = null;
            }
            return o;
        }
        else{
            throw new CITS2200.Underflow("Dequeing from an empty queue");
        }
    }
    
    public void enqueue(Object a){
        if(isEmpty()){
            first = new Link(a, null);
            last = first;
        }
        else{
            last.successor = new Link(a, null);
            last = last.successor;
        }
    }
    
    public boolean hasNext(){
        return(!isEmpty());
    }
    
    public Object next(){
        if(hasNext()){
            BinTree it = (BinTree)dequeue();
            if(!it.getRight().isEmpty()){
                enqueue(it.getRight());
            }
            if(!it.getLeft().isEmpty()){
                enqueue(it.getLeft());
            }
            return it.getItem();
        }
        else{
            throw new CITS2200.OutOfBounds("No next element");
        }
    }
    
    public Object examine(){
        if(!isEmpty()){
            return first.item;
        }
        else{
            throw new CITS2200.Underflow("examining empty queue");
        } 
    }
    }
}
