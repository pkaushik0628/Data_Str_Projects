
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
/**
 * Tis test class tests the methods in  WordList namely: getWordFrequency(), search(String w), getMostFrequent()
 * topKMostFrequent(int k), isStopWord(String word, ArrayList<String> stopWords), addWord(String w),
 * addWord(String w,ArrayList<String> stopWords), and getWord(int i).
 *
 * @author  Padmanabh Kaushik
 * @version 2/20/2024
 */
public class WordListTest
{
    /**
     * Default constructor for test class WordListTest
     */
    public WordListTest()
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
     * Tests the method getWordFrequency
     */
    @Test
    public void testGetWordFrequency(){
        //Create and compare two blank lists
        WordList list1 = new WordList();
        ArrayList<Word> expectedList = new ArrayList<Word>();
        assertEquals(expectedList, list1.getWordFrequency());
        //add new words to the actual list
        list1.addWord("Here");
        list1.addWord("There");
        //Add new words to the expected list
        expectedList.add(list1.getWordFrequency().get(0));
        expectedList.add(list1.getWordFrequency().get(1));
        //compare the actual and the expected list using assertEquals
        assertEquals(expectedList, list1.getWordFrequency());
    }

    /**
     * Tests the method addWord(String word) and addWord(String word, ArrayList<String> stopWords)
     * 
     * This method also indirectly tests the private method isStopWord(String word, ArrayList<String> stopWords) because 
     * addWord(String a, ArrayList<String> stopWords) calls isStopWord to ensure that the words being added to the WordList
     * are not in the list of stopWords.
     * 
     */
    @Test
    public void testAddWord(){
        WordList list1 = new WordList();
        //Create a list of stopWords
        ArrayList<String> stopWords = new ArrayList<String>();
        stopWords.add("and");
        //Add words to the word list
        list1.addWord("Here");
        list1.addWord("There");
        //Check if the added words are there in the word list
        assertEquals(0, list1.search("Here"));
        assertEquals(1, list1.search("There"));
        //Add another word to the word list, which already exits in the word list
        list1.addWord("There");
        //Check if the frequency of the already existing word is incremented
        assertEquals(2, list1.getWord(list1.search("There")).getFrequency());
        //The word list add method is not supposed to add and. But if and is added, it should be in position 2
        list1.addWord("and", stopWords);
        //If the addWord with a stopWord array list parameter works correly, Word Memy should be at index 2
        //Success of this test will indicate that and was not added because it was in the list of stopWords
        list1.addWord("Memy");
        assertEquals(2, list1.search("Memy"));
    }

    /**
     * Tests the method search()
     */
    @Test
    public void searchString(){
        WordList list1 = new WordList();
        list1.addWord("Here");
        list1.addWord("There");
        assertEquals(0, list1.search("Here"));
        assertEquals(1, list1.search("There"));
        assertEquals(-1, list1.search("Mango"));
    }

    /**
     * Tests the method getMostFrequent()
     */
    @Test
    public void testGetMostFrequent(){
        //Creqte a wordList with different frequency of words
        WordList list1 = new WordList();

        list1.addWord("Here");
        list1.addWord("Here");
        list1.addWord("Here");
        list1.addWord("Here");
        list1.addWord("There");

        assertEquals(list1.getWordFrequency().get(0), list1.getMostFrequent());
        list1.addWord("There");
        list1.addWord("There");
        list1.addWord("There");
        list1.addWord("There");
        list1.addWord("There");
        list1.addWord("There");
        assertEquals(list1.getWordFrequency().get(1), list1.getMostFrequent());
    }

    /**
     * Tests method getKMostFrequent()
     */
    @Test
    public void testGetKMostFrequent(){
        //Create a new word list
        WordList list1 = new WordList();
        //Add elements with different frequency
        list1.addWord("Here");
        list1.addWord("Here");
        list1.addWord("Here");
        list1.addWord("There");
        list1.addWord("There");
        list1.addWord("Everywhere");

        //Create the expected results
        Word[] expectedArray = new Word[3];
        expectedArray[0] = list1.getWordFrequency().get(0);
        expectedArray[1] = list1.getWordFrequency().get(1);
        expectedArray[2] = list1.getWordFrequency().get(2);

        //Get the frequency array using topKMostFrequent()
        Word[] actualArray = list1.topKMostFrequent(3);

        // Compare the contents of the arrays
        assertArrayEquals(expectedArray, actualArray);

        //Test 2: Create another wordList
        WordList list2 = new WordList();
        list2.addWord("Here");
        list2.addWord("Here");
        list2.addWord("Here");
        list2.addWord("Here");
        list2.addWord("Thailand");
        list2.addWord("There");
        list2.addWord("There");
        list2.addWord("There");
        list2.addWord("Everywhere");
        list2.addWord("Everywhere");
        list2.addWord("Everywhere");
        list2.addWord("Nowhere");
        list2.addWord("Nowhere");
        list2.addWord("Elsewhere");
        list2.addWord("allandall");

        //Create expected results
        Word[] expectedArray2 = new Word[4];
        expectedArray2[0] = list2.getWordFrequency().get(0);
        expectedArray2[1] = list2.getWordFrequency().get(2);
        expectedArray2[2] = list2.getWordFrequency().get(3);
        expectedArray2[3] = list2.getWordFrequency().get(4);
        //Get the actual result using topKMostFrequent()
        Word[] actualArray2 = list2.topKMostFrequent(4);
        //Compare expected results and actual resultys using assertEquals
        assertArrayEquals(expectedArray2, actualArray2);

    }
}
