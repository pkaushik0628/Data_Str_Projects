

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class VIPCustomerReviewTest tests the methods in the class VIPCustomerReview namely getCustomerName(), getLatestReview(),toString(),
 * equals(Object o), and hashCode().
 *
 * @author  Padmanabh Kaushik
 * @version 2/12/24
 */
public class VIPCustomerReviewTest
{
    /**
     * Default constructor for test class VIPCustomerReviewTest
     */
    public VIPCustomerReviewTest()
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
     * Tests method getCustomerName
     */
    @Test
    public void testVIPCustomerName(){
        VIPCustomerReview review1 = new VIPCustomerReview("John Miller", "This is good");
        assertEquals("John Miller", review1.getCustomerName());
        
        VIPCustomerReview review2 = new VIPCustomerReview("Selena Ryzada", "This is bad");
        assertEquals("Selena Ryzada", review2.getCustomerName());
        
        VIPCustomerReview review3 = new VIPCustomerReview("CS150", "This is amazing");
        assertEquals("CS150", review3.getCustomerName());
    }
    
    /**
     * Tests method getLatestReview()
     */
    @Test
    public void testGetLatestReview(){
        VIPCustomerReview review1 = new VIPCustomerReview("John Miller", "This is good");
        assertEquals("This is good", review1.getLatestReview());
        
        VIPCustomerReview review2 = new VIPCustomerReview("Selena Ryzada", "This is bad");
        assertEquals("This is bad", review2.getLatestReview());
        
        VIPCustomerReview review3 = new VIPCustomerReview("CS150", "This is amazing");
        assertEquals("This is amazing", review3.getLatestReview());
        
    }
    
    /**
     * Tests method toString()
     */
    @Test
    public void testToString(){
        VIPCustomerReview review1 = new VIPCustomerReview("John Miller", "This is good");
        assertEquals("Name: John Miller Review: This is good", review1.toString());
        
        VIPCustomerReview review2 = new VIPCustomerReview("Selena Ryzada", "This is bad");
        assertEquals("Name: Selena Ryzada Review: This is bad", review2.toString());
        
        VIPCustomerReview review3 = new VIPCustomerReview("CS150", "This is amazing");
        assertEquals("Name: CS150 Review: This is amazing", review3.toString());
        
    }
    
    /**
     * Tests method equals()
     */
    @Test
    public void equals(){
        VIPCustomerReview review1 = new VIPCustomerReview("John Miller", "This is good");
        VIPCustomerReview review2 = new VIPCustomerReview("Selena Ryzada", "This is bad");
        VIPCustomerReview review3 = new VIPCustomerReview("CS150", "This is amazing");
        CustomerReview review4 = new CustomerReview("John Miller", "This is good");
        VIPCustomerReview review5 = new VIPCustomerReview("John Miller", "This is good");
        
        assertTrue(review1.equals(review1));
        assertFalse(review1.equals(review2));
        assertFalse(review1.equals(review4));
        assertTrue(review1.equals(review5));
    }
    
    /**
     * Tests method hashCode()
     */
    @Test
    public void testHashCode(){
    VIPCustomerReview review1 = new VIPCustomerReview("John Miller", "This is good");
    VIPCustomerReview review2 = new VIPCustomerReview("John Miller", "This is bad");  
    
    assertEquals(review1.hashCode(), review2.hashCode());
    }
}
