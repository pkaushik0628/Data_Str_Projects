
/**
 * Defines the tree interface
 *
 * @author Padmanabh Kaushik
 * @version 4/16/2024
 */
public interface Tree<E>
{
    
    /**
     * Inserts an element to the tree. If insertion of an element is successful, true is returned. Else false is returned.
     * @param e the iterm to be inserted into the binary serach tree
     * @return bool boolean value depending on if the insertion was successful
     * 
     */
    public boolean insert(E e);
    
    
    /**
     * The method determines if an item e is present in the tree
     * @param d item to be searched for in the tree
     * @return bool true if the value is found in the tree, else false
     */
    public boolean contains(E e);
    
    /**
     * Returns the string expression of the tree by performing a pre-order traversal
     * @return str Pre-order String expression of the tree
     */
    public String preOrderString();
    
    /**
     * Returns the string expression of the tree by performing a in-order traversal
     * @return str Pre-order String expression of the tree
     */
    public String postOrderString();
    
    /**
     * Returns the string expression of the tree by performing a in-order traversal
     * @return str Pre-order String expression of the tree
     */
    public String inOrderString();
    
    /**
     * Removes all elements from the tree
     */
    public void empty();
    
    
    /**
     * Determines if the tree is empty
     * @return bool true if the tree is empty, else false
     */
    public boolean isEmpty();
    
}
