import java.util.ArrayList;

/**
 * The node class defines node. The constructor for a node accepts a integer k, which creates an array of size 2^k within the node. Each node
 * has two links: previous and next. This helps in a two way movement in the DoublingList. The Node implements the add(int pos, item E), remove(int i),
 * setNext(), setPrev(), and getList() methods. 
 *
 * @author Padmanabh Kaushik
 * @version 04/15/2024
 */
public class Node<E>
{
    // instance variables - replace the example below with your own
    Node<E> next;
    Node<E> previous;
    //E[] array;
    private ArrayList<E> nodeList;
    int capacity = 0;
    //Index is actually the size
    int arrayIndex = 0;

    /**
     * Default constructor for objects of class Node. Used for head and tail
     */
    public Node()
    {
        next = null;
        previous  = null;
        capacity = 0;
    }

    /**
     * Creates a node with size 2^k, and adds the specified item to the array
     *
     * @param  k size of the array list within  the node
     * @return item generic item to be added to the node
     */
    public Node(int k, E item)
    {
        if (item == null) throw new NullPointerException();
        nodeList = new ArrayList<>((int) java.lang.Math.pow(2,k));
        nodeList.add(item);
        capacity = ((int) java.lang.Math.pow(2,k));
    }

    /**
     * Adds an item to a specified position
     * @param pos position where the item is to be inserted. This is the index of the local array list specific to the node, not to the list
     * @param item the generic item which is to be inserted into the array list of the node
     */
    public void add(int pos, E item){
        if(pos>=nodeList.size() || pos>=arrayIndex){
            throw new IndexOutOfBoundsException();
        }
        else{
            nodeList.add(pos, item);
        }
    }
    
    /**
     * Removes an item from a given position
     * @param pos position from which an item is to be removed
     * @return retItem the generic item which is removed from the specified position
     */
    public E remove(int pos){
        //ityem to be returned
        E retItem;
        
        if(pos>=nodeList.size()){
            throw new IndexOutOfBoundsException();
        }
        else{
            retItem = nodeList.get(pos);
            nodeList.remove(pos);
        }
        return retItem;
    }
    
    /**
     * Sets the next node for a given node
     * @param node next node to be set
     */
    public void setNext(Node<E> node){
        next = node;
    }
    
    /**
     * Sets the previous node for a given node
     * @param node previous node to be set
     */
    public void setPrev(Node<E> node){
        previous = node;
    }
    
    /**
     * Retrurns the array list of the Node
     * @return nodeList the array list of the node
     */
    public ArrayList<E> getList(){
        return nodeList;
    }
    
}
