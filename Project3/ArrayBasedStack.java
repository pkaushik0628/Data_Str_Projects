import java.util.Arrays;

/**
 * The class describes an array based stack of generic type, with basic features like add(), peek(), pop(), clear(), and toString().
 *
 * @author Padmanabh Kaishik
 * @version 5/5/2024
 */
public class ArrayBasedStack<E>
{
    // instance variables
    private Object[] array;
    private int size;
    private int capacity;

    /**
     * Constructor for objects of class ArrayBasedStack
     * @param k capacity of the array based stack
     */
    public ArrayBasedStack(int k)
    {
        array = new Object[k]; 
        size = 0;
        capacity  = k;
    }

    /**
     * Adds an item to the array based stack
     * @param item item to be added to the stack
     */
    public void add(E item){
        if(size < capacity && item != null){
            array[size] = item;
            size++;
        }
    }

    /**
     * Expans the array and adds an item to the stack
     * @param item item to be added to the stack
     */
    public void addExpandable(E item){
        if(size < capacity){
            array[size] = item;
            size++;
        }
        else if(size == capacity){
            Object[] arrayNew = (E[]) new Object[2*capacity];
            for(int i = 0; i< array.length; i++){
                arrayNew[i] = array[i];
            }
            array = arrayNew;
            capacity = 2*capacity;
            array[size] = item;
            size++;
        }
    }

    /**
     * Returns the item at the top of the stack
     * @return item at the top of the stack
     */
    public Object peek(){
        if(size - 1>= 0){
            return array[size-1];
        }
        return null;
    }

    /**
     * Returns and remove sthe item at the top of the stack
     * @return item at the top of the stack
     */
    public Object pop(){
        if(size - 1>= 0){
            Object temp = array[size-1];
            array[size - 1] = null;
            size--;
            return temp;
        }
        return null;
    }

    /**
     * Peeks at an item at the bottom of the stack
     * @return item at the bottom of the stack
     */
    public Object peekAtBack(){
        return array[0];
    }

    
    /**
     * Returns and removes an item at the bottom of the stack, resizes all other items of the syack
     */
    public Object popAtBack(){
        Object temp = array[0];
        Object[] newArr = (E[]) new Object[capacity];
        for(int i = 1; i<array.length; i++){
            newArr[i-1] = array[i];
        }
        array = newArr;
        return temp;
    }

    /**
     * Gives a tring expression of the array based stack
     * @return string string expression for the stack
     */
    @Override
    public String toString(){
        StringBuilder line = new StringBuilder();
        for(int i = 0; i<array.length; i++){
            if(array[i] != null){
                line.append(array[i]);
            }
            else{
                line.append("-");
            }
            if(i+1 != capacity){
                line.append(", "); 
            }
        }
        return line.toString();
    }

    /**
     * Clears all items from the stack
     */
    public void clear(){
        for(int i = 0; i<array.length; i++){
            array[i] = null;
        }
    }

    
    /**
     * Returns true if the stack is full, else return alse
     * @return bool a boolean depending upon whether the stack is full or not
     */
    public boolean isFull(){
        if(size == capacity){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Returns the internal array of the stack
     * @return array internal array of the stack
     */
    public Object[] getArray(){
        return array;// Return the new array
    }

}
