import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Public class Part1 uses test method to test the inbuilt String() class in Java. The class tests String methods namely 
 * equals(String a), concat(String b), compareTo(String c), charAt(int index), indexOf(char c), subString(int x, int y), 
 * and split(String s, int z). These tests have been numbered tests methods 1 - 7 respectively
 * 
 * @author Padmanabh Kaushik
 * @version 2/6/2024
 */
public class Part1
{
    /**
     * Blank constructor for class Part1
     */
    public Part1()
    {
    }
    
    /**
     * Performs startup functions before the beginning of each test
     */
    @BeforeEach
    public void setUp()
    {
        System.out.println("In Setup");
    }

    /**
     * Performs tear down functions after the end of each test
     */
    @AfterEach
    public void tearDown()
    {
        System.out.println("In tearDown");
    }
    
    /**
     * This test method tests equals()
     */
    @Test
    @DisplayName("Test Method 1")
    public void testMeth1(){
       //Test 1: Tests two equal string
       String a  = "This is a cat";
       String  b = "This is a cat";
       assertTrue(a.equals(b));
       //Test 2: Test two unequal strings
       String c = "This is a dog";
       String d = "He loves to travel";
       assertFalse(c.equals(d));
       //Test 2: Test two unequal strings
       String e = "This is a dog";
       String f = "agjahsj  husl ,qwd";
       assertFalse(e.equals(f));
       
    }
    /**
     * This is a test for concat()
     */
    @Test
    @DisplayName("Test Method 2")
    public void testMeth2(){
        //Test 1: Test if the concatination of two strings is same as the result produced by .concat()
        String a = "This is a dog ";
        String b = "that is named Tom";
        String c = "This is a dog that is named Tom";
        assertEquals(c,a.concat(b));
        
        //Test 2: Test if the concatination of two strings is same as the result produced by .concat()
        String d = "abc ";
        String e = "efg";
        String f = "abc efg";
        assertEquals(f,d.concat(e));
        
        //Test 3: Test if the concatination of two strings is same as the result produced by .concat()
        String g = "Fluffy is ";
        String h = "a cat";
        String i = "Fluffy is a cat";
        assertEquals(i,g.concat(h));
        
        
    }
    
    //
    /**
     * This method test for compareTo()
     */
    @Test
    @DisplayName("Test Method 3")
    public void testMeth3(){
        
        //Test 1: Test fot two identical strings. Expected result = 0
        String a = "Hello";
        String b = "Hello";
        assertEquals(0, a.compareTo(b));
        
        //Test 2: Test for two non-identical strings. Expected result = -37
        String c  = "melko";
        assertEquals(-37, a.compareTo(c));
        
        //Test 3: Test for a case only where the first letter is different. Expected result = -17
        String d = "Yello";
        assertEquals(-17, a.compareTo(d));
        
    }
    
    /**
     * This is a test for chatAt()
     */
    @Test
    @DisplayName("Test Method 4")
    public void testMeth4(){
        
        String a  = "Hello";
        String b = "I am good";
        String c = "He is a cat";
        //Test 1: matching charactes of 0th index
        assertEquals('H', a.charAt(0));
        //Test 2: matching charactes of 2nd index
        assertEquals('a', b.charAt(2));
        //Test 3: matching charactes of 3rd index
        assertEquals('i', c.charAt(3));
        
    }
    
    /**
     * This method tests for indexOf()
     */
    @Test
    @DisplayName("Test Method 5")
    public void testMeth5(){
        
        String a  = "Hello";
        String b = "I am good";
        String c = "He is a cat";
        //Test 1: Test for index of H in String a
        assertEquals(0, a.indexOf('H'));
        //Test 2: Test for index of a in String b
        assertEquals(2, b.indexOf('a'));
        //Test 3: Test for index of i in String c
        assertEquals(3, c.indexOf('i')); 
        
    }
    /**
     * This method tests for substring()
     */
    @Test
    @DisplayName("Test Method 6")
    public void testMeth6(){
        
        String a  = "Hello world";
        String b = "I am good";
        String c = "He is a cat";
        
        //Test 1: Pull and compare substring from indices [0,5)
        assertEquals("Hello", a.substring(0,5));
        //Test 2: Pull and compare substring from indices [2,4)
        assertEquals("am", b.substring(2,4));
        //Test 3: Pull and compare substring from indices [3,5)
        assertEquals("is", c.substring(3,5));
    }
    /**
     * This method tests for split()
     */
    @Test
    @DisplayName("Test Method 7")
    public void testMeth7(){
        
        String a  = "123-567";
        String b = "abc@lafayette.edu";
        String c = "m.lcr";
        
        //Test 1: Using "-" as a parameter to split a string into array of two elements
        //Comparing the results using assertArrayEquals
        String[] expectedArray1 = {"123", "567"};
        String[] s1 = a.split("-", 0);
        assertArrayEquals(expectedArray1, s1);
        //Test 2: Using "@" as a parameter to split a string into array of two elements
        //Comparing the results using assertArrayEquals
        String[] expectedArray2 = {"abc", "lafayette.edu"};
        String[] s2 = b.split("@", 0);
        assertEquals(expectedArray2, s2);
        //Test 3: Using "." as a parameter to split a string into array of two elements
        //Comparing the results using assertArrayEquals
        String[] expectedArray3 = {"m", "lcr"};
        String[] s3 = c.split("\\.", 0);
        assertEquals(expectedArray3, s3);
    }
    
    
    }
    
