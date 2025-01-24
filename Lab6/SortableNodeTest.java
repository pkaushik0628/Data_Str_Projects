
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * The test class tests methods defined within the SortableNode class, namely partition(), sort(), and uniqueSort().
 *
 * @author  Padmanabh Kaushik
 * @version 3/19/2024
 */
public class SortableNodeTest
{
    /**
     * Default constructor for test class SortableNodeTest
     */
    public SortableNodeTest()
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
     * This is a test method for partition().
     */
    @Test
    public void testPartition(){
        //Create an array list
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        //create the sortable node
        SortableNode n1 = new SortableNode(numbers);
        //implement partition with k = 3 
        n1.partition(3);
        assertEquals("1, 2, 2, 3, 4, 5", n1.toString());
        //Modify the list
        numbers.add(52);
        numbers.add(51);
        numbers.add(50);
        //Create a new sortable node
        SortableNode n2 = new SortableNode(numbers);
        //Partition by a different number and compare the value
        n2.partition(5);
        assertEquals("1, 2, 2, 3, 4, 5, 52, 51, 50", n2.toString());

    }

    /**
     * This is a test method for testing sort()
     */
    @Test
    public void testSort(){
        //Create a linked list from an array list
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(7);
        numbers.add(3);
        numbers.add(8);
        numbers.add(10);
        numbers.add(10);
        numbers.add(1);  
        SortableNode n1 = new SortableNode(numbers);
        //Perform sorting operation
        n1.sort();
        //Compare the result
        assertEquals("1, 3, 7, 8, 10, 10", n1.head.toString());
        numbers.add(1); 
        SortableNode n2 = new SortableNode(numbers);
        //perform sort
        n2.sort();
        //compare the results
        assertEquals("1, 1, 3, 7, 8, 10, 10", n2.head.toString());

    }

    /**
     * This is a test method for testing uniqueSort()
     */
    @Test
    public void testUniqueSort(){
        //Create a new linked list from an array list
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(7);
        numbers.add(3);
        numbers.add(8);
        numbers.add(10);
        numbers.add(10);
        numbers.add(1); 
        SortableNode n1 = new SortableNode(numbers);
        //perform uniquesort
        n1.uniqueSort();
        //compare the results
        assertEquals("1, 3, 7, 8, 10", n1.head.toString());
    }
}
