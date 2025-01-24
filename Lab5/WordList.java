
import java.util.ArrayList;
/**
 * The class constructs an array list of Word objects called wordFrequency. Defines methods getWordFrequency(), search(String w), getMostFrequent()
 * topKMostFrequent(int k), isStopWord(String word, ArrayList<String> stopWords), addWord(String w), addWord(String w,ArrayList<String> stopWords)
 * and getWord(int i).
 *
 * @author Padmanabh Kaushik
 * @version 2/20/2024
 */
public class WordList
{
    // instance variables - replace the example below with your own
    private ArrayList<Word> wordFrequency = new ArrayList<Word>();

    /**
     * Constructor for objects of class WordList
     */
    public WordList()
    {
        this.wordFrequency = wordFrequency;
    }

    /**
     * Returns the actual wordList array called wordFrequency
     * @return wordFrequency The list of Words
     */
    public ArrayList<Word> getWordFrequency(){
        return wordFrequency;
    }

    /**
     * Looks up if a specific Word with String w is present in the wordList array list wordFrequency. 
     * If the word is found, returns the index of the Word. Else returns -1.
     * 
     * @param w Word's string that is to be looked up the the ArrayList wordFrequency
     * @return j The index where word with String w is found 
     */
    public int search(String w){
        int j = -1; 

        for(int i = 0; i<wordFrequency.size(); i++){
            if(wordFrequency.get(i).getWord().equals(w)){
                j = i;   
                break;
            }
        }
        return j;
    }

    /**
     * Returns the most frequent word of the array list wordFrequency
     * @return returnWord Word with the highest frequency in the array list wordFrequency
     */
    public Word getMostFrequent(){
        //How do we want to handle the case when the list is empty??
        int freq = wordFrequency.get(0).getFrequency();
        Word returnWord = wordFrequency.get(0);

        for (int i = 0; i<wordFrequency.size() - 1; i++){
            if(wordFrequency.get(i).compareTo(wordFrequency.get(i+1)) > 0){
                freq = wordFrequency.get(i).getFrequency();
                //Assign the word with higher frequency to returnWord
                returnWord = wordFrequency.get(i+1);
            }
        }
        return returnWord;
    }

    /**
     * The methods looks up for the k most frequent words in the array list wordfrequency
     * 
     * @param k the number of most frequent words to be looked up for
     * @return result array of Words[] that contain that k most frequently occuring elements in  wordFrequency
     */
    public Word[] topKMostFrequent(int k){
        ArrayList<Word> wordFrequencyCopy = new ArrayList<Word>(wordFrequency);
        Word[] result = new Word[k];
        for(int i = 0; i<k; i++){
            int maxIndex = i;
            //Perform selection sort to place the words with biggest frequencies in the front
            for(int j = i+1; j<wordFrequencyCopy.size(); j++){
                if(wordFrequencyCopy.get(maxIndex).compareTo(wordFrequencyCopy.get(j)) > 0){
                    maxIndex = j;
                }
            }
            Word temp = wordFrequencyCopy.get(i);
            //may swaps according to the selection sort method
            wordFrequencyCopy.set(i, wordFrequencyCopy.get(maxIndex));
            wordFrequencyCopy.set(maxIndex, temp);
            //For every outer for loop iteration, place the largest frequency word at the left of the list, decided by index i
            result[i] = wordFrequencyCopy.get(i);
        }
        return result;
    }

    /**
     * Returns true if a word with a String "word" is in the array list stopWords. Else returns false.
     * 
     * @param word string of the word to be compared to the words in the Array List of stop words
     * @param stopWords an array list of stopwords
     * @return true if the the String word is in the Array List stopWords
     * @return false if the string word is not in the Array List stopWords
     */
    private boolean isStopWord(String word, ArrayList<String> stopWords){
        return stopWords.contains(word);
    }

    /**
     * Adds a word with a String word to the wordFrequency
     * @param word word to be added to wordFrequency
     * 
     */
    public void addWord(String word){
        int index = search(word);
        if(index != -1){
            wordFrequency.get(index).incr();
        }
        else{
            wordFrequency.add(new Word(word));
        }
    }

    /**
     * Gets the word at index i
     * @param i index of the word to be obtaines
     * @returns Word word at index i
     */
    public Word getWord(int i){
        return wordFrequency.get(i);
    }

    /**
     * Adds a string with String w, ensuring that w is not in the list of stopWords
     * @param word word to be added to wordFrequency
     * @param stopWords array list of stop words
     */
    public void addWord(String word, ArrayList<String> stopWords){
        if (!isStopWord(word, stopWords)) {
            int index = search(word);
            if(index != -1){
                wordFrequency.get(index).incr();
            }
            else{
                wordFrequency.add(new Word(word));
            }
        }
    }

}