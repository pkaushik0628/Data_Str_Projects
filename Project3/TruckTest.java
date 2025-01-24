
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class tests the methods of Truck class, namely hasSpace(), calculateDistance(), findNearestDestination(), action(), and WHIIndex().
 *
 * @author  Padmanabh Kaushik
 * @version 5/4/2025
 */
public class TruckTest
{
    /**
     * Default constructor for test class TruckTest
     */
    public TruckTest()
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
        //Truck which is not filled
        Truck t1 = new Truck(4, "T1", 3, new float[] {52, 52});
        assertTrue(t1.hasSpace());
        //Truck which is filled
        Truck t2 = new Truck(4, "T1", 4, new float[] {52, 52});
        assertFalse(t2.hasSpace());
    }

    /**
     * This is a test method for calculateDistance
     */
    @Test
    public void calculateDistance(){
        Truck t1 = new Truck(4, "T1", 3, new float[] {52, 52});
        assertEquals(5.0, t1.calculateDistance(new float[] {0,0}, new float[] {3,4}));
    }

    /**
     * This is a test method for findNearestDestination()
     */
    @Test
    public void testFindNearestDestination(){
        WareHouse w1 = new WareHouse("W1", new float[] {0, 0}, 3, 15, new float[][] {{0, 0}, {50, 50}, {25, 25}, {99,99}});
        WareHouse w2 = new WareHouse("W2", new float[] {50, 50}, 3, 15, new float[][] {{0, 0}, {50, 50}, {25, 25}, {99,99}});
        WareHouse w3 = new WareHouse("W3", new float[] {25, 25}, 3, 15, new float[][] {{0, 0}, {50, 50}, {25, 25}, {99,99}});
        WareHouse w4 = new WareHouse("W4", new float[] {99, 99}, 3, 15, new float[][] {{0, 0}, {50, 50}, {25, 25}, {99,99}});
        WareHouse[] warehouses = {w1, w2, w3, w4};
        float[][] destinations = {{0, 0}, {50, 50}, {25, 25}, {99,99}};
        Truck t1 = new Truck (5, new float[] {0,0}, destinations, warehouses, "T1");
        //when a pick up is closer
        assertArrayEquals(new float[] {25,25},t1.findNearestDestination(destinations, new float[] {0, 0}, new float[] {80, 80}));
        //when delivery is the closest
        assertArrayEquals(new float[] {15,15},t1.findNearestDestination(destinations, new float[] {0, 0}, new float[] {15, 15}));
    }

    /**
     * This is a test method for NoOfCyclesToDest()
     */
    @Test
    public void testNoOfCyclesToDest(){
        WareHouse w1 = new WareHouse("W1", new float[] {0, 0}, 3, 15, new float[][] {{0, 0}, {50, 50}, {25, 25}, {99,99}});
        WareHouse w2 = new WareHouse("W2", new float[] {50, 50}, 3, 15, new float[][] {{0, 0}, {50, 50}, {25, 25}, {99,99}});
        WareHouse w3 = new WareHouse("W3", new float[] {25, 25}, 3, 15, new float[][] {{0, 0}, {50, 50}, {25, 25}, {99,99}});
        WareHouse w4 = new WareHouse("W4", new float[] {99, 99}, 3, 15, new float[][] {{0, 0}, {50, 50}, {25, 25}, {99,99}});
        WareHouse[] warehouses = {w1, w2, w3, w4};
        float[][] destinations = {{0, 0}, {50, 50}, {25, 25}, {99,99}};
        Truck t1 = new Truck (5, new float[] {0,0}, destinations, warehouses, "T1");
        //no of cycles = 36
        assertEquals(36, t1.noCyclesToDest());
    }

    /**
     * This is a test method for action()
     */
    @Test
    public void testAction(){
        WareHouse w1 = new WareHouse("W1", new float[] {0, 0}, 3, 15, new float[][] {{0, 0}, {3, 4}});
        WareHouse w2 = new WareHouse("W2", new float[] {3,4}, 3, 15, new float[][] {{0, 0}, {3, 4}});
        WareHouse[] warehouses = {w1, w2};
        float[][] destinations = {{0, 0}, {3, 4}};
        Truck t1 = new Truck (5, new float[] {1,0}, destinations, warehouses, "T1");
        t1.action();
        t1.action();
        //check if trucks are added
        assertEquals("T1 - - ", w1.toString());
    }

    /**
     * This is a test method for findWHIndex()
     */
    @Test
    public void testWHIndex(){
        WareHouse w1 = new WareHouse("W1", new float[] {0, 0}, 3, 15, new float[][] {{0, 0}, {50, 50}, {25, 25}, {99,99}});
        WareHouse w2 = new WareHouse("W2", new float[] {50, 50}, 3, 15, new float[][] {{0, 0}, {50, 50}, {25, 25}, {99,99}});
        WareHouse w3 = new WareHouse("W3", new float[] {25, 25}, 3, 15, new float[][] {{0, 0}, {50, 50}, {25, 25}, {99,99}});
        WareHouse w4 = new WareHouse("W4", new float[] {99, 99}, 3, 15, new float[][] {{0, 0}, {50, 50}, {25, 25}, {99,99}}); 
        WareHouse[] warehouses = {w1, w2, w3, w4};
        float[][] destinations = {{0, 0}, {50, 50}, {25, 25}, {99,99}};
        Truck t1 = new Truck (5, new float[] {0,0}, destinations, warehouses, "T1");
        assertEquals(2, t1.findWHIndex());
    }
}
