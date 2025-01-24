

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test class tests different methods for the Bear class. 
 *
 * @author  Padmanabh Kaushik
 * @version 2/11/24
 */
public class BearTest
{
    
    /**
     * Blank constructor for the test class
     */
    public BearTest()
    {
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    /**
     * This method tests incrAge method
     */
    @Test
    public void testIncrAge(){
        Bear bear = new Bear(5, Animal.Gender.MALE);
        bear.incrAge();
        //increments the age of the bear by 1 and matching by the calculated and experimental results. Performed for a total of 3 times.
        assertEquals(6, bear.getAge());
        bear.incrAge();
        assertEquals(7, bear.getAge());
        bear.incrAge();
        assertEquals(8, bear.getAge());
    }
    
    /**
     * This method tests the maxAge method
     */
    @Test
    public void testMaxAge(){
        Bear bear = new Bear(9, Animal.Gender.FEMALE);
        assertTrue(bear.maxAge());
        Bear bear1 = new Bear(7, Animal.Gender.FEMALE);
        assertFalse(bear1.maxAge());
    }
    
    /**
     * This method tests the getStrength() method
     */
    @Test
    public void testStrength(){
        Bear bear = new Bear(3, Animal.Gender.MALE);
        assertEquals(4, bear.getStrength());
        Bear bear1 = new Bear(4, Animal.Gender.MALE);
        assertEquals(5, bear1.getStrength());
        Bear bear2 = new Bear(6, Animal.Gender.MALE);
        assertEquals(3, bear2.getStrength());
    }
}
