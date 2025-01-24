
/**
 * This class defines a Word, which has two characteritics: a string and a frequency. The class also defines methods namely: getWord(),
 * getFrequency(), incr(), toString(), and compateTo().
 *
 * @author Padmanabh Kaushik
 * @version 2/20/2024
 */
public class Word implements Comparable <Word>
{
    // instance variables - replace the example below with your own
    private String word;
    private int frequency;
    private int wordCount;

    /**
     * Constructor for objects of class Word
     */
    public Word(String word)
    {
        this.word = word;
        frequency  = 1;
    }

    
    /**
     * Returns the String word
     * @return word returns the string of the word
     */
    public String getWord(){
        return word;
    }
    
    /**
     * Returns the frequency of the word
     * @return frequency rfrequency of the word
     */
    public int getFrequency(){
        return frequency;
    }
    
    /**
     * Increments the frequency of the word
     */
    public void incr(){
        frequency++;
    }
    
    /**
     * Converts a word to string
     * @return a string for the word containing information about its spelling and frequency
     */
    @Override
    public String toString(){
        String a = "<" + word + ", " + frequency + ">";
        return a;
    }
    
    /**
     * Compares the frequency of two words
     * @param that Word whose frequency is to be compared to
     * @return diff the fifference between frequency of two words
     * 
     */
    @Override
    public int compareTo(Word that){
        return that.getFrequency() - this.getFrequency();
    }
}

