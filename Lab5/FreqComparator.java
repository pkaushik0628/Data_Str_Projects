import java.util.Comparator;
import java.util.List;

/**
 * The class describes the compare method, which compares two words based on their frequencies. The compare method returns the diference
 * in frequency of the two words.
 *
 * @author Padmanabh Kaushik
 * @version 3/5/2024
 */
public class FreqComparator implements Comparator <Word>
{

    /**
     * Constructor for objects of class FreqComparator
     */
    public FreqComparator()
    {
     
    }

    /**
     * The method compares two words based on their frequencies
     *
     * @param  a Reference word object
     * @param b word to be compared to the reference
     * @return diff the difference between the frequencies of Words a and b
     * 
     * Result in positive if frequency(a) > frequency (b)
     * Result is 0 if frequency(a) = frequency(b)]
     * Result is negative if frequency(b)> frequency(a)
     */
    
    @Override
    public int compare(Word a, Word b){
        return a.getFrequency() - b.getFrequency();
    }
    
}
