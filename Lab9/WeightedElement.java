
/**
 * The class stores an element of type E with weight W.  The elements are compared based on comparable relying on W's compareTo()
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WeightedElement<E,W extends Comparable <? super W >> implements Comparable<WeightedElement<E,W>>
{
    // instance variables - replace the example below with your own
    private E element;
    private W weight;

    /**
     * Constructor for objects of class WeightedElement. The constructor takes in the element and it's weight
     * @param item item to be stores
     * @param wt weight of the item to be stored
     */
    public WeightedElement(E item, W wt)
    {
        element = item;
        weight = wt;
    }
    
    public int compareTo(WeightedElement<E,W> weightedElement){
        return this.weight.compareTo(weightedElement.getWeight());
    }
    
    public W getWeight(){
        return weight;
    }
    
    public E getElement(){
        return element;
    }

}
