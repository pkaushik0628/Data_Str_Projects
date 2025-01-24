

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * The test class tests methods defined within the node class, namely toString(), addToFront(E val), addToBack(E val), and rotate(int k) 
 *
 * @author  Padmanabh Kaushik
 * @version 3/19/2024
 */
public class NodeTest
{
    /**
     * Default constructor for test class NodeTest
     */
    public NodeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    /**
     * This is test method for overridden toString() method
     */
    @Test
    public void testToString(){
        //Create an array list
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        //Create a linked list
        Node n1 = new Node(numbers);
        //Verify result using toString()
        assertEquals("1, 2, 3", n1.toString());
    }
    
    /**
     * This is a test method for addToBack() method
     */
    @Test
    public void testAddToBack(){
        //Create an array list
       ArrayList<Integer> numbers = new ArrayList<>();
       numbers.add(2);
       Node n1 = new Node(numbers);
       //add numbers (nodes) to the back
       n1.addToBack(1);
       //verify the result
       assertEquals("2, 1", n1.toString());
       //add more elements to the list
       n1.addToBack(3);
       n1.addToBack(4);
       n1.addToBack(5);
       //verify the result
       assertEquals("2, 1, 3, 4, 5", n1.toString());
       
    }
    
    /**
     * This is a test method for addToFront() method
     */
    @Test
    public void testAddToFront(){
        //Create a node
       Node n1 = new Node(2);
       //add another node to the front
       n1.addToFront(1);
       //verify the result 
       assertEquals("1, 2", n1.head.toString()); 
       //Add another node to the front
       n1.addToFront(3);
       //verify the result
       assertEquals("3, 1, 2", n1.head.toString()); 
    }
    
    /**
     * This is a test method for rotate() method
     */
    @Test
    public void testRotate(){
        //Create an array list
       ArrayList<Integer> numbers = new ArrayList<>();
       numbers.add(1);
       numbers.add(2);
       numbers.add(3);
       numbers.add(4);
       numbers.add(5);
       //create a linked list
       Node n1 = new Node(numbers);
       //Rotate by 2
       n1.rotate(2);
       //verify the result
       assertEquals("4, 5, 1, 2, 3", n1.head.toString());
       //rotate by 0
       n1.rotate(0);
       //verify the result
       assertEquals("4, 5, 1, 2, 3", n1.head.toString());
    }
}
