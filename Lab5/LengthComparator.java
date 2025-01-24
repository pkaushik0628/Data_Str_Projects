import java.util.Comparator;
import java.util.List;
/**
 * The class defines the compare method, which compares two words based on their length. Implements the length comparator.
 *
 * @author Padmanabh Kaushik
 * @version 3/5/2024
 */
public class LengthComparator implements Comparator<Word>
{
    /**
     * Constructor for objects of class LengthComparator
     */
    public LengthComparator()
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
     * 
     * If a and b are of different lengths, and a>b then returns a positive number, and vice versa
     * If a and b are of same lengths, and a is alphabetically higher yeilds a positive result
     * 
     * The method returns results in descending order
     * 
     */
    
    @Override
    public int compare(Word a, Word b)
    {
       if(a.getWord().length() != b.getWord().length()){
           return a.getWord().length() - b.getWord().length();
       }
       else{
           return b.getWord().compareTo(a.getWord());
       }
    }
}
