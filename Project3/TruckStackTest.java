

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test class tests mthods in Truck Stack namely add(), peek(), pop(), toString(), and clear().
 *
 * @author  Padmanabh Kaushik
 * @version 05/02/2024
 */
public class TruckStackTest
{
    /**
     * Default constructor for test class TruckStackTest
     */
    public TruckStackTest()
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
     * This is a test method for add(Shipment s)
     */
    @Test
    public void testAdd(){
        TruckStack stack = new TruckStack(3);
        Shipment s1 = new Shipment("S1");
        Shipment s2 = new Shipment("S2");
        Shipment s3 = new Shipment("S3");
        stack.add(s1);
        assertEquals(s1, stack.peek());
        stack.add(s2);
        assertEquals(s2, stack.peek());
        stack.add(s3);
        assertEquals(s3, stack.peek());
    }
    
    /**
     * This is a test method for peek()
     */
    @Test
    public void testPeek(){
        TruckStack stack = new TruckStack(3);
        Shipment s1 = new Shipment("S1");
        Shipment s2 = new Shipment("S2");
        Shipment s3 = new Shipment("S3");
        stack.add(s1);
        assertEquals(s1, stack.peek());
        stack.add(s2);
        assertEquals(s2, stack.peek());
        stack.add(s3);
        assertEquals(s3, stack.peek());
    }
    
    /**
     * This is a test method for pop()
     */
    @Test
    public void testPop(){
        TruckStack stack = new TruckStack(3);
        Shipment s1 = new Shipment("S1");
        Shipment s2 = new Shipment("S2");
        Shipment s3 = new Shipment("S3");
        //add shipments to the stack
        stack.add(s1);
        stack.add(s2);
        stack.add(s3);
        //pop one after another
        assertEquals(s3, stack.peek());
        stack.pop();
        assertEquals(s2, stack.peek());
        stack.pop();
        assertEquals(s1, stack.peek());
    }
    
    /**
     * This is a test method for peek()
     */
    @Test
    public void testIsFull(){
        TruckStack stack = new TruckStack(3);
        Shipment s1 = new Shipment("S1");
        Shipment s2 = new Shipment("S2");
        Shipment s3 = new Shipment("S3");
        stack.add(s1);
        //Stack should not be full at this point, so result should be false
        assertFalse(stack.isFull());
        stack.add(s2);
        stack.add(s3);
        //Stack should be full at this point, so result should be true
        assertTrue(stack.isFull());
    }
    
    /**
     * This is a test method for toString()
     */
    @Test
    public void testToString(){
        TruckStack stack = new TruckStack(3);
        Shipment s1 = new Shipment("S1");
        Shipment s2 = new Shipment("S2");
        Shipment s3 = new Shipment("S3");
        //add shipments to the stack
        stack.add(s1);
        stack.add(s2);
        stack.add(s3);
        //make string and check
        assertEquals("S1, S2, S3", stack.toString());
    }
    
    /**
     * This is a test method for clear()
     */
    @Test
    public void testClear(){
        TruckStack stack = new TruckStack(3);
        Shipment s1 = new Shipment("S1");
        Shipment s2 = new Shipment("S2");
        Shipment s3 = new Shipment("S3");
        //add shipments to the stack
        stack.add(s1);
        stack.add(s2);
        stack.add(s3);
        //Clear the stack
        stack.clear();
        //make string and check
        assertNull(stack.peek());
    }
}
