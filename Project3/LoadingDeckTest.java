

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class tests methods in LoadingDeck class namely hasTruck(), loadTruck(), and unloadTruck(). 
 *
 * @author  Padmanabh Kaushik
 * @version 5/3/2024
 */
public class LoadingDeckTest
{
    /**
     * Default constructor for test class LoadingDeckTest
     */
    public LoadingDeckTest()
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
     * This is a test method for load() 
     */
    @Test
    public void testLoadTruck(){
        //create warehouse
        WareHouse w1 = new WareHouse("W1", new float[] {0, 0}, 3, 15, new float[][] {{0, 0}, {3, 4}});
        WareHouse w2 = new WareHouse("W2", new float[] {3,4}, 3, 15, new float[][] {{0, 0}, {3, 4}});
        //create arrays
        WareHouse[] warehouses = {w1, w2};
        float[][] destinations = {{0, 0}, {3, 4}};
        Truck t1 = new Truck (5, new float[] {1,0}, destinations, warehouses, "T1");
        //create loadiung deck
        LoadingDeck deck1 = new LoadingDeck(t1, w1);
        //put in a truck
        deck1.loadTruck(t1.getStorage());
        //check the internal arrays for loading operation
        assertEquals("W1-14 - - - - ", t1.toArrayString());
        deck1.loadTruck(t1.getStorage());
        assertEquals("W1-14 W1-13 - - - ", t1.toArrayString());
        deck1.loadTruck(t1.getStorage());
        assertEquals("W1-14 W1-13 W1-12 - - ", t1.toArrayString());
        deck1.loadTruck(t1.getStorage());
        assertEquals("W1-14 W1-13 W1-12 W1-11 - ", t1.toArrayString());
        deck1.loadTruck(t1.getStorage());
        assertEquals("W1-14 W1-13 W1-12 W1-11 W1-10 ", t1.toArrayString());
        assertFalse( deck1.loadTruck(t1.getStorage()));
    }
    
    /**
     * This is a test method for unload()
     */
    @Test
    public void testUnloadTruck(){
        //create warehouses
        WareHouse w1 = new WareHouse("W1", new float[] {0, 0}, 3, 15, new float[][] {{0, 0}, {3, 4}});
        WareHouse w2 = new WareHouse("W2", new float[] {3,4}, 3, 15, new float[][] {{0, 0}, {3, 4}});
        WareHouse[] warehouses = {w1, w2};
        float[][] destinations = {{0, 0}, {3, 4}};
        Truck t1 = new Truck (5, new float[] {2,4}, destinations, warehouses, "T1", 3, new float[] {3, 4});
        //call action on trucks
        t1.action();
        t1.action();
        //check unloading oprtaions
        assertEquals("W3-0 W3-1 W3-2 - - ", t1.toArrayString());
        LoadingDeck deck1 = new LoadingDeck(t1, w2);
        deck1.unloadTruck(t1.getStorage());
        assertEquals("W3-0 W3-1 - - - ", t1.toArrayString());
        deck1.unloadTruck(t1.getStorage());
        assertEquals("W3-0 - - - - ", t1.toArrayString());
        deck1.unloadTruck(t1.getStorage());
        assertEquals("- - - - - ", t1.toArrayString());
        assertFalse(deck1.unloadTruck(t1.getStorage()));
    }
    
    /**
     * This is a test method for hasTruck()
     */
    @Test
    public void testHasTruck(){
        WareHouse w1 = new WareHouse("W1", new float[] {0, 0}, 3, 15, new float[][] {{0, 0}, {3, 4}});
        WareHouse w2 = new WareHouse("W2", new float[] {3,4}, 3, 15, new float[][] {{0, 0}, {3, 4}});
        WareHouse[] warehouses = {w1, w2};
        float[][] destinations = {{0, 0}, {3, 4}};
        Truck t1 = new Truck (5, new float[] {2,4}, destinations, warehouses, "T1", 3, new float[] {3, 4});
        LoadingDeck deck1 = new LoadingDeck(t1, w2);
        //add a truck and check the result
        assertTrue(deck1.hasTruck());
    }
}
