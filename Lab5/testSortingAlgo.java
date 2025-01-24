

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * This test class tests the sorting algorithms namely selection soty, bubble sort, and insertion sort defined in the class Lab5.
 *
 * @author  Padmanabh Kaushik
 * @version 3/5/2024
 */
public class testSortingAlgo
{
    /**
     * Default constructor for test class testSortingAlgo
     */
    public testSortingAlgo()
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
     * This test method tests the bubble sort algorithm, in combination with the frequency comparator.
     */
    @Test
    public void testBubbleSort(){
        
        //Create words with same strings but different frequencies
        Word word1 = new Word("Letter");
        word1.incr();
        Word word2 = new Word("Letter");
        word2.incr();
        word2.incr();
        Word word3 = new Word("Letter");
        word3.incr();
        word3.incr();
        word3.incr();
        Word word4 = new Word("Letter");
        word4.incr();
        word4.incr();
        word4.incr();
        word4.incr();
        //Initialize a new array list of words
        ArrayList<Word> list1 = new ArrayList<>();
        list1.add(word4);
        list1.add(word2);
        list1.add(word1);
        list1.add(word3);
        FreqComparator comp1 = new FreqComparator();
        //bubble sort the array
        int n = Lab5.bubbleSort(list1, comp1);
        //Create the expected array list
        ArrayList<Word> list2 = new ArrayList<>();
        list2.add(word4);
        list2.add(word3);
        list2.add(word2);
        list2.add(word1);
        assertEquals(list2, list1);
        
        //create words with different strings and different frequencies
        Word word5 = new Word("Man");
        word1.incr();
        Word word6 = new Word("Dan");
        word2.incr();
        word2.incr();
        Word word7 = new Word("Less");
        word3.incr();
        word3.incr();
        word3.incr();
        Word word8 = new Word("More");
        word4.incr();
        word4.incr();
        word4.incr();
        word4.incr();
        //initialize a new array list of Words
        ArrayList<Word> list3 = new ArrayList<>();
        list1.add(word8);
        list1.add(word6);
        list1.add(word5);
        list1.add(word7);
        FreqComparator comp3 = new FreqComparator();
        //bubble sort the array
        int n1 = Lab5.bubbleSort(list3, comp3);
        //create expected array
        ArrayList<Word> list4 = new ArrayList<>();
        list2.add(word8);
        list2.add(word7);
        list2.add(word6);
        list2.add(word5);
        //compare the actual and expected arrays
        assertEquals(list4, list3);
        
    }
    
    /**
     * This test method tests the selection sort algorithm, in combination with the length comparator.
     */
    @Test
    public void testSelectionSort(){
        
        //Create words with different lengths an
        Word word1 = new Word("Holocaust");
        Word word2 = new Word("Letter");
        Word word3 = new Word("Let");
        Word word4 = new Word("Lr");
        ArrayList<Word> list1 = new ArrayList<>();
        list1.add(word4);
        list1.add(word2);
        list1.add(word1);
        list1.add(word3);
        LengthComparator comp1 = new LengthComparator();
        int n = Lab5.bubbleSort(list1, comp1);
        ArrayList<Word> list2 = new ArrayList<>();
        list2.add(word1);
        list2.add(word2);
        list2.add(word3);
        list2.add(word4);
        assertEquals(list2, list1);
        
        //create words with different strings and different frequencies
        Word word5 = new Word("Man");
        word1.incr();
        Word word6 = new Word("Dan");
        word2.incr();
        word2.incr();
        Word word7 = new Word("Less");
        word3.incr();
        word3.incr();
        word3.incr();
        Word word8 = new Word("More");
        word4.incr();
        word4.incr();
        word4.incr();
        word4.incr();
        ArrayList<Word> list3 = new ArrayList<>();
        list1.add(word5);
        list1.add(word6);
        list1.add(word7);
        list1.add(word8);
        LengthComparator comp3 = new LengthComparator();
        int n1 = Lab5.bubbleSort(list3, comp3);
        ArrayList<Word> list4 = new ArrayList<>();
        list2.add(word7);
        list2.add(word8);
        list2.add(word6);
        list2.add(word5);
        assertEquals(list4, list3);
        
    }
    
    /**
     * This test method tests the insertion sort algorithm, in combination with the word comparator.
     */
    @Test
    public void testInsertionSort(){
        
        //Create words with different lengths an
        Word word1 = new Word("Holocaust");
        Word word2 = new Word("Metter");
        Word word3 = new Word("Letter");
        Word word4 = new Word("Lr");
        ArrayList<Word> list1 = new ArrayList<>();
        list1.add(word4);
        list1.add(word2);
        list1.add(word1);
        list1.add(word3);
        LengthComparator comp1 = new LengthComparator();
        int n = Lab5.insertionSort(list1, comp1);
        ArrayList<Word> list2 = new ArrayList<>();
        list2.add(word1);
        list2.add(word3);
        list2.add(word2);
        list2.add(word4);
        assertEquals(list2, list1);
        
        //create words with same frequencies
        Word word5 = new Word("Man");
        word1.incr();
        word1.incr();
        Word word6 = new Word("Dan");
        word2.incr();
        word2.incr();
        //create two words with different frequencies
        Word word7 = new Word("Less");
        word3.incr();
        word3.incr();
        word3.incr();
        Word word8 = new Word("More");
        word4.incr();
        word4.incr();
        word4.incr();
        word4.incr();
        //Add words to the array
        ArrayList<Word> list3 = new ArrayList<>();
        list1.add(word5);
        list1.add(word6);
        list1.add(word7);
        list1.add(word8);
        WordComparator comp3 = new WordComparator();
        int n1 = Lab5.insertionSort(list3, comp3);
        //Create expected array
        ArrayList<Word> list4 = new ArrayList<>();
        list2.add(word7);
        list2.add(word8);
        list2.add(word6);
        list2.add(word5);
        assertEquals(list4, list3);
        
    }
}
