import java.util.Comparator;
import java.util.List;
/**
 * The class describes the compare method, which compares two words based on their lengths, frequencies, and alphabetical hierarchy. If
 * two words have different frequencies, the method returns the difference of their frequencies. If the words have same frequency but 
 * different lengths, the method returns the difference in lengths. If the words have same frequency and lengths, its uses compareTo
 * return a difference based on alphabetical hierarchy.
 *
 * @author Padmanabh Kaishik
 * @version 3/5/2024
 */
public class WordComparator implements Comparator<Word>
{

    /**
     * Default constructor for Word Comparator
     */
    public WordComparator()
    {
    }

    /**
     * The method overrides compare method. The method compares
     * Two words based on their String lengths, and returns their
     * difference
     *
     * @param  a  first word
     * @param  b  second word
     * @return diff difference between lengths of word a and b
     */
    
    @Override
    public int compare(Word a, Word b)
    {
       if(a.getWord().length() != b.getWord().length()){
           return a.getWord().length() - b.getWord().length();
       }
       else{
           if(a.getFrequency() != b.getFrequency()){
               return a.getFrequency() - b.getFrequency();
           }
           else{
               return b.getWord().compareTo(a.getWord());
           }
       }
    }
}
