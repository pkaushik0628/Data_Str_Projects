

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class tests methods within River class.
 *
 * @author  Padmanabh Kaushik
 * @version 2/11/24
 */
public class RiverTest
{
    /**
     * Blank constructor for test class RiverTest
     */
    public RiverTest()
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
     * Tests if the river of a given length is initialized
     */
    @Test
    public void riverTest(){
        River river = new River(10);
        assertEquals(10, river.getLength());
        
        River river1 = new River(7);
        assertEquals(7, river1.getLength());
        
        River river2 = new River(15);
        assertEquals(15, river2.getLength());
    }
    
    /**
     * Tests the numEmpty() method
     */
    @Test
    public void numEmptyTest(){
        River river = new River(5);
        river.river[0] = new Bear(5, Animal.Gender.MALE);
        river.river[1] = null;
        river.river[2] = new Bear(5, Animal.Gender.MALE);
        river.river[3] = null;
        river.river[4] = new Bear(5, Animal.Gender.MALE);
        
        assertEquals(2, river.numEmpty());
        
    }
    
    /**
     * Tests addRandom() method
     */
    @Test
    public void addRandomTest(){
        River river = new River(5);
        river.river[0] = new Bear(5, Animal.Gender.MALE);
        river.river[1] = null;
        river.river[2] = new Bear(3, Animal.Gender.MALE);
        river.river[3] = null;
        river.river[4] = new Bear(2, Animal.Gender.MALE); 
        
        assertTrue(river.addRandom(new Bear(4, Animal.Gender.MALE)));
        assertTrue(river.addRandom(new Bear(7, Animal.Gender.MALE)));
        assertFalse(river.addRandom(new Bear(1, Animal.Gender.MALE)));
    }
    
    /**
     * Tests the updateCell() method
     */
    @Test
    public void updateCellTest(){
        
        River river = new River(5);
        river.river[0] = new Bear(5, Animal.Gender.MALE);
        river.river[1] = null;
        river.river[2] = new Bear(3, Animal.Gender.MALE);
        river.river[3] = new Fish(4, Animal.Gender.MALE);
        river.river[4] = new Bear(2, Animal.Gender.MALE); 
        
        boolean r;
        river.updateCell(1);
        
        if(river.river[1] == null) r = true;
        else r = false;
        
        assertTrue(r);
        
    }
    
    /**
     * Tests the method updateRiver()
     */
    @Test
    public void testUpdateRiver(){
        River river = new River(5);
        river.river[0] = new Bear(9, Animal.Gender.MALE);
        river.river[1] = null;
        river.river[2] = new Bear(9, Animal.Gender.MALE);
        river.river[3] = new Fish(9, Animal.Gender.MALE);
        river.river[4] = new Bear(9, Animal.Gender.MALE);
        
        river.updateRiver();
        assertNull(river.river[0]);
        assertNull(river.river[1]);
        assertNull(river.river[2]);
        assertNull(river.river[3]);
        assertNull(river.river[4]);
    }
    
    /**
     * Tests toString() for river 
     */
    @Test
    public void testToString(){
        River river = new River(5);
        river.river[0] = new Bear(5, Animal.Gender.MALE);
        river.river[1] = null;
        river.river[2] = new Bear(3, Animal.Gender.MALE);
        river.river[3] = new Fish(4, Animal.Gender.MALE);
        river.river[4] = new Bear(2, Animal.Gender.MALE);
        
        assertEquals("BM5 -- BM3 FM4 BM2 ", river.toString());
    }
}
