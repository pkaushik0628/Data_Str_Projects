

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * Public class IntArrayListTest tests the custom made IntArrayList. The class tests IntArrayList methods namely
 * namely add(int e), add(int index, int e), get(int index), clear(), isEmpty(), remove(int index), size(), arraySize(), 
 * empty_cnt, toString(), and next().
 * 
 * @author  Padmanabh Kaushik
 * @version 2/5/24
 */
public class IntArrayListTest
{
    private IntArrayList intArrayList;
    
    /**
     * Blank constructor for IntArrayListTest
     */
    public IntArrayListTest()
    {
    }

    /**
     * Performs startup functions before each test
     */
    @BeforeEach
    public void setUp()
    {
        intArrayList = new IntArrayList();
        System.out.println("In Setup");
    }

    /**
     * Performs tear down functions at the end of each test
     */
    @AfterEach
    public void tearDown()
    {
        intArrayList = null;
        System.out.println("In tearDown");
    }
    
    /**
     * This method tests get()
     */
    @Test
    @DisplayName ("Test of get")
    public void getTest(){
        //Adds and element to the beginning of the list and retrieves it
        intArrayList.add(1);
        assertEquals(1,intArrayList.get(0));
        //Adds two more elements, retreives the third element in the list
        intArrayList.add(50);
        intArrayList.add(20);
        assertEquals(20,intArrayList.get(2));
        
        //Code for exception test; case putting an index that is not filled
         boolean exceptionThrown = false;
        try{
            intArrayList.get(3);
        } catch (IndexOutOfBoundsException e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
        
    }
    /**
     * This method tests add(int e)
     */
    @Test
    @DisplayName ("Test of add method")
    public void testAdd(){
        //Add an element to the beginning of the list; retrieve and compare it using AssertEquals
        intArrayList.add(1);
        assertEquals(1, intArrayList.get(0));
        
        //Adding and element to index it 1 an checking it
        intArrayList.add(2);
        assertEquals(2, intArrayList.get(1));
        
        //Adding and element to index it 2 an checking it
        intArrayList.add(3);
        assertEquals(3, intArrayList.get(2));
        
        //Filling up all the 10 spaces in the arrayList and retrieveing 11th index from the expanded list
        intArrayList.add(4);
        intArrayList.add(5);
        intArrayList.add(6);
        intArrayList.add(7);
        intArrayList.add(8);
        intArrayList.add(9);
        intArrayList.add(10);
        intArrayList.add(11);
        assertEquals(11, intArrayList.get(10));
        
    }
    
    /**
     * This method tests add(int index, int e)
     */
    @Test
    @DisplayName ("Test of add method with Index input parameter")
    public void testAddWithIndex(){
        
        //Putting an entry ay index 0 and checking it
        intArrayList.add(0,1);
        assertEquals(1, intArrayList.get(0));
        //Putting an entry ay index 1 and checking it
        intArrayList.add(1,3);
        assertEquals(3, intArrayList.get(1));
        //Filling up all the 10 spaces in the arrayList and retrieveing 11th index from the expanded list
        intArrayList.add(2,4);
        intArrayList.add(3,4);
        intArrayList.add(4,5);
        intArrayList.add(5,6);
        intArrayList.add(6,7);
        intArrayList.add(7,8);
        intArrayList.add(8,9);
        intArrayList.add(9,10);
        intArrayList.add(10,11);
        intArrayList.add(11,3);
        assertEquals(3, intArrayList.get(11));
        //Checking expansion of list by adding a new element to index 1
        intArrayList.add(1,34);
        assertEquals(34, intArrayList.get(1));
        assertEquals(3, intArrayList.get(2));
        
        //Add test for an exception: index = -1;
        boolean exceptionThrown = false;
        try{
            intArrayList.add(-1,4);
        } catch (IndexOutOfBoundsException e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
        
    }
    /**
     * This method tests isEmpty()
     */
    @Test
    @DisplayName ("Test of isEmpty")
    public void empty(){
        //creating a blank list and determining is it is empty
        intArrayList.clear();
        assertTrue(intArrayList.isEmpty());
        //creating a list with n element and determining is it is not empty
        intArrayList.add(50);
        assertFalse(intArrayList.isEmpty());
        //creating a list with n element and determining is it is not empty
        intArrayList.add(1,50);
        assertFalse(intArrayList.isEmpty());
        
    }
    /**
     * This method tests empty_cnt
     */
    @Test
    @DisplayName ("Test of empty_cnt")
    public void emptyCnt(){
        
        //creating a blank list and checking if the number of empty elements is 10
        intArrayList.clear();
        assertEquals(10,intArrayList.empty_cnt());
        
        //adding an element and checking if the number of empty elements is 9
        intArrayList.add(50);
        assertEquals(9,intArrayList.empty_cnt());
        
        //adding an element and checking if the number of empty elements is 9
        intArrayList.clear();
        intArrayList.add(0,50);
        assertEquals(9,intArrayList.empty_cnt());
        
    }
    
    /**
     * This method tests clear()
     */
    @Test
    @DisplayName ("Test of clear")
    public void clearTest(){
        
        //Clearing a list and checking if the empty count is 10
        intArrayList.clear();
        assertEquals(10, intArrayList.empty_cnt());
        
        //Clearing a list and checking if the empty count is 10
        intArrayList.add(50);
        intArrayList.clear();
        assertEquals(10, intArrayList.empty_cnt());
        
        //Clearing a list and checking if the empty count is 10
        intArrayList.add(0,50);
        intArrayList.add(1,34);
        intArrayList.add(2,56);
        intArrayList.clear();
        assertEquals(10, intArrayList.empty_cnt());
        
    }
    
    /**
     * This method tests remove(int index)
     */
    @Test
    @DisplayName ("Test of remove")
    public void removeTest(){
        //Adding three elements to the list and; 
        intArrayList.add(4);
        intArrayList.add(5);
        intArrayList.add(6);
        //Removing element at index 1 and checking the removed element
        assertEquals(5, intArrayList.remove(1));
        //Checking the new element at index 1
        assertEquals(6, intArrayList.get(1));
        //checking the size of the array
        assertEquals(10, intArrayList.arraySize());
        
        //Filling up up to 11 elements in the list
        intArrayList.add(5);
        intArrayList.add(5);
        intArrayList.add(5);
        intArrayList.add(5);
        intArrayList.add(5);
        intArrayList.add(5);
        intArrayList.add(6);
        intArrayList.add(7);
        //removing element at index 7 and checking it
        assertEquals(7, intArrayList.remove(9));
        //checking the size of the array
        assertEquals(10, intArrayList.arraySize());
        
        //add test for exception: index out of bounds
        boolean exceptionThrown = false;
        try{
            intArrayList.remove(56);
        } catch (IndexOutOfBoundsException e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
        
    }
    /**
     * This method tests toString()
     */
    
    @Test
    @DisplayName ("Test of toString")
    public void toStringTest(){
        
        //Adding elements to the array list and ckecking the resultant string
        intArrayList.add(4);
        intArrayList.add(5);
        intArrayList.add(6);
        assertEquals("4 5 6", intArrayList.toString());
        
        intArrayList.add(3,5);
        assertEquals("4 5 6 5", intArrayList.toString());
        
        intArrayList.clear();
        assertEquals("", intArrayList.toString());
        
    }
    
    /**
     * This method tests next()
     */
    @Test
    @DisplayName ("Test of next")
    public void next(){
        //adding three elements to the list
        intArrayList.add(2);
        intArrayList.add(3);
        intArrayList.add(4);
        //checking if using next gives returns these elements
        assertEquals(2, intArrayList.next());
        assertEquals(3, intArrayList.next());
        assertEquals(4, intArrayList.next());
        
        //Enter code for exception: when next runs out of bounds
        boolean exceptionThrown = false;
        try{
            intArrayList.next();
        } catch (IndexOutOfBoundsException e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    
    }
    
    /**
     * This method tests size()
     */
    @Test
    @DisplayName ("Test of size")
    public void sizeTest(){
        //Adding an element to the array and checking its size
        intArrayList.add(2);
        assertEquals(1, intArrayList.size());
        //Filling up to 5 elements and checking size
        intArrayList.add(2);
        intArrayList.add(2);
        intArrayList.add(2);
        intArrayList.add(2);
        assertEquals(5, intArrayList.size());
        //Filling up to 11 elements and checking size
        intArrayList.add(2);
        intArrayList.add(2);
        intArrayList.add(2);
        intArrayList.add(2);
        intArrayList.add(2);
        intArrayList.add(2);
        assertEquals(11, intArrayList.size());
    }
    /**
     * This method tests arraySize()
     */
    @Test
    @DisplayName ("Test of Array Size")
    public void arraySizeTest(){
        //Adding an element to list to ckeck if the array size is equal to 10
        intArrayList.add(2);
        assertEquals(10, intArrayList.arraySize());
        
        //Adding up to 5 elements to see if array size is equal to 10
        intArrayList.add(2);
        intArrayList.add(2);
        intArrayList.add(2);
        intArrayList.add(2);
        assertEquals(10, intArrayList.arraySize());
        
        //adding up to elements to ckeck if the array size is equal to 20
        intArrayList.add(2);
        intArrayList.add(2);
        intArrayList.add(2);
        intArrayList.add(2);
        intArrayList.add(2);
        intArrayList.add(2);
        assertEquals(20, intArrayList.arraySize());
    }
    
    
}
