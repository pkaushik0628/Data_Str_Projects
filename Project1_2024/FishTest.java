

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The class FishTest tests the methods - incrAge() and maxAge() - defined within the Fish class.
 *
 * @author  Padmanabh Kaushik
 * @version 2/11/24
 */
public class FishTest
{
    /**
     * Default constructor for test class FishTest
     */
    public FishTest()
    {
    }

    @Test
    public void testIncrAge(){
        Fish fish = new Fish(3, Animal.Gender.MALE);
        fish.incrAge();
        assertEquals(4, fish.getAge());
    }
    
    @Test
    public void testMaxAge(){
        Fish fish = new Fish(4, Animal.Gender.FEMALE);
        assertTrue(fish.maxAge());
    }
}
