

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test class tests the frequency comparator, which compares two Word objects based on their frequencies.
 *
 * @author  Padmanabh Kaushik
 * @version 3/5/2024
 */
public class FreqComparatorTest
{
    /**
     * Default constructor for test class FreqComparatorTest
     */
    public FreqComparatorTest()
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
     * The methods tests for frequency comparator
     */
    @Test
    public void freqCompTest(){
        Word word1 = new Word("Letter");
        Word word2 = new Word("Letter");
        FreqComparator comp1 = new FreqComparator();
        assertEquals(0, comp1.compare(word1, word1));
        
        Word word3 = new Word("Letter");
        word3.incr();
        word3.incr();
        Word word4 = new Word("Lost");
        assertEquals(2, comp1.compare(word3, word4));
        
    }
}
