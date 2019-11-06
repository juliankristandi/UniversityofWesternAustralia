import CITS2200.*;
/**
 * Lab 7 
 * @author Julian
 */
public class PriorityQueueLinked implements PriorityQueue
{
    public Link front;
    /**
     * Constructor for PriorityQueueLinked
     */
    public PriorityQueueLinked()
    {
        front = null;
    }
    
    private class Link{
        Object element;
        int priority;
        Link next;
        public Link(Object e, int p, Link n){
            this.element = e;
            this.priority = p;
            this.next = n;
        }
    }
    
    /**
     * test whether the queue is empty
     * @return true if the prioirty queue is empty, false otherwise
     */
    public boolean isEmpty(){
        return front == null;
    }
    
    /**
     * examine the item at the front of the queue 
     * (the element with the highest priority that has been in the queue the longest)
     * @return first item
     * @exception Underflow if queue is empty
     */
    public Object examine(){
        if(!isEmpty()){
            return front.element;
        }
        else{
            throw new CITS2200.Underflow("Empty Queue.");
        }
    }
    
    /**
     * remove the item at the front of the queue 
     * (the element with the highest priority that has been there the longest)
     * @return removed item
     * @exception Underflow if queue is empty
     */
    public Object dequeue(){
        if(!isEmpty()){
            Object temp = front.element;
            front = front.next;
            return temp;
        }
        else{
            throw new CITS2200.Underflow("Empty Queue.");
        }
    }
    
    /**
     * insert an item at the back into the queue with a given priority
     * @param e - item to insert, p - priority of element
     */
    public void enqueue(Object e, int p){
        if(isEmpty() || p > front.priority){
            front = new Link(e, p, front);
        }
        else{
            Link l = front;
            while(l.next != null && l.next.priority >= p){
                l = l.next;
            } 
            l.next = new Link(e, p, l.next);
        }
    }
    
    /**
     * examine all the elements in the PriorityQueue
     * @return an Iterator pointing to before the first item    
     */
    public CITS2200.Iterator iterator(){
        return new Iterator();
    }
    
    private class Iterator implements CITS2200.Iterator{
        Link x;
        public Iterator(){
            x = front;
        }
    
        public boolean hasNext(){
            return x != null;
        }
    
        public Object next(){
            if(hasNext()){
                Object y = x.element;
                x = x.next;
                return y;
            }
            else{
                throw new CITS2200.OutOfBounds("No next element.");
            }
        }
    }
}
