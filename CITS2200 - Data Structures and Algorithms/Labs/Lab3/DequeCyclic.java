import CITS2200.*;
/**
 * Lab 3
 * @author Julian
 */
public class DequeCyclic implements Deque
{
    private Object[] deque; // initialize the array
    private int left; // initialize left index
    private int right; // initialize right index
    private int size; // initialize the size
    private int max; // initialize the max
    /**
     * Create an empty deque of size s
     * @param size of empty deque
     */
    public DequeCyclic(int s){
        deque = new Object[s];
        left = 0;
        right = deque.length - 1;
        size = 0;
        max = deque.length;
    }
    
    /**
     * Return true if the deque is empty, false otherwise
     * @return whether deque is empty
     */
    public boolean isEmpty(){
        return size == 0;
    }
    
    /**
     * Return true if deque is full, false otherwise
     * @return wheter deque is full
     */
    public boolean isFull(){
        return size == max;
    }
    
    /**
     * Add object c as the left-most object in the deque,
     * or throw an Overflow exception if the deque is full
     * @param c object being added to the left
     * @exception Overflow if deque is full
     */
    public void pushLeft(Object c){
        if(isFull()){
            throw new CITS2200.Overflow("Deque is full");
        }
        else if(deque[left] == null){
            size++;
            deque[left] = c;
        }
        else{
            size++;
            int i = 0;
            int x = 0;
            Object a = null;
            while(i <= deque.length - 1 && x == 0 ){
                if(deque[i] == null){
                    while(i > 0){
                        deque[i] = deque[i - 1];
                        deque[i - 1] = null;
                        i--;
                        x = 1;
                    }
                }
                i++;
            }
            deque[left] = c;
        }
    }
    
    /**
     * Add object c as the right-most object in the deque,
     * or throw an Overflow exception if the deque is full
     * @param c object being added to the right
     * @exception Overflow if deque
     */
    public void pushRight(Object c){
        if(isFull()){
            throw new CITS2200.Overflow("Deque is full");
        }
        else if(deque[right] == null){
            size++;
            deque[right] = c;
        }
        else{
            size++;
            int i = deque.length - 1;
            int x = 0;
            Object a = null;
            while(i >= 0 && x == 0){
                if(deque[i] == null){
                    while(i < deque.length - 1){
                        deque[i] = deque[i + 1];
                        deque[i + 1] = null;
                        i++;
                        x = 1;
                    }
                }
                i--;
            }
            deque[right] = c;
        }
    }
    
    /**
     * Return the left-most object in the deque,
     * or throw an Underflow exception if the deque is empty
     * @return left-most object in deque
     * @exception Underflow is deque is empty
     */
    public Object peekLeft(){
        if(isEmpty()){
            throw new CITS2200.Underflow("Deque is empty");
        }
        else{
            int i = 0;
            Object a = null;
            while(i < deque.length && a == null){
                if(deque[i] != null){
                    a = deque[i];
                }
                i++;
            }
            return a;
        }
    }
    
    /**
     * Return the right-most object in the deque,
     * or throw an Underflow exception if the deque is empty
     * @return right-most object in deque
     * @exception Underflow if deque is empty
     */
    public Object peekRight(){
        if(isEmpty()){
            throw new CITS2200.Underflow("Deque is empty");
        }
        else{
            int i = right;
            Object a = null;
            while(i >= 0 && a == null){
                if(deque[i] != null){
                    a = deque[i];
                }
                i--;
            }
            return a;
        }
    }
    
    /**
     * Remove and return the left-most object in the deque,
     * or throw an Underflow exception if the deque is empty
     * @return left-most object being removed
     * @exception Underflow if deque is empty
     */
    public Object popLeft(){
        if(isEmpty()){
            throw new CITS2200.Underflow("Deque is empty");
        }
        else{
            int i = 0;
            Object a = null;
            while(i < deque.length && a == null){
                if(deque[i] != null){
                    a = deque[i];
                }
                i++;
            }
            i--;
            deque[i] = null;
            size--;
            return a;
        }
    }
    
    
    /**
     * Remove and return the right-most object in the deque,
     * or throw an Underflow exception if the deque is empty
     * @return right-most object being removed
     * @exception Underflow if deque is empty
     */
    public Object popRight(){
        if(isEmpty()){
            throw new CITS2200.Underflow("Deque is empty");
        }
        else{
            int i = right;
            Object a = null;
            while(i >= 0 && a == null){
                if(deque[i] != null){
                    a = deque[i];
                }
                i--;
            }
            i++;
            deque[i] = null;
            size--;
            return a;
        }
    }
}
