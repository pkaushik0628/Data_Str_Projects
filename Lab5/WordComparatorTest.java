

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is a test class for word comparator, which compares words based on both their string length, frequency, and alphabetical hierarchy.
 *
 * @author  Padmanabh Kaushik
 * @version 3/5/2024
 */
public class WordComparatorTest
{
    /**
     * Default constructor for test class WordComparatorTest
     */
    public WordComparatorTest()
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
     * This test method tests the word comparator.
     */
    @Test
    public void lengthCompTest(){
        //Create two words with different frequencies but the same string length. Expected result >0
        Word word1 = new Word("Letter");
        word1.incr();
        word1.incr();
        Word word2 = new Word("Letter");
        WordComparator comp1 = new WordComparator();
        assertTrue(comp1.compare(word1, word2)>0);
        //Create two words with different lengths but same frequency. expected result >0
        Word word3 = new Word("Abcdef");
        Word word4 = new Word("Bbb");
        assertTrue(comp1.compare(word3, word4)>0);
        //Create two words with same length and frequency but different alphabetical hierarchy. Expected result>0 
        Word word5 = new Word("abc");
        Word word6 = new Word("bbc");
        assertTrue(comp1.compare(word5, word6)>0);
    }
}
