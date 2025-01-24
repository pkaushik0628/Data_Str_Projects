
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class tests methods in class ArrayBasedStack, namely toString(), peek(), pop(), add(), isFull() ,and addExpandable().
 *
 * @author  Padmanabh Kaushik
 * @version 5/4/2024
 */
public class ArrayBasedStackTest
{
    /**
     * Default constructor for test class ArrayBasedStackTest
     */
    public ArrayBasedStackTest()
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
     * This is a test method for toString()
     */
    @Test
    public void testToString(){
        ArrayBasedStack<Integer> stack = new ArrayBasedStack(5);
        stack.add(1);
        stack.add(2);
        stack.add(3);
        assertEquals("1, 2, 3, -, -", stack.toString());
    }

    
    /**
     * This is a test method for peek()
     */
    @Test
    public void testPeek(){
        ArrayBasedStack<Integer> stack = new ArrayBasedStack(5);
        stack.add(1);
        stack.add(2);
        stack.add(3);
        assertEquals(3, stack.peek());

        ArrayBasedStack<String> stack1 = new ArrayBasedStack(5);
        stack1.add("A");
        stack1.add("B");
        stack1.add("C");
        assertEquals("C", stack1.peek());
    }

    /**
     * This is a test method for pop()
     */
    @Test
    public void testPop(){
        ArrayBasedStack<Integer> stack = new ArrayBasedStack(5);
        stack.add(1);
        stack.add(2);
        stack.add(3);
        assertEquals(3, stack.pop());
        assertEquals("1, 2, -, -, -", stack.toString());

        ArrayBasedStack<String> stack1 = new ArrayBasedStack(5);
        stack1.add("A");
        stack1.add("B");
        stack1.add("C");
        stack1.pop();
        assertEquals("A, B, -, -, -", stack1.toString());
    }

    /**
     * This is a test method for clear
     */
    @Test
    public void clear(){
        ArrayBasedStack<Integer> stack = new ArrayBasedStack(5);
        //add elements
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.clear();
        //clear all elements
        assertEquals("-, -, -, -, -", stack.toString());
    }

    /**
     * This is a test method for clear
     */
    @Test
    public void isFull(){
        ArrayBasedStack<Integer> stack = new ArrayBasedStack(5);
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        //fill up the stack and check
        assertTrue(stack.isFull());

        ArrayBasedStack<String> stack1 = new ArrayBasedStack(5);
        stack1.add("A");
        stack1.add("B");
        stack1.add("C");
        stack1.add("D");
        stack1.add("E");
        //fill up with strings and check
        assertTrue(stack1.isFull());

    }
    
    /**
     * This is a test method for addExpandable
     */
    @Test
    public void testAddExpandable(){
        ArrayBasedStack<Integer> stack = new ArrayBasedStack(2);
        stack.addExpandable(1);
        stack.addExpandable(2);
        stack.addExpandable(3);
        assertEquals("1, 2, 3, -", stack.toString());
        stack.addExpandable(4);
        //get beyond the size of the original array
        stack.addExpandable(5);
        assertEquals("1, 2, 3, 4, 5, -, -, -", stack.toString());
    }
}
