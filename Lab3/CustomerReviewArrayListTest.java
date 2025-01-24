

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The CustomerReviewArrayList Test class calls test methods to test all methods in the CustomerReviewArrayList class, and the overall
 * functionality of the CustomerReviewArrayList class.
 *
 * @author  Padmanabh Kaushik
 * @version 2/15/2024
 */
public class CustomerReviewArrayListTest
{
    private CustomerReviewArrayList customerReviewArrayList;
    
    /**
     * Blank constructor for IntArrayListTest
     */
    public CustomerReviewArrayListTest()
    {
    }

    /**
     * Performs startup functions before each test
     */
    @BeforeEach
    public void setUp()
    {
        customerReviewArrayList = new CustomerReviewArrayList();
        System.out.println("In Setup");
    }

    /**
     * Performs tear down functions at the end of each test
     */
    @AfterEach
    public void tearDown()
    {
        customerReviewArrayList = null;
        System.out.println("In tearDown");
    }
    
    /**
     * This method tests get()
     */
    @Test
    public void getTest(){
        //Adds and element to the beginning of the list and retrieves it
        CustomerReview review1 = new CustomerReview("Sam John", "This is a review 1");
        CustomerReview review2 = new CustomerReview("Sam John", "This is a review 2");
        CustomerReview review3 = new CustomerReview("Sam John", "This is a review 3");
        customerReviewArrayList.add(review1);
        assertEquals(review1,customerReviewArrayList.get(0));
        //Adds two more elements, retreives the third element in the list
        customerReviewArrayList.add(review2);
        customerReviewArrayList.add(review3);
        assertEquals(review3,customerReviewArrayList.get(2));
        
        //Code for exception test; case putting an index that is not filled
         boolean exceptionThrown = false;
        try{
            customerReviewArrayList.get(3);
        } catch (IndexOutOfBoundsException e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
        
    }
    /**
     * This method tests add(CustomerReview customerReview)
     */
    @Test
    public void testAdd(){
        CustomerReview review1 = new CustomerReview("Sam John", "This is a review 1");
        CustomerReview review2 = new CustomerReview("Sam John", "This is a review 2");
        CustomerReview review3 = new CustomerReview("Sam John", "This is a review 3");
        //Add an element to the beginning of the list; retrieve and compare it using AssertEquals
        customerReviewArrayList.add(review1);
        assertEquals(review1, customerReviewArrayList.get(0));
        
        //Adding and element to index it 1 an checking it
        customerReviewArrayList.add(review2);
        assertEquals(review2, customerReviewArrayList.get(1));
        
        //Adding and element to index it 2 an checking it
        customerReviewArrayList.add(review3);
        assertEquals(review3, customerReviewArrayList.get(2));
        
        CustomerReview review4 = new CustomerReview("Sam John", "This is a review 3");
        CustomerReview review5 = new CustomerReview("Sam John", "This is a review 4");
        CustomerReview review6 = new CustomerReview("Sam John", "This is a review 5");
        CustomerReview review7 = new CustomerReview("Sam John", "This is a review 6");
        CustomerReview review8 = new CustomerReview("Sam John", "This is a review 7");
        CustomerReview review9 = new CustomerReview("Sam John", "This is a review 8");
        CustomerReview review10 = new CustomerReview("Sam John", "This is a review 9");
        CustomerReview review11 = new CustomerReview("Sam John", "This is a review 10");
        
        //Filling up all the 10 spaces in the arrayList and retrieveing 11th index from the expanded list
        customerReviewArrayList.add(review4);
        customerReviewArrayList.add(review5);
        customerReviewArrayList.add(review6);
        customerReviewArrayList.add(review7);
        customerReviewArrayList.add(review8);
        customerReviewArrayList.add(review9);
        customerReviewArrayList.add(review10);
        customerReviewArrayList.add(review11);
        assertEquals(review11, customerReviewArrayList.get(10));
        
    }
    
    /**
     * This method tests add(int index, CustomerReview customerReview)
     */
    @Test
    public void testAddWithIndex(){
        
        CustomerReview review1 = new CustomerReview("Sam John", "This is a review 1");
        CustomerReview review2 = new CustomerReview("Sam John", "This is a review 2");
        CustomerReview review3 = new CustomerReview("Sam John", "This is a review 3");
        CustomerReview review4 = new CustomerReview("Sam John", "This is a review 3");
        CustomerReview review5 = new CustomerReview("Sam John", "This is a review 4");
        CustomerReview review6 = new CustomerReview("Sam John", "This is a review 5");
        CustomerReview review7 = new CustomerReview("Sam John", "This is a review 6");
        CustomerReview review8 = new CustomerReview("Sam John", "This is a review 7");
        CustomerReview review9 = new CustomerReview("Sam John", "This is a review 8");
        CustomerReview review10 = new CustomerReview("Sam John", "This is a review 9");
        CustomerReview review11 = new CustomerReview("Sam John", "This is a review 10");
        //Putting an entry ay index 0 and checking it
        customerReviewArrayList.add(0,review1);
        assertEquals(review1, customerReviewArrayList.get(0));
        //Putting an entry ay index 1 and checking it
        customerReviewArrayList.add(1,review2);
        assertEquals(review2, customerReviewArrayList.get(1));
        //Filling up all the 10 spaces in the arrayList and retrieveing 11th index from the expanded list
        customerReviewArrayList.add(2,review3);
        customerReviewArrayList.add(3,review4);
        customerReviewArrayList.add(4,review5);
        customerReviewArrayList.add(5,review6);
        customerReviewArrayList.add(6,review7);
        customerReviewArrayList.add(7,review8);
        customerReviewArrayList.add(8,review9);
        customerReviewArrayList.add(9,review10);
        customerReviewArrayList.add(10,review11);
        customerReviewArrayList.add(11,review3);
        assertEquals(review3, customerReviewArrayList.get(11));
        //Checking expansion of list by adding a new element to index 1
        customerReviewArrayList.add(1,review5);
        assertEquals(review5, customerReviewArrayList.get(1));
        assertEquals(review2, customerReviewArrayList.get(2));
        
        //Add test for an exception: index = -1;
        boolean exceptionThrown = false;
        try{
            customerReviewArrayList.add(-1,review5);
        } catch (IndexOutOfBoundsException e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
        
    }
    /**
     * This method tests isEmpty()
     */
    @Test
    public void empty(){
        CustomerReview review1 = new CustomerReview("Sam John", "This is a review 1");
        //creating a blank list and determining is it is empty
        customerReviewArrayList.clear();
        assertTrue(customerReviewArrayList.isEmpty());
        //creating a list with n element and determining is it is not empty
        customerReviewArrayList.add(review1);
        assertFalse(customerReviewArrayList.isEmpty());
        //creating a list with n element and determining is it is not empty
        customerReviewArrayList.add(1,review1);
        assertFalse(customerReviewArrayList.isEmpty());
        
    }
    /**
     * This method tests empty_cnt
     */
    @Test
    public void emptyCnt(){
        
        //creating a blank list and checking if the number of empty elements is 10
        customerReviewArrayList.clear();
        assertEquals(10,customerReviewArrayList.empty_cnt());
        
        //adding an element and checking if the number of empty elements is 9
        CustomerReview review1 = new CustomerReview("Sam John", "This is a review 1");
        customerReviewArrayList.add(review1);
        assertEquals(9,customerReviewArrayList.empty_cnt());
        
        //adding an element and checking if the number of empty elements is 9
        customerReviewArrayList.clear();
        customerReviewArrayList.add(0,review1);
        assertEquals(9,customerReviewArrayList.empty_cnt());
        
    }
    
    /**
     * This method tests clear()
     */
    @Test
    public void clearTest(){
        
        //Clearing a list and checking if the empty count is 10
        customerReviewArrayList.clear();
        assertEquals(10, customerReviewArrayList.empty_cnt());
        
    }
    
    /**
     * This method tests remove(int index)
     */
    @Test
    public void removeTest(){
        
        CustomerReview review1 = new CustomerReview("Sam John", "This is a review 1");
        CustomerReview review2 = new CustomerReview("Sam John", "This is a review 2");
        CustomerReview review3 = new CustomerReview("Sam John", "This is a review 3");
        CustomerReview review4 = new CustomerReview("Sam John", "This is a review 3");
        CustomerReview review5 = new CustomerReview("Sam John", "This is a review 4");
        CustomerReview review6 = new CustomerReview("Sam John", "This is a review 5");
        CustomerReview review7 = new CustomerReview("Sam John", "This is a review 6");
        CustomerReview review8 = new CustomerReview("Sam John", "This is a review 7");
        CustomerReview review9 = new CustomerReview("Sam John", "This is a review 8");
        CustomerReview review10 = new CustomerReview("Sam John", "This is a review 9");
        CustomerReview review11 = new CustomerReview("Sam John", "This is a review 10");
        //Adding three elements to the list and; 
        customerReviewArrayList.add(review1);
        customerReviewArrayList.add(review2);
        customerReviewArrayList.add(review3);
        //Removing element at index 1 and checking the removed element
        assertEquals(review2, customerReviewArrayList.remove(1));
        //Checking the new element at index 1
        assertEquals(review3, customerReviewArrayList.get(1));
        //checking the size of the array
        assertEquals(10, customerReviewArrayList.arraySize());
        
        //add test for exception: index out of bounds
        boolean exceptionThrown = false;
        try{
            customerReviewArrayList.remove(56);
        } catch (IndexOutOfBoundsException e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
        
    }
    /**
     * This method tests toString()
     */
    
    @Test
    public void toStringTest(){
        
        CustomerReview review1 = new CustomerReview("A", "A");
        CustomerReview review2 = new CustomerReview("B", "B");
        CustomerReview review3 = new CustomerReview("Sam John", "This is a review 3");
        CustomerReview review4 = new CustomerReview("Sam John", "This is a review 3");
        
        //Adding elements to the array list and ckecking the resultant string
        customerReviewArrayList.add(review1);
        customerReviewArrayList.add(review2);
        assertEquals("Name: A Review: A Name: B Review: B", customerReviewArrayList.toString());
        
        customerReviewArrayList.clear();
        assertEquals("", customerReviewArrayList.toString());
        
    }
    
    /**
     * This method tests next()
     */
    @Test
    public void next(){
        CustomerReview review1 = new CustomerReview("A", "A");
        CustomerReview review2 = new CustomerReview("B", "B");
        CustomerReview review3 = new CustomerReview("Sam John", "This is a review 3");
        CustomerReview review4 = new CustomerReview("Sam John", "This is a review 4");
        //adding three elements to the list
        customerReviewArrayList.add(review1);
        customerReviewArrayList.add(review2);
        customerReviewArrayList.add(review3);
        //checking if using next gives returns these elements
        assertEquals(review1, customerReviewArrayList.next());
        assertEquals(review2, customerReviewArrayList.next());
        assertEquals(review3, customerReviewArrayList.next());
        
        //Enter code for exception: when next runs out of bounds
        boolean exceptionThrown = false;
        try{
            customerReviewArrayList.next();
        } catch (IndexOutOfBoundsException e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    
    }
    
    /**
     * This method tests size()
     */
    @Test
    public void sizeTest(){
        CustomerReview review1 = new CustomerReview("Sam John", "This is a review 1");
        CustomerReview review2 = new CustomerReview("Sam John", "This is a review 2");
        CustomerReview review3 = new CustomerReview("Sam John", "This is a review 3");
        CustomerReview review4 = new CustomerReview("Sam John", "This is a review 3");
        CustomerReview review5 = new CustomerReview("Sam John", "This is a review 4");
        CustomerReview review6 = new CustomerReview("Sam John", "This is a review 5");
        CustomerReview review7 = new CustomerReview("Sam John", "This is a review 6");
        CustomerReview review8 = new CustomerReview("Sam John", "This is a review 7");
        CustomerReview review9 = new CustomerReview("Sam John", "This is a review 8");
        CustomerReview review10 = new CustomerReview("Sam John", "This is a review 9");
        CustomerReview review11 = new CustomerReview("Sam John", "This is a review 10");
        //Adding an element to the array and checking its size
        customerReviewArrayList.add(review1);
        assertEquals(1, customerReviewArrayList.size());
        //Filling up to 5 elements and checking size
        customerReviewArrayList.add(review2);
       customerReviewArrayList.add(review3);
        customerReviewArrayList.add(review4);
        customerReviewArrayList.add(review5);
        assertEquals(5, customerReviewArrayList.size());
        //Filling up to 11 elements and checking size
        customerReviewArrayList.add(review6);
        customerReviewArrayList.add(review7);
        customerReviewArrayList.add(review8);
        customerReviewArrayList.add(review9);
        customerReviewArrayList.add(review10);
        customerReviewArrayList.add(review11);
        assertEquals(11, customerReviewArrayList.size());
    }
    /**
     * This method tests arraySize()
     */
    @Test
    public void arraySizeTest(){
        CustomerReview review1 = new CustomerReview("Sam John", "This is a review 1");
        CustomerReview review2 = new CustomerReview("Sam John", "This is a review 2");
        CustomerReview review3 = new CustomerReview("Sam John", "This is a review 3");
        CustomerReview review4 = new CustomerReview("Sam John", "This is a review 3");
        CustomerReview review5 = new CustomerReview("Sam John", "This is a review 4");
        CustomerReview review6 = new CustomerReview("Sam John", "This is a review 5");
        CustomerReview review7 = new CustomerReview("Sam John", "This is a review 6");
        CustomerReview review8 = new CustomerReview("Sam John", "This is a review 7");
        CustomerReview review9 = new CustomerReview("Sam John", "This is a review 8");
        CustomerReview review10 = new CustomerReview("Sam John", "This is a review 9");
        CustomerReview review11 = new CustomerReview("Sam John", "This is a review 10");
        //Adding an element to list to ckeck if the array size is equal to 10
        customerReviewArrayList.add(review1);
        assertEquals(10, customerReviewArrayList.arraySize());
        
        //adding up to 11 elements to ckeck if the array size is equal to 20
        customerReviewArrayList.add(review2);
        customerReviewArrayList.add(review3);
        customerReviewArrayList.add(review4);
        customerReviewArrayList.add(review5);
        customerReviewArrayList.add(review6);
        customerReviewArrayList.add(review7);
        customerReviewArrayList.add(review8);
        customerReviewArrayList.add(review9);
        customerReviewArrayList.add(review10);
        customerReviewArrayList.add(review11);
        assertEquals(20, customerReviewArrayList.arraySize());
    }
}
