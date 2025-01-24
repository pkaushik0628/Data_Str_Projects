import java.util.HashMap;

/**
 * The class MyClassicPriorityQueue extends MyPriorityQueue. The class uses hash maps to get direct access to the array indices og a target.
 * The class implement the methods add(T t), poll(), and decreaseKey(T target, T smallerValue).
 *
 * @author Padmanabh Kaushik
 * @version 05/02/2024
 */
public class MyClassicPriorityQueue<T extends Comparable<? super T>> extends MyPriorityQueue<T>
{

    HashMap<T, Integer> map;
    
    /**
     * Constructor for objects of class MyClassicPriorityQueue
     */
    public MyClassicPriorityQueue()
    {
        super();
        map = new HashMap<T,Integer>();
    }
    
    @Override
    public boolean add(T t){
        if(t != null){
            arrayList.add(t);
            map.put(t, arrayList.size()-1);
            int currentIndex = arrayList.size() - 1;
            int parentIndex = getParentIndex(currentIndex);
            //percolate up the array list
            //loop up until the parent is greater than child
            while(arrayList.size() > 1 && arrayList.get(parentIndex).compareTo(arrayList.get(currentIndex)) >= 0 && currentIndex != parentIndex){
                T temp = arrayList.get(parentIndex); //store parent index before swapping
                //perform swap operation in a hash map
                map.replace(arrayList.get(currentIndex), parentIndex);
                map.replace(temp, currentIndex);
                //on array
                arrayList.set(parentIndex, arrayList.get(currentIndex));//swap
                arrayList.set(currentIndex, temp);//sawp
                //index swaps
                currentIndex = parentIndex;//over current index to parent
                parentIndex = getParentIndex(currentIndex);//find new parent index
            }
            return true;
        }
        return false;
    }
    
    @Override
    public T poll(){
        //save and remove the 0th element
        T toReturn = arrayList.remove(0);
        //remove from hashMap()
        map.remove(toReturn);
        //bring the last element to the front
        T toAdd = arrayList.get(arrayList.size() - 1);
        arrayList.add(0, toAdd);
        //make change in the map
        map.put(toAdd, 0);
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
            //performs swaps on the map
            map.put(arrayList.get(childL), currentIndex);
            map.put(temp,childL);
            //on array
            arrayList.set(currentIndex, arrayList.get(childL));
            arrayList.set(childL, temp);
            //index swaps
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
                    //performs swaps on the map
                    map.put(arrayList.get(childL), currentIndex);
                    map.put(temp,childL);
                    //on array
                    arrayList.set(currentIndex, arrayList.get(childL));
                    arrayList.set(childL, temp);
                    //index swaps
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
                    //performs swaps on the map
                    map.put(arrayList.get(childR), currentIndex);
                    map.put(temp,childR);
                    //on array
                    arrayList.set(currentIndex, arrayList.get(childR));
                    arrayList.set(childR, temp);
                    //swap index
                    currentIndex = childR;
                    childL = leftChildIndex(currentIndex); //set new left child 
                    childR = rightChildIndex(currentIndex);// set new right child
                }
            }
        }
        return toReturn;
    }
    
    
    public T  decreaseKey(T target, T smallerValue){
        
        if(smallerValue.compareTo(target) > 0){
            return null;
        }
        else{
            int currentIndex = map.get(target);
            T toReturn = arrayList.get(currentIndex);
            //remove target from map
            map.remove(target);
            //add new element with new index mapping
            map.put(smallerValue, currentIndex);
            arrayList.set(currentIndex, smallerValue);
            //logic to percolate up
            int parentIndex = getParentIndex(currentIndex);
            //loop up until the parent is greater than child
            while(arrayList.size() > 1 && arrayList.get(parentIndex).compareTo(arrayList.get(currentIndex)) >= 0 && currentIndex != parentIndex){
                T temp = arrayList.get(parentIndex); //store parent index before swapping
                //perform swap operation in a hash map
                map.replace(arrayList.get(currentIndex), parentIndex);
                map.replace(temp, currentIndex);
                //on array
                arrayList.set(parentIndex, arrayList.get(currentIndex));//swap
                arrayList.set(currentIndex, temp);//sawp
                //index swaps
                currentIndex = parentIndex;//over current index to parent
                parentIndex = getParentIndex(currentIndex);//find new parent index
            }
            return toReturn;
        }
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
     * Returns the index for the right child in the array list
     * @param i index of the parent element in the array list
     * @return index of the right child
     */
    private int rightChildIndex(int i){
        return (2*i) + 2;
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
     * Returns the internal hash map 
     * @return map internal hash map
     */
    public HashMap<T, Integer> getMap(){
        return map;
    }

    
}
