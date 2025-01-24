import java.util.ArrayList;

/**
 * The class maintains an ArrayList of type T representing a heap, where T enforces comparable. The class implements priority queue
 * vis three methods: boolean add(T t), T poll(), T peek(), boolean isHeap().
 *
 * @author Padmanabh Kaushik
 * @version 05/02/2024
 */
public class MyPriorityQueue<T extends Comparable< ? super T>>
{
    // instance variables - replace the example below with your own
    protected ArrayList<T> arrayList;

    /**
     * Constructor for objects of class MyPriorityQueue
     * Initialized an empty array list
     */
    public MyPriorityQueue()
    {
        arrayList = new ArrayList<>();
    }

    /**
     * Inserts t at the end of teh array list. Rerurns true if the insertion
     * is successful. Else returns false.
     * @param t item to be inserted at the end of an array list
     * @return bool a boolean value indicating if the insertion is successful
     */
    public boolean add(T t){
        if(t != null){
            arrayList.add(t);
            int currentIndex = arrayList.size() - 1;
            int parentIndex = getParentIndex(currentIndex);
            //percolate up the array list
            //loop up until the parent is greater than child
            while(arrayList.size() > 1 && arrayList.get(parentIndex).compareTo(arrayList.get(currentIndex)) >= 0 && currentIndex != parentIndex){
                T temp = arrayList.get(parentIndex); //store parent index before swapping
                arrayList.set(parentIndex, arrayList.get(currentIndex));//swap
                arrayList.set(currentIndex, temp);//sawp
                currentIndex = parentIndex;//over current index to parent
                parentIndex = getParentIndex(currentIndex);//find new parent index
            }
            return true;
        }
        return false;
    }

    /**
     * Removes the minimal element from the array list. Moves the last element to 
     * the from and shifts it down to the appropriate location.
     * @return item minimal item removed from the array list
     */
    public T poll(){
        //save and remove the 0th element
        T toReturn = arrayList.remove(0);
        //bring the last element to the front
        T toAdd = arrayList.get(arrayList.size() - 1);
        arrayList.add(0, toAdd);
        //delete the last element
        arrayList.remove(arrayList.size()-1);
        //percolate up
        //determine current, left child, and rigghtchild index
        int currentIndex = 0;
        int childL = leftChildIndex(currentIndex);
        int childR = rightChildIndex(currentIndex);

        if(arrayList.size()<=1){
            return toReturn;
        }
        else if(childR >= arrayList.size() && arrayList.get(currentIndex).compareTo(arrayList.get(childL)) > 0){ //i.e. the right child does not exist
            T temp = arrayList.get(currentIndex);
            arrayList.set(currentIndex, arrayList.get(childL));
            arrayList.set(childL, temp);
            currentIndex = childL;
            childL = leftChildIndex(currentIndex); //set new left child 
            childR = rightChildIndex(currentIndex);// set new right child
        }
        //if both childs exist
        else if(childL < arrayList.size() && childR < arrayList.size()){
            //while parent is less than child, we need to percolate down
            while(childL != childR && arrayList.get(currentIndex).compareTo(arrayList.get(childR)) > 0 || arrayList.get(currentIndex).compareTo(arrayList.get(childR)) > 0 && arrayList.size() > 1){
                if(arrayList.get(childR).compareTo(arrayList.get(childL)) > 0){ // left child is smaller
                    if(childL >= arrayList.size()){
                        break;
                    }
                    T temp = arrayList.get(currentIndex);
                    arrayList.set(currentIndex, arrayList.get(childL));
                    arrayList.set(childL, temp);
                    currentIndex = childL;
                    childL = leftChildIndex(currentIndex); //set new left child 
                    childR = rightChildIndex(currentIndex);// set new right child
                    if(childL > arrayList.size() && childR > arrayList.size()){
                        break;
                    }
                }
                else if (arrayList.get(childL).compareTo(arrayList.get(childR)) > 0){ //right child is smaller
                    
                    if(childR >= arrayList.size()){
                        break;
                    }
                    //swap logic
                    T temp = arrayList.get(currentIndex);
                    arrayList.set(currentIndex, arrayList.get(childR));
                    arrayList.set(childR, temp);
                    currentIndex = childR;
                    childL = leftChildIndex(currentIndex); //set new left child 
                    childR = rightChildIndex(currentIndex);// set new right child
                }
            }
        }
        return toReturn;
    }

    /**
     * Finds and removes the miminal element,without removing it.
     * @return item the miminal item in the heap
     */
    public T peek(){
        return arrayList.get(0);
    }

    /**
     * Iteratively verifies the heap ordering for each element and its children
     * Returns true if every element in the array list satisfies it, else returns false
     * @return bool value depending on if the array list maintains the heap order
     */
    public boolean isHeap(){
        int currentIndex = 0;
        int childL = leftChildIndex(currentIndex);
        int childR = rightChildIndex(currentIndex);

        for(int i = 0; i< arrayList.size(); i++){
            currentIndex = i;
            childL = leftChildIndex(currentIndex);
            childR = rightChildIndex(currentIndex);
            if(childL >= arrayList.size() && childR>= arrayList.size()) {
                break;
            }
            else if (childL < arrayList.size() && childR<  arrayList.size()){
                if(arrayList.get(childL).compareTo(arrayList.get(currentIndex)) < 0 || arrayList.get(childR).compareTo(arrayList.get(currentIndex))<0){
                    //if the left child is less than the root or the right child is less than the root, it should violate
                    //the pattern of a min heap. Hence result is false.
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns the parent's index for child index i
     * @param i index of the child elemet
     * @return parentIndex index of the parent element in the array list
     */
    private int getParentIndex(int i){
        return (i-1)/2;
    }

    /**
     * Returns the index for the left child in the array list
     * @param i index of the parent element in the array list
     * @return index of the left child
     */
    private int leftChildIndex(int i){
        return (2*i) + 1;
    }

    /**
     * Returns the index for the right child in the array list
     * @param i index of the parent element in the array list
     * @return index of the right child
     */
    private int rightChildIndex(int i){
        return (2*i) + 2;
    }

    /**
     * Returns the array list of MyPriorityQueue
     * @return arrayList ArrayList of MyPriorityQueue
     */
    public ArrayList<T> getArrayList(){
        return arrayList;
    }

}
