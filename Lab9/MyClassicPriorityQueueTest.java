

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class tests the methods in the class MyClassicPriorityQueueTest, namely add(E item), poll(), decreaseKey(T target, T smallerValue).
 *
 * @author  Padmanabh Kaushik
 * @version 05/02/2024
 */
public class MyClassicPriorityQueueTest
{
    /**
     * Default constructor for test class MyClassicPriorityQueueTest
     */
    public MyClassicPriorityQueueTest()
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
     * This is a text class for the overridden add() method
     */
    @Test
    public void testAdd(){
        //Test add on a queue if integers
        MyClassicPriorityQueue<Integer> array = new MyClassicPriorityQueue();
        array.add(20);
        array.add(15);
        array.add(5);
        array.add(14);
        //check and match the location of 20
        assertEquals(3, array.getMap().get(20));
        //check and match the location of 15
        assertEquals(2, array.getMap().get(15));
        //check and match the location of 14
        assertEquals(1, array.getMap().get(14));
        
        //Part3:
        MyClassicPriorityQueue<WeightedElement<Integer, Integer>> array2 = new MyClassicPriorityQueue();
        //Create weighted elements
        WeightedElement<Integer, Integer> e1 = new WeightedElement(20,20);
        WeightedElement<Integer, Integer> e2 = new WeightedElement(15, 15);
        WeightedElement<Integer, Integer> e3 = new WeightedElement(5, 5);
        //add elements
        array2.add(e1);
        array2.add(e2);
        array2.add(e3);
        assertEquals(0, array2.getMap().get(e3));
        //<String, String>
        MyClassicPriorityQueue<WeightedElement<String, String>> array3 = new MyClassicPriorityQueue();
        //create weighted elements
        WeightedElement<String, String> e4 = new WeightedElement("A","A");
        WeightedElement<String, String> e5 = new WeightedElement("B", "B");
        WeightedElement<String, String> e6 = new WeightedElement("C", "C");
        //add elements to my priority queue 
        array3.add(e4);
        array3.add(e5);
        array3.add(e6);
        assertEquals(0, array3.getMap().get(e4));
        assertEquals(1, array3.getMap().get(e5));
        assertEquals(2, array3.getMap().get(e6));
    }
    
    /**
     * This is a test class for the overridden poll() method
     */
    @Test
    public void testPoll(){
        //create and test on a queue of integers
        MyClassicPriorityQueue<Integer> array2 = new MyClassicPriorityQueue();
        array2.add(1);
        array2.add(2);
        array2.add(3);
        array2.add(4);
        array2.add(5);
        array2.add(6);
        array2.add(7);
        array2.poll();
        //In terms of array: assertEquals(2, array2.getArrayList().get(0));
        assertEquals(0, array2.getMap().get(2));
        //In terms of array: assertEquals(7, array2.getArrayList().get(3));
        assertEquals(3, array2.getMap().get(7));
        //In terms of array: assertEquals(6, array2.getArrayList().get(5));
        assertEquals(5, array2.getMap().get(6));
        
        //Part3:
        //Test with <Integer, Integer>
        MyClassicPriorityQueue<WeightedElement<Integer, Integer>> array3 = new MyClassicPriorityQueue();
        //create three weighted elements
        WeightedElement<Integer, Integer> e1 = new WeightedElement(20,20);
        WeightedElement<Integer, Integer> e2 = new WeightedElement(15, 15);
        WeightedElement<Integer, Integer> e3 = new WeightedElement(5, 5);
        //add elements to my classic priority queue 
        array3.add(e1);
        array3.add(e2);
        array3.add(e3);
        //poll
        array3.poll();
        //test
        assertEquals(0, array3.getMap().get(e2));
        //Test with <String, String> weighted elements
        MyClassicPriorityQueue<WeightedElement<String, String>> array4 = new MyClassicPriorityQueue();
        //create weighted elements
        WeightedElement<String, String> e4 = new WeightedElement("A","A");
        WeightedElement<String, String> e5 = new WeightedElement("B", "B");
        WeightedElement<String, String> e6 = new WeightedElement("C", "C");
        //add elements to my classic priority queue 
        array4.add(e4);
        array4.add(e5);
        array4.add(e6);
        //poll
        array4.poll();
        //test
        assertEquals(0, array4.getMap().get(e5));
    }
    
    /**
     * This is a test class for decreaseKey() method
     */
    @Test
    public void testDecreaseKey(){
        //Integer elements in my priority queue
        MyClassicPriorityQueue<Integer> array = new MyClassicPriorityQueue();
        array.add(20);
        array.add(15);
        array.add(5);
        array.add(14);
        array.add(17);
        array.decreaseKey(14,2);
        assertEquals(0, array.getMap().get(2));
        
        //String elements in my priority queue
        MyClassicPriorityQueue<String> array2 = new MyClassicPriorityQueue();
        array2.add("A");
        array2.add("L");
        array2.add("B");
        array2.add("H");
        array2.add("M");
        array2.decreaseKey("M", "C");
        assertEquals(1, array2.getMap().get("C"));
        
        //null case
        assertNull(array2.decreaseKey("A", "Z"));
        
        //Part3:
        MyClassicPriorityQueue<WeightedElement<Integer, Integer>> array3 = new MyClassicPriorityQueue();
        //Weighted element creation
        WeightedElement<Integer, Integer> e1 = new WeightedElement(20,20);
        WeightedElement<Integer, Integer> e2 = new WeightedElement(15, 15);
        WeightedElement<Integer, Integer> e3 = new WeightedElement(5, 5);
        //add elements
        array3.add(e1);
        array3.add(e2);
        array3.add(e3);
        //weighted element to replace
        WeightedElement<Integer, Integer> e4 = new WeightedElement(2, 2);
        array3.decreaseKey(e2, e4);
        assertEquals(0, array3.getMap().get(e4));
        
        
        //Using String, String weighted element
        MyClassicPriorityQueue<WeightedElement<String, String>> array4 = new MyClassicPriorityQueue();
        //create weighted elements
        WeightedElement<String, String> e5 = new WeightedElement("B","B");
        WeightedElement<String, String> e6 = new WeightedElement("H", "H");
        WeightedElement<String, String> e7 = new WeightedElement("D", "D");
        //add elements
        array4.add(e5);
        array4.add(e6);
        array4.add(e7);
        //create new weighted element
        WeightedElement<String, String> e8 = new WeightedElement("A", "A");
        array4.decreaseKey(e6, e8);
        assertEquals(0, array4.getMap().get(e8));
    }
}
