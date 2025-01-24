import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is a test class for unit testing REAL methods in Animal class. Since animal is an abstract class, instances of sub class Fish and Bear 
 * have been created to test methods in animal class.
 *
 * @author  Padmanabh Kaushik
 * @version 2/11/24
 */
public class AnimalTest
{
    /**
     * Default constructor for test class AnimalTest
     */
    public AnimalTest()
    {
    }

    /**
     * This test method verifies the functioning of the getAge() method
     */
    @Test
    public void getAgeTest(){
        Bear bear = new Bear(7, Animal.Gender.MALE);
        assertEquals(7, bear.getAge());
        
        Fish fish = new Fish(4, Animal.Gender.FEMALE);
        assertEquals(4, fish.getAge());
        
        Bear bear1 = new Bear(8, Animal.Gender.FEMALE);
        assertEquals(8, bear1.getAge());
        
    }
    
    /**
     * This is a test method to verify if the toString method in the animal class is functioning.
     */
    @Test
    public void testToString(){
        Fish fish = new Fish(4, Animal.Gender.FEMALE);
        assertEquals("FF4", fish.toString());
        
        Bear bear = new Bear(7, Animal.Gender.MALE);
        assertEquals("BM7", bear.toString());
    }
    
    //Abstract methods incrAge and maxAge cannot be tested at the Animal level, because Animal is an abstract class, 
    // and we cannot instantiate an animal object.
}
