import CITS2200.*;
/**
 * Lab 4
 * @author Julian
 */
public class ListLinked implements List
{
    private Link before; // initialize before
    private Link after; // initialize after    
    /**
     * Constructor for ListLinked
     */
    public ListLinked(){
        after = new Link(null, null);
        before = new Link(null, after);
    }
    
    /**
     * Return true if the list is empty, false otherwise
     * @return whether list is empty or not
     */
    public boolean isEmpty(){
        return before.successor == after;
    }
    
    /**
     * True if w is over the before first position
     * @param WindowLinked w
     * @return whether w is before first or not
     */
    public boolean isBeforeFirst(WindowLinked w){
        return w.link == before;
    }
    
    /**
     * True if w is over the after last position
     * @param WindowLinked w
     * @return whether w is after last or not
     */
    public boolean isAfterLast(WindowLinked w){
        return w.link == after;
    }
        
    /**
     * Initialises w to the before first position
     * @param WindowLinked w
     */
    public void beforeFirst(WindowLinked w){
        w.link = before;
    }
    
    /**
     * Initialises w to the after last position
     * @param WindowLinked w
     */
    public void afterLast(WindowLinked w){
        w.link = after;
    }

    /**
     * Throws an exception if w is over the after last position,
     * otherwise moves w to the next window position
     * @param WindowLinked w
     */
    public void next(WindowLinked w){
        if(!isAfterLast(w)){
            w.link = w.link.successor;
        }
        else{
            throw new CITS2200.OutOfBounds("Calling next after list end.");
        }
    }
    
    /**
     * Throws an exception if w over is the before first position,
     * otherwise moves w to the previous window position
     * @param WindowLinked w
     */
    public void previous(WindowLinked w){
        if(!isBeforeFirst(w)){
            Link current = before.successor;
            Link previous = before;
            while(current != w.link){
                previous = current;
                current = current.successor;
            }
            w.link = previous;
        }
        else{
            throw new CITS2200.OutOfBounds("Calling previous before start of list.");
        }
    }
    
    /**
     * Throws an exception if w is over the last position,
     * otherwise an extra element e is added to the list after w
     * @param Object e and WindowLinked w
     */
    public void insertAfter(Object e, WindowLinked w){
        if(!isAfterLast(w)){
            Link x = new Link(e, w.link.successor);
            w.link.successor = x;
        }
        else{
            throw new CITS2200.OutOfBounds("inserting after end of list.");
        }
    }    
        
    /**
     * Throws an exception if w is over the before first position,
     * otherwise an extra element e is added to the list before w
     * @param Object e and WindowLinked w
     */
    public void insertBefore(Object e, WindowLinked w){
        if(!isBeforeFirst(w)){
            w.link.successor = new Link(w.link.item, w.link.successor);
            if(isAfterLast(w)){
                after = w.link.successor;
                w.link.item = e;
                w.link = w.link.successor;
            }
        }
        else{
            throw new CITS2200.OutOfBounds("inserting before start of list");
        }
    }

    /**
     * Throws an exception if w is in the before first or after last position,
     * otherwise returns the element under w
     * @param WindowLinked w
     * @return the element under w
     */
    public Object examine(WindowLinked w){
        if(!isAfterLast(w) && !isBeforeFirst(w)){
            return w.link.item;
        }
        else{
            throw new CITS2200.OutOfBounds("Cannot examine.");
        }
    }  
    
    /**
     * Throws an exception if w is in the before first or after last position,
     * otherwise replaces the element under w with e and returns the old element
     * @param Object e and WindowLinked w
     * @return old element
     */
    public Object replace(Object e, WindowLinked w){
        if(!isAfterLast(w) && !isBeforeFirst(w)){
            Object x = w.link.item;
            w.link.item = e;
            return x;
        }
        else{
            throw new CITS2200.OutOfBounds("Cannot replace.");
        }
    }
   
    /**
     * Throws an exception if w is in the before first or after last position.
     * otherwise deletes and returns the element under w,
     * and places w over the next element
     */
    public Object delete(WindowLinked w){
        if(!isAfterLast(w) && !isBeforeFirst(w)){  
            if(w.link.successor == after){
                after = w.link;
                return w.link.item;                
            }            
            Object x = w.link.item;
            w.link.item = w.link.successor.item;
            w.link.successor = w.link.successor.successor;
            return x;           
        }
        else{
            throw new CITS2200.OutOfBounds("Cannot delete.");
        }
    }
}

