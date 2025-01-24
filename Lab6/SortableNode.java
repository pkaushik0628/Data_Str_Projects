import java.util.ArrayList;

/**
 * This class is a child class of Node, and defines a sortableNode, which has sorting features to create a linked list.
 *
 * @author Padmanabh Kaushik
 * @version 3/19/2024
 */
public class SortableNode<E extends Comparable<E>> extends Node<E> {
    

    /**
     * Default constructor for SortableNode class.
     */
    public SortableNode(E values) {
        super(values);
    }

    /**
     * Sortable node constructor that constructs a linked list using an array list.
     */
    public SortableNode(ArrayList<E> values) {
        super(values);
    }

    /**
     * Sorts elements in a linked list such that all items greater than a value k are on one side of the list, and those less than
     * or equal are on another side of the list
     * @param value separating point to carry on the partition
     */
    public void partition(E value){
        //Create two blank array lists
        ArrayList<E> lessThanEqual = new ArrayList<>();
        ArrayList<E> greaterThan = new ArrayList<>();
        //Start with the first node
        Node<E> current = this;
        //Separate the elements based on the segregation point
        while(current != null){
            if(current.val.compareTo(value)<=0){
                lessThanEqual.add(value);
            }
            if(current.val.compareTo(value)>0){
                greaterThan.add(value);
            }
            current = current.next;
        }
        //convert arrayLists to linked lists
        Node lessNode = new Node(lessThanEqual);
        Node greaterNode = new Node(greaterThan);
        //Join the lists together
        if(lessNode.head != null){
            current = lessNode.head;
            while(current.next != null){
                current = current.next;
            }
            current.next = greaterNode.head;
            head = lessNode.head;
        }
    }

    /**
     * Sorts the linked list in an ascending order
     */
    public void sort(){

        if (this == null || this.next == null) {
            // List is empty or contains only one element, already sorted
            return;
        }

        Node<E> sorted = this;
        head = this.next;
        sorted.next = null;

        Node<E> current = head;
        while(current != null){
            Node<E> next = current.next;
            Node<E> prev = null;
            Node<E> temp = sorted;

            while(temp != null && temp.val.compareTo(current.val)<0){
                prev = temp;
                temp = temp.next;
            }

            if (prev == null) {
                // Insert at the beginning of the sorted sublist
                current.next = sorted;
                sorted = current;
                head = sorted;
            } else {
                // Insert after prev
                current.next = prev.next;
                prev.next = current;
            }

            // Move to the next unsorted node
            current = next;
        }

    }

    /**
     * Sorts the linked list, and removes any duplicacies.
     */
    public void uniqueSort(){

        sort();

        Node<E> current = this;

        while(current != null && current.next != null){
            if(current.val.equals(current.next.val)){
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
        }

    }
}
