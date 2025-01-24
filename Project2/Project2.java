
/**
 * The class Project2 calls the main method, which in turns creates a doubling list, adds elements to it, removed elements from it, prints out 
 * teh list string, calls the IistIterator, followed by again adding and removing elemnets in the list and printing out the final outcomes.
 * The main purpose of this class is to test the functionality of the Doubling List.
 *
 * @author Padmanabh Kaushik
 * @version 04/15/2024
 */
public class Project2
{
    /**
     * the main method creates a doubling list, adds elements to it, removed elements from it, prints out 
     * the list string, calls the IistIterator, followed by again adding and removing elemnets in the list and printing out the final outcomes.
     * The main purpose of this class is to test the functionality of the Doubling List.
     * @param args command line input array
     */
    public static void main (String[] args){
        //initialize the DoublingList
        DoublingList<String> list1 = new DoublingList<>();
        //add elements
        list1.add("happy days");
        list1.add("at ABC");
        list1.add("can never be back");
        list1.add("Here's the truth");
        list1.add(2, "So here it goes");
        list1.add("I");
        list1.add("2");
        list1.add(7, "Khagen");
        //remove items
        list1.remove(1);
        list1.remove(2);
        //print the list
        System.out.println(list1.toStringInternal());
        DoublingList.DoublingListIterator iter = list1.new DoublingListIterator();
        System.out.println(list1.toStringInternal(iter));
        //move pointer forward
        iter.next();
        iter.next();
        System.out.println(iter.next());
        //print with iterator
        System.out.println(list1.toStringInternal(iter));
        //remove item 3 
        list1.remove(3);
        System.out.println(list1.toStringInternal(iter));
        //add another item
        list1.add("Here I go");
        //print the list
        System.out.println(list1.toStringInternal(iter));
    }
}
