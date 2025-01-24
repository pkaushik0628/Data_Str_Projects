import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * The class creates a Doubling List. A doubling list consists of a head and a tail. As the size of the doubling list increases, nodes having
 * arrays as a power of 2 are added to the list. The Doubling List implements the add(E item), add(int pos, E item), remove(int pos), toStringInternal(),
 * toStringInternal(ListIterator iter), find(NodeInfo info), size(), listIterator(int index) method.
 * 
 * The class also had three other inner classes: DoublingIterator, DoublingListIterator, and NodeInfo. While DoublingIterator and DoublingListIterator
 * are used to iterate through various elements in the list, the NodeInfo stores information about a list item whith respect to it's specific node
 * location and offset.
 *
 * @author Padmanabh Kaushik
 * @version 04/15/2024
 */
public class DoublingList<E> extends AbstractSequentialList<E>
{
    //define the head of the list
    private Node<E> head  = new Node();
    //define the tail of the list
    private Node<E> tail = new Node();
    //index
    int index = 0;
    //Number of nodes
    int noNodes = 0;
    //size of the list
    int size = 0;
    //Turns true is next is called
    boolean nextCalled = false;
    //Turns true when false is called
    boolean prevCalled = false;
    int cap = (int) java.lang.Math.pow(2,noNodes)-1;

    /**
     * Default constructor for a doubling list
     * A doubling list doesn't allow null objects
     * 
     */
    public DoublingList()
    {
        head.next = tail;
        tail.previous = head;
    }

    /**
     * Adds an item to the Doubling List without using the list iterator
     * @param item item to be added to the list
     * @return bool if the item is succefffully added to the list
     */
    public boolean add(E item){
        //If there are no actual nodes other than the head or tail, create a new node
        if (size == 0){
            Node<E> newNode = new Node(0, item);
            newNode.next = tail;
            newNode.previous = head;
            head.next = newNode;
            tail.previous  = newNode;
            size++;
            noNodes++;
            cap = ((int) java.lang.Math.pow(2,noNodes))-1;
        }
        //If nodes exist, add nodes from the back of the list
        else{
            if (tail.previous.getList().size() < tail.previous.capacity) {
                tail.previous.getList().add(item);
                //increment size each time a node is added
                size++;
                //return true when successfully added
                return true;
            }
            else{
                //make space if all of the list i filled
                //create a new node
                Node<E> newNode = new Node(noNodes, item);
                newNode.next = tail;
                newNode.previous = tail.previous;
                tail.previous.next = newNode;
                tail.previous = newNode;
                //increment the no. of nodes
                noNodes = noNodes + 1;
                //recalculate the capacity of the list
                cap = ((int) java.lang.Math.pow(2,noNodes))-1;
                //increase the size of the list
                size = size+1;
                //return true after successful addition
                return true;
            }
        }
        //else return false
        return false;
    }

    /**
     * Adds an item at a specified location
     * Does not use the list iterator
     * @param pos position where the item is to be added
     * @param item item which is to be added to the list
     * @throws IndexOutOfBounds Exception
     */
    public void add(int pos, E item){
        //If position is greater than index, throw an index out of bounds exception
        if(pos>size){
            throw new IndexOutOfBoundsException();
        }
        //If size is less than cap, there are three cases
        else if(size<cap){
            //if there are no actual nodes between haed and tail,create a new node
            if(cap == 0){
                Node<E> newNode = new Node(0, item);
                newNode.next = tail;
                newNode.previous = head;
                head.next = newNode;
                tail.previous  = newNode;
                size++;
                noNodes++;  
                cap = ((int) java.lang.Math.pow(2,noNodes))-1;
            }
            //if the list is not to its full capacity
            else if (cap > 0 && pos <= size - 1){
                Node<E> refNode = find(pos).node;
                Node<E> iterN = refNode;
                int locCapacity = refNode.capacity;
                int n = (int) (Math.log(locCapacity)/Math.log(2));
                int offset = find(pos).offset;
                //analysis of left side
                int leftSize = 0;
                while(iterN.previous != head){
                    leftSize = leftSize + iterN.previous.getList().size();
                    iterN = iterN.previous;
                }

                //If the node is not full
                if(refNode.getList().size() < locCapacity){
                    //Add ai index 0, right shift everything else
                    refNode.getList().add(offset, item);
                }
                //if the current node is full by the predecessor has space, left shift everything
                //(int) java.lang.Math.pow(2,n) - 1)
                else if (leftSize<((int) locCapacity - 1)) {
                    Node<E> copy = refNode;
                    E itemShift = refNode.getList().remove(0);
                    refNode.getList().add(offset, item);
                    E temp = null;
                    int looped = 0;
                    //left shift
                    while(copy.previous != head && copy.previous.getList().size() == copy.previous.capacity){
                        temp = copy.previous.getList().remove(0);
                        copy.previous.getList().add(itemShift);
                        copy = copy.previous;
                        looped++;
                    }

                    if(copy.previous != head){
                        if(looped>0){
                            copy.previous.getList().add(temp);
                        }
                        else{
                            copy.previous.getList().add(itemShift);
                        }
                    }
                    size++;
                }
                //If there are empty spaces to the right
                else{
                    int locIndex = refNode.getList().size()-1;
                    E refItem = refNode.getList().remove(locIndex);
                    refNode.getList().add(offset, item);
                    size = size + 1;
                    //Do the right shifts
                    refNode = refNode.next;
                    //right shift
                    while(refNode!= tail && refNode.getList().size() <= (int) java.lang.Math.pow(2,n+1)){
                        //refNode.getList().remove(0);
                        refNode.getList().add(0, refItem);
                        refItem = refNode.getList().get(refNode.getList().size()-1);
                        refNode = refNode.next;
                        n = n + 1;
                    }

                }
            }
        }
        //if the list is filled to its capacity, create a new node
        else if (size == cap){
            //is pos = size, just add the item to the newnode and add the newNode to the next of tail.previous node
            if (pos == size){
                Node<E> newNode = new Node(noNodes, item);
                newNode.next = tail;
                newNode.previous = tail.previous;
                tail.previous.next = newNode;
                tail.previous  = newNode;
                //increment size and recalculate the capacity
                size++;
                noNodes++; 
                cap = ((int) java.lang.Math.pow(2,noNodes))-1;
            }
            //if position is not equal to size, right shifting is needed
            else if(pos != size){
                Node<E> newNode = new Node(noNodes, item);
                newNode.next = tail;
                newNode.previous = tail.previous;
                tail.previous.next = newNode;
                tail.previous  = newNode;
                //increment size and recalculate capacity
                size++;
                noNodes++; 
                cap = ((int) java.lang.Math.pow(2,noNodes))-1;
                E replaced = newNode.getList().remove(0);
                //find the information about the ndoe and offset of the pos
                Node<E> refNode = find(pos).node;
                int offset = find(pos).offset;
                int n = (int) (Math.log(refNode.capacity) / Math.log(2));
                E refItem = refNode.getList().get(refNode.getList().size()-1);
                refNode.getList().remove(refNode.getList().size()-1);
                refNode.getList().add(offset, item);
                //Do the right shifts
                refNode = refNode.next;
                while(refNode!= tail && refNode.getList().size() <= (int) java.lang.Math.pow(2,n+1)){
                    //refNode.getList().remove(0);
                    refNode.getList().add(0, refItem);
                    refItem = refNode.getList().get(refNode.getList().size()-1);
                    refNode = refNode.next;
                    n= n+1;
                }
            }

        }

    }
    /**
     * Removes and returns the item at a specified location
     * @param pos position from where the item is to be removed
     * @return item the specific item removed from the specified location
     * @throws IndexOutOfBounds Exception if pos is greater than size or pos is negative
     */
    public E remove(int pos){
        if(pos> size || pos < 0){
            throw new IndexOutOfBoundsException();
        }
        Node<E> r = find(pos).node;
        int offset  = find(pos).offset;
        E x = r.getList().remove(offset);
        size--;
        //making list compact
        if(size <= ((int) java.lang.Math.pow(2,noNodes-2))-1){
            ArrayList<E> tempList = new ArrayList<>();
            Node<E> current = head.next;
            E removed;
            while(current!= tail){
                while(!current.getList().isEmpty()){
                    removed = current.getList().remove(0);
                    tempList.add(removed);
                }
                current = current.next;
            }

            Node<E> pointer = head.next;
            int n = 0;
            int currSize = 0;
            //pointer.getList().add(tempList.get(0));
            for(int i = 0; i<tempList.size(); i++){
                if(currSize < (int) java.lang.Math.pow(2,n)){
                    pointer.getList().add(tempList.get(i));
                    currSize++;
                }
                if( currSize == (int) java.lang.Math.pow(2,n) && pointer.next != tail){
                    pointer = pointer.next;
                    n++;
                    currSize = 0;
                }
            }
            //remove the last node
            tail.previous.previous.next = tail;
            tail.previous = tail.previous.previous.next;
        }
        return x;
    }

    /**
     * Returns the string representation of the doubling list
     * @return a string expression for the list
     */
    public String toStringInternal(){
        Node<E> newNode = head.next;
        StringBuilder line = new StringBuilder();
        line.append("[");
        while(newNode != tail && (newNode.getList().size() != 0 || newNode.next != tail)){
            ArrayList<E> list = newNode.getList();
            line.append("(");
            if(list.size() != 0){
                line.append(list.get(0));
            }
            else if (list.size() == 0){
                line.append("-");
            }
            System.out.println("This is new Node capacity" + newNode.capacity);
            for (int i = 1; i<(newNode.capacity); i++){
                if(i > list.size() - 1){
                    line.append(",-");
                }
                else{
                    line.append("," + list.get(i));
                }
            }
            line.append(")");
            newNode = newNode.next;
        }
        line.append("]");
        return line.toString();
    }

    /**
     * Returns the string expression for a list iterator object
     * @param iter list iterator to be converted to a string
     * @return string string expression of the list iterator object
     */
    public String toStringInternal(ListIterator iter){
        //get to the next to head of the list
        Node<E> newNode = head.next;
        //initialize a StringBuilder
        StringBuilder line = new StringBuilder();
        //Appends brackets for the list
        line.append("[");
        Node<E> thisNode = find(iter.nextIndex()).node;
        int thisOffset = find(iter.nextIndex()).offset;
        
        while(newNode != tail && (newNode.getList().size() != 0 || newNode.next != tail)){
            ArrayList<E> list = newNode.getList();
            line.append("(");
            if(list.size() != 0){
                if(newNode.capacity == thisNode.capacity && thisOffset == 0){
                    //create the nextIndex() identifier: edge case: at the beginning of a ndes
                    line.append("|" + list.get(0));
                }
                else{
                    line.append(list.get(0));
                }

            }
            else if (list.size() == 0){
                //for blank spaces/nulls, append dashes
                line.append("-");
            }
            //System.out.println("This is new Node capacity" + newNode.capacity);
            for (int i = 1; i<(newNode.capacity); i++){
                if(i > list.size() - 1){
                    line.append(",-");
                }
                else{
                    //create the nextIndex() identifier for places not at the starting index of a node
                    if(newNode.capacity == thisNode.capacity && thisOffset == i){
                        line.append(",|" + list.get(i));
                    }
                    else{
                        line.append("," + list.get(i));
                    }
                }
            }
            line.append(")");
            newNode = newNode.next;
        }
        line.append("]");
        //Convert string builder to string 
        return line.toString();
    }

    /**
     * Overrides listiterator abstract method in AbstractSequentialList
     * @param index index where the list iterator should start
     * @return a new DoublingListIterator object
     */
    public ListIterator<E> listIterator(int index){
        return new DoublingListIterator(this, index);
    }

    /**
     * Overrides the size method in AbstractSequentialList
     * @reurn size size of the list
     */
    @Override
    public int size(){
        return size;  
    }

    /**
     * Helper method used to find the node and offset corresponding to a specific global index of the list
     * @param pos position whose node and offset are to be determined
     * @return NodeInfo A NodeInfo object that stores the node and offset corresponding to the global index
     */
    public NodeInfo find(int pos){
        Node<E> currNode = head.next; // initialize at head.next
        int currPos = 0; // start from the beginning of the list
        NodeInfo newNodeInfo = null; // initialze the nodeInfo object as null
        int atLeastOnce = 0; //Used to check if at least one node has been checked
        int subst = 1; // position adjustment factor
        while(currNode != tail && currPos <= pos){
            currPos = (currNode.getList().size())+ currPos;
            if(currPos-1 < pos){
                currNode = currNode.next;
                if(atLeastOnce>0){
                    subst = 0;
                    atLeastOnce++;
                }
            }
            else{
                currPos = currPos - currNode.getList().size();
                int offset = pos - (currPos);
                newNodeInfo = new NodeInfo(currNode, offset);
                return newNodeInfo;
            }
        }
        return newNodeInfo;
    }

    /**
     * The DoublingIterator class is used to iterate through the nodes in the list. The class implements hasNext(), next(), and 
     * returnOffset() methods.
     */
    public class DoublingIterator implements Iterator<E>{
        //Initial (starting) node of the iterator
        Node<E> start;

        /**
         * Default constructor for DoublingIterator
         * Node start is initialized at the node next to head of the doubling list
         */
        public DoublingIterator(){
            start = head.next;
        }

        /**
         * Returns the offset of a nodeInfo Object
         * @param obj NodeInfo object whose position is to be returned
         * @return int offset osecific to the NodeInfo object
         */
        public int returnOffset(NodeInfo obj){
            return obj.offset;
        }

        /**
         * Used to check if the list has more items
         * @return true if the list has at lesat one more item beyond the current pointer/cursor
         * @return false if the list no more items beyond the current pointer/cursor
         * Note: The mothod runs on the basis of the internal cursor maintained by the DoublingList
         */
        @Override
        public boolean hasNext(){

            while(start!= tail) {
                if(start.getList().size() !=0){
                    return true;
                }
                start = start.next;
            }
            return false;
        }

        /**
         * Returns the next list item, if it exists
         * @return next list item based on the position of the current pointer/cursor
         * @throws NoSuchElementException if index>= size
         */
        @Override
        public E next(){
            Node<E> next;
            nextCalled = true;
            prevCalled = false;
            start = find(index).node;
            if(index >= size){
                throw new NoSuchElementException();
            }
            else{
                next = find(index).node;
                E item =  next.getList().get(find(index).offset);
                index = index+1;
                return item;
            }
        }
    }

    /**
     * The class is used to iterate through the list items stored in the nodes, in addition to adding, removing and setting items in the list.
     * This class implements works on  the basis of an internal index (which works like a cursor/pointer). If a cursor or a pointer is not specified
     * in  the constructir, the default index is taken to be zero (head.next node). The class implements add(E item), set(E item), remove(), 
     * prevIndex(), nextIndex(), previous(), hasPrevious(), next(), and hasNext() methods.
     */
    public class DoublingListIterator implements ListIterator<E>{
        Node<E> start; // starting node
        int cursor = 0; // default cursor value
        DoublingList<E> dlist; // doubling list of the ListIterator
        int offset = find(index).offset; // offset of the index

        /**
         * Default condtructor for DoublingListIterator class
         */
        public DoublingListIterator(){
            start = head.next;
        }

        /**
         * Constructor for the DoublingListIterator class
         * @param list DoublingList on which iterator is to be applied
         */
        public DoublingListIterator(DoublingList<E> list){
            start = head.next;
        }

        /**
         * Constructor for DoublingListIterator class
         * @param list DoublingList on which the ListIterator is to be applied
         * @param index index at which the list iterator should be initized to begin at
         */
        public DoublingListIterator(DoublingList<E> list, int index){
            dlist = list;
            Node<E> newNode = list.find(index).node;
            start = newNode;
            cursor = index;
        }

        /**
         * Adds an item at the cursor location. Performs leftward, rightward shift depending on the if spaces are available to the left
         * or right of the cursor. Adds a new node in case the list is completely filled.
         * @param item Generic item to be added to the list
         */
        @Override
        public void add(E item){

            int pos = cursor;

            if(pos>size){
                throw new IndexOutOfBoundsException();
            }
            else if(size<cap){

                if(cap == 0){
                    Node<E> newNode = new Node(0, item);
                    newNode.next = tail;
                    newNode.previous = head;
                    head.next = newNode;
                    tail.previous  = newNode;
                    size++;
                    cursor++;
                    noNodes++;  
                    cap = ((int) java.lang.Math.pow(2,noNodes))-1;
                }
                else if (cap > 0 && pos <= size - 1){
                    Node<E> refNode = find(pos).node;
                    Node<E> iterN = refNode;
                    int locCapacity = refNode.capacity;
                    int n = (int) (Math.log(locCapacity)/Math.log(2));
                    int offset = find(pos).offset;
                    //analysis of left side
                    int leftSize = 0;
                    while(iterN.previous != head){
                        leftSize = leftSize + iterN.previous.getList().size();
                        iterN = iterN.previous;
                    }

                    //If the node is not full
                    if(refNode.getList().size() < locCapacity){
                        //Add ai index 0, right shift everything else
                        refNode.getList().add(offset, item);
                    }
                    //if the current node is full by the predecessor has space, left shift everything
                    //(int) java.lang.Math.pow(2,n) - 1)
                    else if (leftSize<((int) locCapacity - 1)) {
                        Node<E> copy = refNode;
                        E itemShift = refNode.getList().remove(0);
                        refNode.getList().add(offset, item);
                        E temp = null;
                        int looped = 0;

                        while(copy.previous != head && copy.previous.getList().size() == copy.previous.capacity){
                            temp = copy.previous.getList().remove(0);
                            copy.previous.getList().add(itemShift);
                            copy = copy.previous;
                            looped++;
                        }

                        if(copy.previous != head){
                            if(looped>0){
                                copy.previous.getList().add(temp);
                            }
                            else{
                                copy.previous.getList().add(itemShift);
                            }
                        }
                        size++;
                    }
                    //If there are empty spaces to the right
                    else{
                        int locIndex = refNode.getList().size()-1;
                        E refItem = refNode.getList().remove(locIndex);
                        refNode.getList().add(offset, item);
                        size = size + 1;
                        //Do the right shifts
                        refNode = refNode.next;
                        while(refNode!= tail && refNode.getList().size() <= (int) java.lang.Math.pow(2,n+1)){
                            //refNode.getList().remove(0);
                            refNode.getList().add(0, refItem);
                            refItem = refNode.getList().get(refNode.getList().size()-1);
                            refNode = refNode.next;
                            n = n + 1;
                        }

                    }
                }
            }
            //if size is equal to cap, a new node is needed to be added
            else if (size == cap){
                if (pos == size){
                    Node<E> newNode = new Node(noNodes, item);
                    newNode.next = tail;
                    newNode.previous = tail.previous;
                    tail.previous.next = newNode;
                    tail.previous  = newNode;
                    //increment size, nodes, and cursor
                    size++;
                    noNodes++;
                    cursor++;
                    cap = ((int) java.lang.Math.pow(2,noNodes))-1;
                }
                //if pos is not equal to size, rightward shift of elements is needed to be done
                else if(pos != size){
                    Node<E> newNode = new Node(noNodes, item);
                    newNode.next = tail;
                    newNode.previous = tail.previous;
                    tail.previous.next = newNode;
                    tail.previous  = newNode;
                    //increment size, nodes, and cursor
                    size++;
                    noNodes++; 
                    cursor++;
                    cap = ((int) java.lang.Math.pow(2,noNodes))-1;
                    E replaced = newNode.getList().remove(0);
                    //Reference the desired position where the item is to be inserted
                    Node<E> refNode = find(pos).node;
                    int n = (int) (Math.log(refNode.capacity) / Math.log(2));
                    E refItem = refNode.getList().get(refNode.getList().size()-1);
                    refNode.getList().remove(refNode.getList().size()-1);
                    refNode.getList().add(offset, item);
                    //Do the right shifts
                    refNode = refNode.next;
                    while(refNode!= tail && refNode.getList().size() <= (int) java.lang.Math.pow(2,n+1)){
                        //refNode.getList().remove(0);
                        refNode.getList().add(0, refItem);
                        refItem = refNode.getList().get(refNode.getList().size()-1);
                        refNode = refNode.next;
                        n= n+1;
                    }
                }

            }

        }

        /**
         * Set an item at an index, where next() or previous() was performed
         * @param item Generic item which is to be set at a location determined by where the where next() or previous() was applied
         */
        @Override
        public void set(E item){
            if(nextCalled){
                int place = index - 1;
                Node<E> newNode = find(place).node;
                newNode.getList().set(find(place).offset, item);
                nextCalled = false;
            }
            else if(prevCalled){
                int place = index + 1;
                Node<E> newNode = find(place).node;
                newNode.getList().set(find(place).offset, item);
                prevCalled = false;
            }
            else if( !nextCalled  && !prevCalled){
                throw new IllegalStateException();
            }
        }

        /**
         * Removes an element at the cursor location. Performs list compaction depending on whether the no. of elements
         * falls below 2^(k-2) - 1. The cursor location is adjust depending on whether next() or previous() was applied, and
         * if the list was compacted.
         */
        @Override
        public void remove(){
            int place = 0;

            if(nextCalled){
                place = cursor - 1;
                nextCalled = false;
            }
            else if (prevCalled){
                place = cursor + 1;
                prevCalled = false;
            }

            Node<E> r = find(place).node;
            int offset  = find(place).offset;
            E x = r.getList().remove(offset);

            //find what was before
            Node<E> r_02 = find(place-1).node;
            int offset_02 = find(place-1).offset;
            E x_02 = r_02.getList().get(offset_02);

            size--;
            //making list compact
            if(size <= ((int) java.lang.Math.pow(2,noNodes-2))-1){
                ArrayList<E> tempList = new ArrayList<>();
                Node<E> current = head.next;
                E removed;
                while(current!= tail){
                    while(!current.getList().isEmpty()){
                        removed = current.getList().remove(0);
                        tempList.add(removed);
                    }
                    current = current.next;
                }

                Node<E> pointer = head.next;
                int n = 0;
                int currSize = 0;
                //pointer.getList().add(tempList.get(0));
                for(int i = 0; i<tempList.size(); i++){
                    if(tempList.get(i) == x_02){
                        cursor = i;
                    }
                    if(currSize < (int) java.lang.Math.pow(2,n)){
                        pointer.getList().add(tempList.get(i));
                        currSize++;
                    }
                    if( currSize == (int) java.lang.Math.pow(2,n) && pointer.next != tail){
                        pointer = pointer.next;
                        n++;
                        currSize = 0;
                    }
                }
                //remove the last node
                tail.previous.previous.next = tail;
                tail.previous = tail.previous.previous.next;
            }
        }

        /**
         * Determines the previous index based on the current index/cursor
         * @return int the previous index in  the list
         * returns -1 if no elements are present in the list
         */
        @Override
        public int previousIndex(){
            start = find(index).node;

            if( start.previous == head){
                return -1;
            }
            else{
                NodeInfo newNodeInfo = find(index-1);
                if(newNodeInfo == null){
                    return -1;
                }
                else{
                    return index-1;
                }
            }
        }

        /**
         * Determines the next index based on the current index/cursor
         * @returns nextIndex nextIndex of the list
         * returns size if the next index is size
         */
        @Override
        public int nextIndex(){
            start = find(index).node;

            if (index < (size-1)){
                return index+1;
            }
            else if(index == (size - 1)){
                return size;
            }
            else{
                throw new IndexOutOfBoundsException();
            }

        }

        /**
         * Returns the previous element in the list based on the current index/cursor
         * @returns prevItem the previous item in  the list
         * returns null if there is no previous item in the list (i.e the previous item is a head)
         */
        @Override
        public E previous(){
            nextCalled = false;
            prevCalled = true;

            int reqIndex = previousIndex();

            if(reqIndex != -1){
                Node<E> newNode = find(reqIndex).node;
                index = index-1;
                cursor--;
                return newNode.getList().get(find(reqIndex).offset);
            }
            else{
                return null;
            }

        }

        /**
         * Determines if the list had a previous item based on an index/cursor location
         * @return bool a boolean value based on a previous item is present or not
         */
        @Override
        public boolean hasPrevious(){
            int reqIndex = previousIndex();
            if(reqIndex == -1){
                return false;
            }
            else{
                return true;
            }
        }

        /**
         * Returns the next item in the list based on the current index/cursor location
         * @return item the previous item in the list
         */
        @Override
        public E next(){
            nextCalled = true;
            prevCalled = false;
            Node<E> next;
            //start = find(index).node;
            if(index >= size){
                throw new NoSuchElementException();
            }
            else{
                next = find(index).node;
                E item =  next.getList().get(find(cursor).offset);
                index = index+1;
                cursor++;
                return item;
            }
        }

        /**
         * Determines is  the list has a next item based on an index/cursor location
         * @return bool a boolean value depending on if a next item is present or not
         */
        @Override
        public boolean hasNext(){
            while(start!= tail) {
                if(start.getList().size() !=0){
                    return true;
                }
                start = start.next;
            }
            return false;
        }

    }

    /**
     * The class is designed such that it's object can store information about a node. The default constructor of this class takes in a node,
     * and the offset of an item within the array of that node
     */
    private class NodeInfo {
        public Node node;
        public int offset ;
        public NodeInfo(Node node , int offset ) {
            this.node = node;
            this . offset = offset ;
        }

    }
}
