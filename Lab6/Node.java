import java.util.ArrayList;

/**
 * This class defines a node in a linked list.
 *
 * @author Padmanabh Kaushik
 * @version 3/7/2024
 */
public class Node<E>
{
    E val;
    Node<E> next;
    int size;
    Node<E> head;
    
    /**
     * Default constructor for Node
     */
    Node(E d){
        next = null;
        val = d;
        size = 1;
        head = this;
    }
    
    /**
     * Constructs a node using an array list
     * @param list array list to be converted into linked list
     */
    Node(ArrayList <E> list){
        
        if(list == null){
            throw new IllegalArgumentException("Array list is empty");
        }
        this.val = list.get(0);
        Node<E> current = this;
        Node<E> head = this;
        //iterate through the loop to lust list items into the linked list
        size = list.size();
        for(int i = 1; i<list.size(); i++){
            current.next = new Node<>(list.get(i));
            current = current.next;
        }
    }
    
    /**
     * Returns the list string, with each item separated by a comma
     */
    @Override
    public String toString(){
        //create a stringbuilder
        StringBuilder buildString = new StringBuilder();
        Node<E> current = this;
        while(current !=null){
            //add elements
            buildString.append(current.val);
            if(current.next != null){
                //add space and a comma
                buildString.append(", ");
            }
            current = current.next;
        }
        //convert the stringbuilder back to a string
        return buildString.toString();
    }
    
    
    /**
     * Adds a node to the end of the list
     * @param value generic input to be added to the back of the linked list
     */
    public void addToBack(E value){
        Node<E> newNode = new Node<>(value);
        Node<E> current = this;
        while(current.next !=null){
            current = current.next;
        }
        current.next = newNode;
        size = size+1;
    }
    
    /**
     * Adds a node to the front of the list
     * @param value generic value to be added to the front of the linked list
     */
    public void addToFront(E value){
        Node<E> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
    }
    
    /**
     * Rotates the linked list to the tight by k places
     * @param k number of places to be rotated
     * @throws IllegalArgumentException if the rotation value is negative
     */
    public void rotate(int k){
        //if k is negative, throw an exception
        if (k<0){
            throw new IllegalArgumentException("Rotation is negative");
        }
        //if k = 0, no rotation is needed
        if (k == 0){
            return;
        }
        //Calculate the length of the list
        Node<E> newNode = this;
        int length = 1;
        while(newNode.next != null){
            newNode = newNode.next;
            length++;
        }
        //If k is greater than or equal to list length
        if (k>=length){
            k = k % length;
        }
        //If k is equal to list length, then return
        if (k == 0){
            return;
        }
        
        Node<E> tempHead = this;
        Node<E> reqTail = this;
        //get the new tail
        for(int i = 0; i< length-k-1; i++){
            reqTail = reqTail.next;
        }
        //reaggrange the elements in the linked list 
        Node<E> reqHead = reqTail.next;
        newNode.next = tempHead;
        reqTail.next = null;
        head = reqHead;
    }
}
