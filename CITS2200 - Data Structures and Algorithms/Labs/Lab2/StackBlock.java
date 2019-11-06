import CITS2200.*;
/**
 * Lab 2
 * @author Julian
 */
public class StackBlock implements Stack
{   
    private Object[] block; // initialize the array
    private int size; // initialize the size
    private int max; // initialize the maximum stack
    
    /**
     * Constructor for StackBlock
     * @param s is the size of the empty stack
     */
    public StackBlock(int s){
         block = new Object[s];
         max = block.length;
         size = 0;
    }
    
    /**
     * Returns true if the stack is empty, false otherwise
     * @return whether the stack is empty
     */
    public boolean isEmpty(){
        return size == 0;
        }
    
    /**
     * Returns true if the stack is full, false otherwise
     * @return whether the stack is full
     */
    public boolean isFull(){
        return size == max;
    }
    
    /**
     * push Object o onto the top of the stack,
     * or throw an Overflow exception if the stack is full 
     * @param x is the object pushed on the stack
     * @exception Overflow if the stack is full
     */
    public void push(Object x){
        if(isFull()){
            throw new CITS2200.Overflow("Tried to push on a full stack");
        }
        else{
            block[size++] = x;
        }
    }
    
    /**
     * return the Object on top of the stack,
     * or throw an Underflow exception if the stack is empty
     * @return the object on top of the stack
     * @exception Underflow if stack is empty
     */
    public Object examine(){
        if(isEmpty()){
            throw new CITS2200.Underflow("Tried to examine from an empty stack");
        }
        else{
            return block[size - 1];
        }
    } 
    
    /**
     * remove and return the Object on the top of the stack,
     * or throw an Underflow exception if the stack is empty
     * @return the object removed on top of the stack
     * @exception Underflow if stack is empty
     */
    public Object pop(){
        if(isEmpty()){
            throw new CITS2200.Underflow("Tried to pop from an empty stack");
        }
        else{
            return block[--size];
        }
    }
}
