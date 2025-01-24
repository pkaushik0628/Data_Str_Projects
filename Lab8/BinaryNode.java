
/**
 * Defines a binary node, which stores a specific value in the binary and has a maximum of two other nodes connected to it: left node and right node
 * The class defines methods getVal(), setVal(), getRight(), setRight(), getLeft(), and setLeft().
 *
 * @author Padmanabh Kaushik
 * @version 4/16/2024
 */
public class BinaryNode<E>
{
    private E val;
    private BinaryNode<E> left;
    private BinaryNode<E> right;
    
    
    /**
     * Constructor#1 for binary node
     * @param d value for the node
     */
    BinaryNode(E d){
        if(d == null){
            throw new NullPointerException();
        }
        left = null;
        right = null;
        val = d;
    }
    
    /**
     * Constructor#2 for the binary node
     * @param d value of the node
     * @param l left node
     * @param r right node
     */
    BinaryNode(E d, BinaryNode<E> l, BinaryNode<E> r){
        left = l;
        right = r;
        val = d;
    }
    
    /**
     * Returns the value of the node
     * @return val value stored in the node
     */
    public E getVal(){
        return val;
    }
    
    /**
     * Sets the value of the node
     * @param d value to be set
     */
    public void setVal(E d){
        val = d;
    }
    
    /**
     * Returns the left node of the current node
     * @return left left node of the current node
     */
    public BinaryNode<E> getLeft(){
        return left;
    }
    
    /**
     * Returns the right node of the current node
     * @return right right node of the current node
     */
    public BinaryNode<E> getRight(){
        return right;
    }
    
    /**
     * Sets the left node of the current node
     * @param ln left node to be set for the current node
     */
    public void setLeft(BinaryNode<E> ln){
        left = ln;
    }
    
    /**
     * Sets the right node of the current node
     * @param rn right node to be set for the current node
     */
    public void setRight(BinaryNode<E> rn){
        right = rn;
    }
    
    
    
}
