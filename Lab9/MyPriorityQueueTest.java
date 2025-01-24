
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.PriorityQueue;

/**
 * The test class MyPriorityQueueTest tests the funcality of the methods in of MyPriorityQueue. Each test class uses generic cases for
 * testing methods of MyPriorityQueue individually and then implements cases where the results of a method are compared to that with the
 * java priority queue. For the comparison between my priority queue and java priority queue, WeightedElement<Integer, Integer> and 
 * WeightedElement<String, String> are used.
 *
 * @author  Padmanabh Kaushik
 * @version 04/30/2024
 */
public class MyPriorityQueueTest
{
    /**
     * Default constructor for test class MyPriorityQueueTest
     */
    public MyPriorityQueueTest()
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
     * This is a test method for add()
     */
    @Test
    public void testAdd(){
        //Test using general elementents
        //Create a priority queue
        MyPriorityQueue<Integer> array = new MyPriorityQueue();
        //add one element
        array.add(20);
        assertEquals(20, array.getArrayList().get(0));
        //add second element s.t. root > second element and requires a shift
        array.add(15);
        //Single swap shift cases
        assertEquals(15, array.getArrayList().get(0));
        array.add(5);
        assertEquals(5, array.getArrayList().get(0));
        array.add(14);
        assertEquals(14, array.getArrayList().get(1));
        array.add(12);
        assertEquals(12, array.getArrayList().get(1));
        array.add(11);
        assertEquals(11, array.getArrayList().get(2));
        array.add(10);
        assertEquals(10, array.getArrayList().get(2));
        //Double swap shift case
        array.add(9);
        assertEquals(9, array.getArrayList().get(1));
        assertEquals(12, array.getArrayList().get(3));
        
        //Part 3: Unit testing using Java priority queue
        //Test with <Integer, Integer>
        MyPriorityQueue<WeightedElement<Integer, Integer>> array2 = new MyPriorityQueue();
        PriorityQueue<WeightedElement<Integer, Integer>> compArray2 = new PriorityQueue();
        //create three weighted elements
        WeightedElement<Integer, Integer> e1 = new WeightedElement(20,20);
        WeightedElement<Integer, Integer> e2 = new WeightedElement(15, 15);
        WeightedElement<Integer, Integer> e3 = new WeightedElement(5, 5);
        //add elements to my priority queue 
        array2.add(e1);
        array2.add(e2);
        array2.add(e3);
        //add elements to java priority queue
        compArray2.add(e1);
        compArray2.add(e2);
        compArray2.add(e3);
        //compare the results from java priority queue and my priority queue
        assertEquals(array2.getArrayList().get(0).getElement(), compArray2.peek().getElement());
        //Test with <String, String>
        //create priority queues
        MyPriorityQueue<WeightedElement<String, String>> array3 = new MyPriorityQueue();
        PriorityQueue<WeightedElement<String, String>> compArray3 = new PriorityQueue();
        //create weighted elements
        WeightedElement<String, String> e4 = new WeightedElement("A","A");
        WeightedElement<String, String> e5 = new WeightedElement("B", "B");
        WeightedElement<String, String> e6 = new WeightedElement("C", "C");
        //add elements to my priority queue 
        array3.add(e4);
        array3.add(e5);
        array3.add(e6);
        //add elements to java priority queue
        compArray3.add(e4);
        compArray3.add(e5);
        compArray3.add(e6);
        assertEquals(array3.getArrayList().get(0).getElement(), compArray3.peek().getElement());
    }

    /**
     * This is a test method for poll()
     */
    @Test
    public void testPoll(){
        //poll at 2 level tree
        MyPriorityQueue<Integer> array = new MyPriorityQueue();
        array.add(1);
        array.add(2);
        array.add(3);
        array.poll();
        assertEquals(2, array.getArrayList().get(0));
        assertEquals(3, array.getArrayList().get(1));
        array.poll();
        assertEquals(3, array.getArrayList().get(0));
        //poll at three level tree
        MyPriorityQueue<Integer> array2 = new MyPriorityQueue();
        array2.add(1);
        array2.add(2);
        array2.add(3);
        array2.add(4);
        array2.add(5);
        array2.add(6);
        array2.add(7);
        array2.poll();
        assertEquals(2, array2.getArrayList().get(0));
        assertEquals(4, array2.getArrayList().get(1));
        assertEquals(7, array2.getArrayList().get(3));
        assertEquals(6, array2.getArrayList().get(5));
        
        //Part 3: Unit testing using Java priority queue
        //Test with <Integer, Integer>
        MyPriorityQueue<WeightedElement<Integer, Integer>> array3 = new MyPriorityQueue();
        PriorityQueue<WeightedElement<Integer, Integer>> compArray3 = new PriorityQueue();
        //create three weighted elements
        WeightedElement<Integer, Integer> e1 = new WeightedElement(20,20);
        WeightedElement<Integer, Integer> e2 = new WeightedElement(15, 15);
        WeightedElement<Integer, Integer> e3 = new WeightedElement(5, 5);
        //add elements to my priority queue 
        array3.add(e1);
        array3.add(e2);
        array3.add(e3);
        //add elements to java priority queue
        compArray3.add(e1);
        compArray3.add(e2);
        compArray3.add(e3);
        //compare the results from java priority queue and my priority queue
        assertEquals(array3.getArrayList().get(0).getElement(), compArray3.peek().getElement());
        //Test with <String, String>
        //create priority queues
        MyPriorityQueue<WeightedElement<String, String>> array4 = new MyPriorityQueue();
        PriorityQueue<WeightedElement<String, String>> compArray4 = new PriorityQueue();
        //create weighted elements
        WeightedElement<String, String> e4 = new WeightedElement("A","A");
        WeightedElement<String, String> e5 = new WeightedElement("B", "B");
        WeightedElement<String, String> e6 = new WeightedElement("C", "C");
        //add elements to my priority queue 
        array4.add(e4);
        array4.add(e5);
        array4.add(e6);
        //poll
        array4.poll();
        //add elements to java priority queue
        compArray4.add(e4);
        compArray4.add(e5);
        compArray4.add(e6);
        //poll
        compArray4.poll();
        //test
        assertEquals(array4.getArrayList().get(0).getElement(), compArray4.peek().getElement());
    }

    /**
     * This is a test method for isHeap()
     */
    @Test
    public void testIsHeap(){
        //Case1:
        MyPriorityQueue<Integer> array = new MyPriorityQueue();
        array.add(1);
        array.add(2);
        array.add(3);
        assertTrue(array.isHeap());
        //Case2:
        MyPriorityQueue<Integer> array2 = new MyPriorityQueue();
        array2.add(1);
        array2.add(2);
        array2.add(3);
        array2.add(4);
        array2.add(5);
        array2.add(6);
        array2.add(7);
        array2.poll();
        assertTrue(array2.isHeap());
    }

    /**
     * This is a test method for peek()
     */
    @Test
    public void testPeek(){
        MyPriorityQueue<Integer> array = new MyPriorityQueue();
        array.add(1);
        array.add(2);
        array.add(3);
        assertEquals(1, array.peek());
        
        MyPriorityQueue<Integer> array2 = new MyPriorityQueue();
        array2.add(31);
        array2.add(15);
        array2.add(67);
        array2.add(45);
        array2.add(12);
        array2.add(89);
        array2.add(7);
        assertEquals(7, array2.peek());
        
        //Part 3: Unit testing using Java priority queue
        //Test with <Integer, Integer>
        MyPriorityQueue<WeightedElement<Integer, Integer>> array3 = new MyPriorityQueue();
        PriorityQueue<WeightedElement<Integer, Integer>> compArray3 = new PriorityQueue();
        //create three weighted elements
        WeightedElement<Integer, Integer> e1 = new WeightedElement(20,20);
        WeightedElement<Integer, Integer> e2 = new WeightedElement(15, 15);
        WeightedElement<Integer, Integer> e3 = new WeightedElement(5, 5);
        //add elements to my priority queue 
        array3.add(e1);
        array3.add(e2);
        array3.add(e3);
        //add elements to java priority queue
        compArray3.add(e1);
        compArray3.add(e2);
        compArray3.add(e3);
        //compare the results from java priority queue and my priority queue
        assertEquals(array3.peek().getElement(), compArray3.peek().getElement());
        //Test with <String, String>
        //create priority queues
        MyPriorityQueue<WeightedElement<String, String>> array4 = new MyPriorityQueue();
        PriorityQueue<WeightedElement<String, String>> compArray4 = new PriorityQueue();
        //create weighted elements
        WeightedElement<String, String> e4 = new WeightedElement("A","A");
        WeightedElement<String, String> e5 = new WeightedElement("B", "B");
        WeightedElement<String, String> e6 = new WeightedElement("C", "C");
        //add elements to my priority queue 
        array4.add(e4);
        array4.add(e5);
        array4.add(e6);
        //poll
        array4.poll();
        //add elements to java priority queue
        compArray4.add(e4);
        compArray4.add(e5);
        compArray4.add(e6);
        //poll
        compArray4.poll();
        //test
        assertEquals(array4.peek().getElement(), compArray4.peek().getElement());
    }
}
