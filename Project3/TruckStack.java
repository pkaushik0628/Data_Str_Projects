import java.util.Arrays;

/**
 * The class describes the functioning of a Truck Stack. The truck stack is initiatied by determining the size of the internal array.
 * Once the size of the array is determined, it cannot be changed. The array stores shipments. The class implements methods peek(),
 * pop(), add(), toString(), hasSpace(), getArray(), getSize(), and isFull().
 *
 * @author Padmanabh Kaushik
 * @version 5/03/2024
 */
public class TruckStack
{
    // instance variables 
    private Shipment[] array;
    private int size;
    private int capacity;

    /**
     * Constructor for objects of class ArrayBasedStack
     * @param k capacity of the array based stack
     */
    public TruckStack(int k)
    {
        array = new Shipment[k]; // Use type casting to create an array of type E
        size = 0;
        capacity  = k;
    }

    /**
     * Adds a shipment to the stack
     * @param item shipment to be added to the stack
     */
    public void add(Shipment item){
        if(size < capacity && item != null){
            array[size] = item;
            size++;
        }
    }

    /**
     * Adds an item to the stack, and expans i
     */
    private void addExpandable(Shipment item){
        if(size < capacity){
            array[size] = item;
            size++;
        }
        else if(size == capacity){
            Shipment[] arrayNew = new Shipment[2*capacity];
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
     * @retutn shipment the shipment at the top of the stack
     */
    public Shipment peek(){
        if(size-1 >=0){
            return array[size-1];
        }
        return null;
    }

    /**
     * Returns and removes the item at the top of the stack
     * @return shipment the shipment at the top of the stack
     */
    public Shipment pop(){
        if(size-1>= 0){
            Shipment temp = array[size-1];
            array[size - 1] = null;
            size--;
            return temp;
        }
        return null;
    }

    /**
     * Retutns the string expression of the stack
     * @return line string expression of the stack
     */
    @Override
    public String toString(){
        StringBuilder line = new StringBuilder();
        for(int i = 0; i<array.length; i++){
            if(array[i] != null){
                line.append(array[i].toShortString());
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
     * Clears all items outr of the stack
     */
    public void clear(){
        for(int i = 0; i<array.length; i++){
            array[i] = null;
        }
    }

    /**
     * Determines if a stack is full
     * @return bool true is the stack is ful, else false
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
     * Returns the internal array of the TruckStack
     * @return Shipment[] internal array of the stack
     */
    public Shipment[] getArray(){
        return array;// Return the new array
    }

    /**
     * Returns the size of the stack
     * @return size of the stack
     */
    public int getSize(){
        return size;
    }
    
    /**
     * Determines if the stack has sapce
     * @return bool true if the stack has space, else return false
     */
    public boolean hasSpace(){
        if(size< capacity){
            return true;
        }
        else{
            return false;
        }
    }

}
