

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class tests various methods in the Shipment class.
 *
 * @author  Padmanabh Kaushik
 * @version 05/01/2024
 */
public class ShipmentTest
{
    /**
     * Default constructor for test class ShipmentTest
     */
    public ShipmentTest()
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
     * This is a test method for toString() method of the Shipment class
     */
    @Test
    public void testToString(){
        // return id + ": Size:" + size + " : Destination: (" + destination[0] + "," + destination[1] + "), Status: " + status;
        //shipment waiting pickup
        Shipment s = new Shipment(4, "A", 15, new float[] {23,56}, new float[] {45,67}, new float[] {45,67});
        String exp = "A-15: Size:4 : Destination: (23.0,56.0), Status: Waiting Pickup";
        assertEquals(exp, s.toString());
        //Shipment delivered
        Shipment s1 = new Shipment(4, "A", 15, new float[] {23,56}, new float[] {45,67}, new float[] {23,56});
        String exp1 = "A-15: Size:4 : Destination: (23.0,56.0), Status: Delivered";
        assertEquals(exp1, s1.toString());
        //Shipment on the way
        Shipment s2 = new Shipment(4, "A", 15, new float[] {23,56}, new float[] {45,67}, new float[] {23,15});
        String exp2 = "A-15: Size:4 : Destination: (23.0,56.0), Status: On The Way";
    }
}
