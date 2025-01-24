

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The is a test class which tests all methods designed for classes DoublingList, DoublingListIterator, and DoublingIterator. 
 *
 * @author  Padmanabh Kaushik
 * @version 04/15/2024
 */
public class DoublingListTest
{
    /**
     * Default constructor for test class DoublingListTest
     */
    public DoublingListTest()
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
     * This is a test class for the add() method of the DoublingList and toStringInternal()
     */
    @Test
    public void testForAdd(){
        //create a doubling list and add elements
        DoublingList<String> list1 = new DoublingList<>();
        list1.add("happy days");
        assertEquals("[(happy days)]", list1.toStringInternal());
        list1.add("at ECE");
        list1.add("can never be back");
        assertEquals("[(happy days)(at ECE,can never be back)]", list1.toStringInternal());
        list1.add("Here's the truth");
        //compare toStringInternal expression
        assertEquals("[(happy days)(at ECE,can never be back)(Here's the truth,-,-,-)]", list1.toStringInternal());
        
        
    }
    
    /**
     * This is a text class for the hasNext() method of the DoublingList
     */
    @Test
    public void testForHasNext(){
        //create a doubling list and test for hasNext()
        DoublingList<String> list1 = new DoublingList<>();
        //add elements
        list1.add("happy days");
        DoublingList.DoublingIterator iter = list1.new DoublingIterator();
        assertTrue(iter.hasNext());
        
        //List with no items and test foe hasNext()
        DoublingList<String> list2 = new DoublingList<>();
        DoublingList.DoublingIterator iter2 = list2.new DoublingIterator();
        assertFalse(iter2.hasNext());
        
    }
    
    /**
     * This is a test class for helper method find()
     */
    @Test
    public void testFind(){
        //Create a new doubling list
        DoublingList<String> list1 = new DoublingList<>();
        list1.add("happy days");
        list1.add("at ABC");
        list1.add("can never be back");
        list1.add("Here's the truth");
        list1.add("I'm here");
        list1.add("All is well");
        //Find offsets of elements 1 through 5
        DoublingList.DoublingIterator iter = list1.new DoublingIterator();
        assertEquals(0, iter.returnOffset(list1.find(0)));
        assertEquals(0, iter.returnOffset(list1.find(1)));
        assertEquals(1, iter.returnOffset(list1.find(2)));
        assertEquals(0, iter.returnOffset(list1.find(3)));
        assertEquals(1, iter.returnOffset(list1.find(4)));
        assertEquals(2, iter.returnOffset(list1.find(5)));
    }
    
    /**
     * This is a test method for hasNext() method of DoublingIterator.
     */
    @Test
    public void testHasNext(){
        //add an element and test for hasNext()
        DoublingList<String> list1 = new DoublingList<>();
        list1.add("happy days");
        DoublingList.DoublingIterator iter = list1.new DoublingIterator();
        assertTrue(iter.hasNext());
    }
    
    /**
     * This is a test method for next() method of the DoublingIterator.
     */
    @Test
    public void testNext(){
        //Create a new doubling list
        DoublingList<String> list1 = new DoublingList<>();
        list1.add("happy days");
        list1.add("at ABC");
        list1.add("can never be back");
        list1.add("Here's the truth");
        DoublingList.DoublingIterator iter = list1.new DoublingIterator();
        //move cursor and compare elements
        assertEquals("happy days", iter.next());
        assertEquals("at ABC", iter.next());
        assertEquals("can never be back", iter.next());
    }
    
    /**
     * This is a test method for the nextIndex() method of the DoublingListIterator
     */
    @Test
    public void textNextIndex(){
        //Create a new doubling list
        DoublingList<String> list1 = new DoublingList<>();
        //add elements
        list1.add("happy days");
        list1.add("at ABC");
        list1.add("can never be back");
        list1.add("Here's the truth"); 
        DoublingList.DoublingListIterator iter = list1.new DoublingListIterator();
        //use next and call iter.nextIndex()
        assertEquals(1, iter.nextIndex());
        iter.next();
        assertEquals(2, iter.nextIndex());
        System.out.println(iter.next());
        assertEquals(3, iter.nextIndex());
        iter.next();
        assertEquals(4, iter.nextIndex());
    }
    
    /**
     * This is a test method for the previousIndex() method of the DoublingListIterator.
     */
    @Test
    public void testPreviousIndex(){
        //Create a new doubling list
       DoublingList<String> list1 = new DoublingList<>();
        list1.add("happy days");
        list1.add("at ABC");
        list1.add("can never be back");
        list1.add("Here's the truth"); 
        DoublingList.DoublingListIterator iter = list1.new DoublingListIterator();
        //prev inde is -1 at head.next
        assertEquals(-1, iter.previousIndex());
        
        //Create a new doubling list
        DoublingList<String> list2 = new DoublingList<>();
        list2.add("happy days");
        list2.add("at ABC");
        list2.add("can never be back");
        list2.add("Here's the truth"); 
        DoublingList.DoublingListIterator iter2 = list2.new DoublingListIterator();
        //move ahead
        iter2.next();
        //find previous ideex (here prevIndex = 0)
        assertEquals(0, iter2.previousIndex());
        iter2.next();
        assertEquals(1, iter2.previousIndex());
    }
    
    /**
     * This is a test method for the hasPrevious() method of the DoublingListIterator.
     */
    @Test
    public void testHasPrevious(){
        //Create a new doubling list
       DoublingList<String> list1 = new DoublingList<>();
        list1.add("happy days");
        list1.add("at ABC");
        list1.add("can never be back");
        list1.add("Here's the truth"); 
        DoublingList.DoublingListIterator iter = list1.new DoublingListIterator();
        assertFalse(iter.hasPrevious()); 
        
        //Create a new doubling list
        DoublingList<String> list2 = new DoublingList<>();
        list2.add("happy days");
        list2.add("at ABC");
        list2.add("can never be back");
        list2.add("Here's the truth"); 
        DoublingList.DoublingListIterator iter2 = list2.new DoublingListIterator();
        //move index forward and check next
        iter2.next();
        assertTrue(iter2.hasPrevious());
    }
    
    /**
     * This is a test method for the previous() method of the DoublingListIterator.
     */
    @Test
    public void testPrevious(){
        //Create a new doubling list
        DoublingList<String> list1 = new DoublingList<>();
        list1.add("happy days");
        list1.add("at ABC");
        list1.add("can never be back");
        list1.add("Here's the truth"); 
        DoublingList.DoublingListIterator iter = list1.new DoublingListIterator();
        //at head.next prev is null
        assertNull(iter.previous()); 
        
        //Create a new doubling list
        DoublingList<String> list2 = new DoublingList<>();
        list2.add("happy days");
        list2.add("at ABC");
        list2.add("can never be back");
        list2.add("Here's the truth"); 
        DoublingList.DoublingListIterator iter2 = list2.new DoublingListIterator();
        iter2.next();
        assertEquals("happy days", iter2.previous());
        //move ahead and check prev
        iter2.next();
        iter2.next();
        assertEquals("at ABC", iter2.previous());
    }
    
    /**
     * This is a test method for the set() method of the DoublingListIterator.
     */
    @Test
    public void testSet(){
        DoublingList<String> list1 = new DoublingList<>();
        list1.add("happy days");
        list1.add("at ABC");
        list1.add("can never be back");
        list1.add("Here's the truth"); 
        DoublingList.DoublingListIterator iter = list1.new DoublingListIterator();
        //call next
        assertEquals(iter.next(),"happy days");
        //do set operation
        iter.set("Hello world");
        //System.out.println(list1.toStringInternal());
        //look at the previous element
        assertEquals("Hello world", iter.previous());
    }
    
    /**
     * This is a test method for add(pos, item) method of the DoublingListIterator.
     */
    @Test
    public void testAddWithPos(){
        DoublingList<String> list1 = new DoublingList<>();
        list1.add("happy days");
        list1.add("at ABC");
        list1.add("can never be back");
        list1.add("Here's the truth");
        list1.add(2, "So here it goes");
        //requiring right shift
        assertEquals( "[(happy days)(at ABC,So here it goes)(can never be back,Here's the truth,-,-)]", list1.toStringInternal());
        list1.add("I");
        list1.add("2");
        list1.add(7, "Khagen");
        //requiring addition of a node
        assertEquals( "[(happy days)(at ABC,So here it goes)(can never be back,Here's the truth,I,2)(Khagen,-,-,-,-,-,-,-)]", list1.toStringInternal());
        assertEquals("at ABC", list1.remove(1));
        //when there is space for in the current array
        list1.add(1,"at ABC");
        assertEquals( "[(happy days)(at ABC,So here it goes)(can never be back,Here's the truth,I,2)(Khagen,-,-,-,-,-,-,-)]", list1.toStringInternal());
        assertEquals("at ABC", list1.remove(1));
        list1.add(3,"at ABC");
        assertEquals( "[(happy days)(So here it goes,can never be back)(Here's the truth,at ABC,I,2)(Khagen,-,-,-,-,-,-,-)]", list1.toStringInternal());
        
        
    }
    
    /**
     * This is a test method for the add() method of the DoublingListIterator.
     */
    @Test
    public void doublingListIteratorAdd(){
        DoublingList<String> list1 = new DoublingList<>();
        list1.add("happy days");
        list1.add("at ABC");
        list1.add("can never be back");
        list1.add("Here's the truth");
        DoublingList.DoublingListIterator iter = list1.new DoublingListIterator(list1, 3);
        //add item
        iter.add("La La La");
        //assert equals with toStringInternal
        assertEquals( "[(happy days)(at ABC,can never be back)(La La La,Here's the truth,-,-)]", list1.toStringInternal());
        
        //Space to the right
        DoublingList<String> list2 = new DoublingList<>();
        list2.add("happy days");
        list2.add("at ABC");
        list2.add("can never be back");
        DoublingList.DoublingListIterator iter2 = list2.new DoublingListIterator(list2, 1);
        //add element
        iter2.add("La La La");
        //test with to string
        assertEquals("[(happy days)(La La La,at ABC)(can never be back,-,-,-)]", list2.toStringInternal());
    }
    
    /**
     * This is a test method for the remove() method of the DoublingList.
     */
    @Test
    public void testRemove(){
        //Create a new doubling list
        DoublingList<String> list1 = new DoublingList<>();
        list1.add("happy days");
        list1.add("at ABC");
        list1.add("can never be back");
        list1.add("Here's the truth");
        //remove elements
        assertEquals("happy days", list1.remove(0));
        assertEquals("can never be back", list1.remove(1));
        assertEquals("at ABC", list1.remove(0));
        //compare the final result
        assertEquals("[(Here's the truth)]", list1.toStringInternal());
    }
    
    /**
     * This is a test method for the remove() method of the DoublingListIterator.
     */
    @Test
    public void listIteratorRemove(){
        //Create a list
        DoublingList<String> list1 = new DoublingList<>();
        list1.add("happy days");
        list1.add("at ABC");
        list1.add("can never be back");
        list1.add("Here's the truth");
        DoublingList.DoublingListIterator iter = list1.new DoublingListIterator(list1, 1);
        //ABC should be removed
        iter.next();
        iter.remove();
        assertEquals("[(happy days)(can never be back,-)(Here's the truth,-,-,-)]", list1.toStringInternal());
        //remove here's the truth
        //use iterator in combination with remove method from ListIterator
        iter.next();
        iter.remove();
        list1.remove(0);
        assertEquals("[(can never be back)]", list1.toStringInternal());
    }
    
    /**
     * This is a test method for toStringInternal(iter) and toStringInternal()
     */
    @Test
    public void testToStringInternalForIter(){
        //Create a new list
        DoublingList<String> list1 = new DoublingList<>();
        list1.add("happy days");
        list1.add("at ABC");
        list1.add("can never be back");
        list1.add("Here's the truth");
        //Create ListIterator item
        DoublingList.DoublingListIterator iter = list1.new DoublingListIterator(list1);
        assertEquals("[(happy days)(|at ABC,can never be back)(Here's the truth,-,-,-)]", list1.toStringInternal(iter));
        assertEquals("[(happy days)(at ABC,can never be back)(Here's the truth,-,-,-)]", list1.toStringInternal());
        //increment the pointer
        iter.next();
        //compare the new list
        assertEquals("[(happy days)(at ABC,|can never be back)(Here's the truth,-,-,-)]", list1.toStringInternal(iter));
        //increment the pointer
        iter.next();
        //compare the new list
        assertEquals("[(happy days)(at ABC,can never be back)(|Here's the truth,-,-,-)]", list1.toStringInternal(iter));
        //print toStringInternal() without iter
        assertEquals("[(happy days)(at ABC,can never be back)(Here's the truth,-,-,-)]", list1.toStringInternal());
        
    }
}
