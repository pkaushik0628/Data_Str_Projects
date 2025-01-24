
/**
 * The abstract class deines a binary tree used with nodes for storing generic elements. the class defines abstract method insert(E e), and regular
 * methods preOrderString(), postOrderString(), inOrderString(), empty(), isEmpty(), and contains(E e).
 *
 * @author Padmanabh Kaushik
 * @version 4/16/2024
 */
public abstract class BinaryTree<E extends Comparable<? super E>> implements Tree<E>
{

    BinaryNode<E> root = null;

    /**
     * Constructor for objects of class BinaryTree
     */
    public BinaryTree()
    {
        root = null;
    }

    /**
     * The method determines if an item e is present in the binary search tree
     * @param d item to be searched for in the Binary tree
     * @return bool true if the value is found in the binary tree, else false
     */
    public boolean contains(E d){
        return contains(root, d);
    }

    /**
     * Defines abstract method insert()
     */
    public abstract boolean insert(E e);
    
    /**
     * Helper method that that recursively calls itself to determine if a item target is present in the binary tree
     * Node: the algorithm looks through the entirity of the tree to determine the final outcome.
     * @param current root of the binary tree
     * @target item to be looked for in the binary tree
     */
    private boolean contains(BinaryNode<E> current, E target){
        
        if(current == null) return false;
        else if (current.getVal().equals(target)){
            return true;
        }
        else{
            return (contains(current.getLeft(), target) || contains(current.getRight(), target));
        }
    }

    /**
     * Returns the string expression of the tree by performing a pre-order traversal
     * @return str Pre-order String expression of the binary tree
     */
    public String preOrderString(){
        StringBuilder line = new StringBuilder();
        BinaryNode<E> current = root;
        preOrderTraversal(current, line);
        return line.toString();
    }

    /**
     * Helper method that performs a pre-order traversal throug the tree
     * @param node root of the tree
     * @param s StringBuilder object that is used to create the string expression if the list
     */
    private void preOrderTraversal(BinaryNode<E> node, StringBuilder s){
        if(node != null){
            s.append(node.getVal() + " ");
            preOrderTraversal(node.getLeft(), s);
            preOrderTraversal(node.getRight(), s);
        }
    }

    /**
     * Returns the string expression of the tree by performing a in-order traversal
     * @return str Pre-order String expression of the binary tree
     */
    public String inOrderString(){
        StringBuilder line = new StringBuilder();
        BinaryNode<E> current = root;
        inOrderTraversal(current, line);
        return line.toString();
    }

    /**
     * Helper method that performs a in-order traversal throug the tree
     * @param node root of the tree
     * @param s StringBuilder object that is used to create the string expression if the list
     */
    private void inOrderTraversal(BinaryNode<E> node, StringBuilder s){
        if(node != null){
            inOrderTraversal(node.getLeft(), s);
            s.append(node.getVal() + " ");
            inOrderTraversal(node.getRight(), s);
        }
    }

    /**
     * Returns the string expression of the tree by performing a post-order traversal
     * @return str Pre-order String expression of the binary tree
     */
    public String postOrderString(){
        StringBuilder line = new StringBuilder();
        BinaryNode<E> current = root;
        postOrderTraversal(current, line);
        return line.toString();
    }

    /**
     * Helper method that performs a post-order traversal throug the tree
     * @param node root of the tree
     * @param s StringBuilder object that is used to create the string expression if the list
     */
    private void postOrderTraversal(BinaryNode<E> node, StringBuilder s){
        if(node != null){
            postOrderTraversal(node.getLeft(), s);
            postOrderTraversal(node.getRight(), s); 
            s.append(node.getVal() + " ");
        }
    }

    /**
     * Removes all elements from the binary tree
     */
    public void empty(){
        root = null;
    }

    /**
     * Determines if the binary tree is empty
     * @return bool true if the list is empty, else false
     */
    public boolean isEmpty(){
        if(root == null) return true;
        else return false;
    }

}
