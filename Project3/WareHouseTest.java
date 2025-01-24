
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class tests methods in WareHouse class namely hasSpace(), toString(), logStatus(), and action().
 *
 * @author  Padmanabh Kaushik
 * @version 5/4/2024
 */
public class WareHouseTest
{
    /**
     * Default constructor for test class WareHouseTest
     */
    public WareHouseTest()
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
     * This is a test method for hasSpace()
     */
    @Test
    public void testHasSpace(){
        WareHouse w1 = new WareHouse("W1", new float[] {34, 56}, 3, 15, new float[][] {{45, 67}, {89, 100}, {22, 11}});
        assertEquals(0, w1.hasSpace());
        Truck t1 = new Truck(5, "T1");
        w1.addTruck(t1);
        assertEquals(1, w1.hasSpace());
        Truck t2 = new Truck(4, "T2");
        w1.addTruck(t2);
        assertEquals(2, w1.hasSpace());
        Truck t3 = new Truck(3, "T3");
        w1.addTruck(t3);
        Truck t4 = new Truck(5, "T4");
        assertEquals(-1, w1.hasSpace());
    }

    /**
     * This is a test method for toString()
     */
    @Test
    public void testToString(){
        //create warehouse
        WareHouse w1 = new WareHouse("W1", new float[] {34, 56}, 3, 15, new float[][] {{45, 67}, {89, 100}, {22, 11}});
        //Create trucks
        Truck t1 = new Truck(5, "T1");
        Truck t2 = new Truck(4, "T2");
        Truck t3 = new Truck(3, "T3");
        assertEquals("- - - ", w1.toString());
        //add in trucks
        w1.addTruck(t1);
        w1.addTruck(t2);
        w1.addTruck(t3);
        //check is the trucks are in the warehouse
        assertEquals("T1 T2 T3 ", w1.toString());
        Truck t4 = new Truck(4, "T4");
        //add a new truck to the warehouse
        //the warehouse has no space so it should be added to the waitline
        w1.addTruck(t4);
        //check waitline
        assertEquals(t4, w1.getWaitLine().peek());
        Truck t5 = new Truck(4, "T5");
        w1.addTruck(t5);
        assertEquals(t5, w1.getWaitLine().peek());
    }

    /**
     * This is a test method for logStatus()
     */
    @Test
    public void testLogStatus(){
        //create warehouses and trucks
        WareHouse w1 = new WareHouse("W1", new float[] {34, 56}, 3, 15, new float[][] {{45, 67}, {89, 100}, {22, 11}});
        Truck t1 = new Truck(5, "T1");
        Truck t2 = new Truck(4, "T2");
        Truck t3 = new Truck(3, "T3");
        //add trucks to the warehouse
        w1.addTruck(t1);
        w1.addTruck(t2);
        w1.addTruck(t3);
        //check the log
        assertEquals("Warehouse: W1 Occupancy: T1 T2 T3 ", w1.log_status());
    }

    /**
     * This is a test method for action()
     */
    @Test
    public void testAction(){
        //create warehouses and trucks
        WareHouse w1 = new WareHouse("W1", new float[] {0, 0}, 3, 15, new float[][] {{0, 0}, {3, 4}}, 1);
        WareHouse w2 = new WareHouse("W2", new float[] {3,4}, 3, 15, new float[][] {{0, 0}, {3, 4}}, 1);
        WareHouse[] warehouses = {w1, w2};
        float[][] destinations = {{0, 0}, {3, 4}};
        Truck t1 = new Truck (5, new float[] {1,0}, destinations, warehouses, "T1");
        //call action on truck 1
        t1.action();
        t1.action();
        //check is the truck is added to the warehouse
        assertEquals("T1 - - ", w1.toString());
        //t1.action();
        w1.action();
        assertEquals("W1-14 - - - - ", t1.toArrayString());
        //t1.action();
        w1.action();
        assertEquals("W1-14 W1-13 - - - ", t1.toArrayString());
        //t1.action();
        w1.action();
        assertEquals("W1-14 W1-13 W1-12 - - ", t1.toArrayString());
        //t1.action();
        w1.action();
        assertEquals("W1-14 W1-13 W1-12 W1-11 - ", t1.toArrayString());
        //Bring in one more truck
        Truck t2 = new Truck (5, new float[] {1,0}, destinations, warehouses, "T2");
        //call action on truck 2 for two cycles
        t2.action();
        t2.action();
        //Check if the truck is added to the warehouse
        assertEquals("T1 T2 - ", w1.toString());
        //check the status of the warehouse
        w1.action();
        assertEquals("W1-14 W1-13 W1-12 W1-11 W1-10 ", t1.toArrayString());
        assertEquals("W1-9 - - - - ", t2.toArrayString());
        w1.action();
        assertEquals("- T2 - ", w1.toString());
        t1.action();
        assertArrayEquals(new float[] {3,4}, t1.getNextDest());
        
    }
}
