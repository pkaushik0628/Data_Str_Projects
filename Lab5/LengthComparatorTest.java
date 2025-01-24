

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test class tests the length comparator, which compares two words based on their string length.
 *
 * @author  Padmanabh Kaushik
 * @version 2/5/2024
 */
public class LengthComparatorTest
{
    /**
     * Default constructor for test class LengthComparatorTest
     */
    public LengthComparatorTest()
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
     * This test method tests the length comparator.
     */
    @Test
    public void lengthCompTest(){
        //Create two words with equal frequecies and equal length. The expected answer is 0.
        Word word1 = new Word("Letter");
        Word word2 = new Word("Letter");
        LengthComparator comp1 = new LengthComparator();
        assertEquals(0, comp1.compare(word1, word2));
        //Create two words with equal but different alphabetical hierarchy. Expected result is > 0
        Word word3 = new Word("Abc");
        Word word4 = new Word("Bbb");
        assertTrue(comp1.compare(word3, word4)>0);
        //Create two words with different lengths. The expected result is > 0.
        Word word5 = new Word("londdon");
        Word word6 = new Word("paris");
        assertTrue(comp1.compare(word5, word6)>0);
    }
}
