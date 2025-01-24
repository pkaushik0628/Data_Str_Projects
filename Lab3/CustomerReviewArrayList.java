
/**
 * Public class CustomerReviewArrayList defines an array list of CustomerReview objects. The class is defining
 * the methods, namely add(CustomerReview customerReview), add(int index, CustomerReview customerReview), get(int index), 
 * clear(), isEmpty(), remove(int index), size(), arraySize(), empty_cnt, toString(), and next().
 * 
 *
 * @author Padmanabh Kaushik
 * @version 2/15/24
 */
public class CustomerReviewArrayList
{
    //Initialization of the default parameters of the array list
    private int DEFAULT_CAP = 10;
    private CustomerReview[] arrayList;
    private int size;
    private int internalCounter = 0;
    
    /**
     * Blank constructor for IntArrayList
     */
    public CustomerReviewArrayList()
    {
        this.arrayList = new CustomerReview[DEFAULT_CAP];
        this.size = 0;
    }
    

    /**
     * This method adds int e to the array list. If the array list is full, it creates a new array with 10 additional spaces.
     */
    public void add(CustomerReview customerReview){

        int newPosition = 0;
        
        
        //If array is full, create a new array
        if(size == arrayList.length){
            int newSize = arrayList.length + 10;
            CustomerReview[] newArrayList = new CustomerReview[newSize];
            size = arrayList.length;

            for (int i = 0; i<arrayList.length; i++){
                newArrayList[i] = arrayList[i];
            }
            arrayList = newArrayList;
            arrayList[size] = customerReview;
            size++;
        }
        //else put e into arrayList[size];
        else{
            arrayList[size] = customerReview;
            size++;
        }
    }
    
    /**
     * This method places int e in a specified index of the array
     * 
     * @param index  index of where to add a list item
     * @param customerReview  a CustomerReview Object that needs to be placed at the specific index
     */
    public void add (int index, CustomerReview customerReview){
        //If the index is negative or greater than size, generate an out of bounds exception
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        //While placing an index in an index that is already filled, create space, and adjust the elements
        else if (index <= size){
            if(size<arrayList.length){
                CustomerReview[] newArrayList = new CustomerReview[arrayList.length];

                for (int i = 0; i<arrayList.length; i++){
                    if(i<index){
                        newArrayList[i] = arrayList[i];
                    }
                    else if(i == index){
                        newArrayList[i] = customerReview;
                    }
                    else if ( i>index){
                        newArrayList[i] = arrayList[i-1];
                    }
                }
                arrayList = newArrayList;
                size++;
            }
            //If the list is already full, expand the size by 10
            else if(size == arrayList.length){
                CustomerReview[] newArrayList = new CustomerReview[arrayList.length + 10];

                for(int i = 0; i<arrayList.length; i++){
                    if (i<index){
                        newArrayList[i] = arrayList[i];
                    }
                    else if (i == index){
                        newArrayList[i] = customerReview;
                    }
                    else if(i>index){
                        newArrayList[i+1] = arrayList[i];
                    }
                }

                arrayList = newArrayList;
                size++;
            }
        }

    }
    /**
     * The method is used to get the integer at at a specific index of the array list
     * 
     * @param index index of the list item to be returned
     * @return CustomerReview object at specified index
     */
    public CustomerReview get(int index){
        //Ihe method should throw an out of bounds exception for parts of array that have not been filled
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        //else it should return arrayList[index]
        else{
            return arrayList[index];

        }
    }
    /**
     * The method is used to clear an array list and set all parameters to default
     */
    public void clear(){
        arrayList = new CustomerReview[DEFAULT_CAP];
        size = 0;
        internalCounter = 0;
    }
    /**
     * This method is used to ckeck if an array list is empty
     */
    public boolean isEmpty(){
        if(size == 0) return true;
        else return false;
    }
    
    /**
     * This method is used to remove an element at a specific index 
     * 
     * @param index of the list item to be removed
     * @return the list item removed
     */
    public CustomerReview remove(int index){
        //Throw an index out of bounds exception if the index is not yet filled or is negative
        if(index<0 || index>= size){
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        //else remove that element and adjust other elements
        else{

            int newSize = arrayList.length;
            CustomerReview[] newArray = new CustomerReview[newSize];

            for (int i = 0; i<arrayList.length; i++){
                if(i<index){
                    newArray[i] = arrayList[i];
                }
                else if(i>index){
                    newArray[i-1]  = arrayList[i];
                }
            }
            //Stote value to be returned before rewriting the original array
            CustomerReview storedValue = arrayList[index];
            //element removed
            arrayList = newArray;
            size--;

            //check if no of empty elements is more than 10
            if(arrayList.length-size>10){
                CustomerReview[] newArr2 = new CustomerReview[size + 10];
                
                for (int i = 0; i<=size; i++){
                    newArr2[i] = arrayList[i];
                }
                
                arrayList = newArr2;
            }
            
            return storedValue;
        }

    }
    /**
     * This method returns the size of an array list
     */
    public int size(){
        return size;
    }
    /**
     * This method returns the size of the actual array
     */
    public int arraySize(){
        return arrayList.length;
    }
    
    /**
     * This methods returns the number of empty elements in the array
     */
    public int empty_cnt(){
        return arrayList.length - size;
    }
    
    /**
     * This methods converts the non-empty elements of an array into a string and inserts spaces between them
     */
    public String toString(){
        StringBuilder result = new StringBuilder();
        int check = 0;

        for(int i = 0; i<arrayList.length; i++){
            if (arrayList[i] != null){
                result.append(arrayList[i].toString());
                if((i< arrayList.length - 1) && (check<size-1)){
                    result.append(" ");
                    check++;
                }
            }
        }

        String res = result.toString();
        res.replaceAll("\\s+$", "");
        return res;
    }
    /**
     * Returns an element based on an internal index counter
     */
    public CustomerReview next(){
        if(internalCounter<size){
            return arrayList[internalCounter++];
        }
        else{
           throw new IndexOutOfBoundsException("Data Ends here"); 
        }
    }
}
