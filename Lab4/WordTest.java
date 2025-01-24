

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class WordTest. Tests methods namely: getWord(),
 * getFrequency(), incr(), toString(), and compateTo().
 *
 * @author  Padmanabh Kaushik
 * @version 2/20/2024
 */
public class WordTest
{
    /**
     * Default constructor for test class WordTest
     */
    public WordTest()
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
     * Tests method getWord()
     */
    @Test
    public void getWordTest(){
        //Create a new word and try retrieving its String word
        Word word1 = new Word("Ace");
        assertEquals("Ace", word1.getWord());
        //Create a new word and try retrieving its String word
        Word word2 = new Word("Rock");
        assertEquals("Rock", word2.getWord());
    }
    
    /**
     * Tests method getFrequency()
     */
    @Test
    public void getFrequenctTest(){
        //Create a new word
        Word word1 = new Word("Ace");
        //Check its frequency
        assertEquals(1, word1.getFrequency());
        //increment the frequency
        word1.incr();
        //Ckeck the incremented frequency
        assertEquals(2, word1.getFrequency());
        //Increment the frequency
        word1.incr();
        word1.incr();
        //Check the incremented frequency
        assertEquals(4, word1.getFrequency());
    }
    
    /**
     * Tests method incr()
     */
    @Test
    public void testIncr(){
        //Create a new owrd
       Word word1 = new Word("Ace");
       //Increment the frequency 3 times
       word1.incr();
       word1.incr();
       word1.incr();
       //Check if the new frequency is 4
       assertEquals(4, word1.getFrequency());
       word1.incr();
       word1.incr();
       word1.incr();
       //Increment the frequency 3 times and check if the new freq. is 7
       assertEquals(7, word1.getFrequency());
       word1.incr();
       word1.incr();
       //Increment the frequency 2 times and check if the new freq. is 9
       assertEquals(9, word1.getFrequency());
    }
    
    /**
     * Tests method toString()
     */
    @Test
    public void testToString(){
        //Create a new word
        Word word1 = new Word("Ace");
        assertEquals("<Ace, 1>", word1.toString());
        word1.incr();
        //Word with incremented frequency
        assertEquals("<Ace, 2>", word1.toString());
        Word word2 = new Word(" ");
        //Word with a space as a string
        assertEquals("< , 1>", word2.toString());
    }
    
    /**
     * Tests method compareTo()
     */
    @Test
    public void testCompareTo(){
        //Create a new word
        Word word1 = new Word("Ace");
        //Increment its frequency
        word1.incr();
        //Create another word
        Word word2 = new Word("Ace1");
        //Check if the difference in frequenct is equal t0 -1
        assertEquals(-1, word1.compareTo(word2));
        //Increment the frequenct of word2
        word2.incr();
        word2.incr();
        word2.incr();
        word2.incr();
        //Check if the difference is 3
        assertEquals(3, word1.compareTo(word2));
        
    }
}
