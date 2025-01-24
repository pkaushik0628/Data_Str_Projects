
/**
 * The class defines a binary search search tree, where each parent node has two nodes: left and right. The left node has a value always lesser
 * than the parent node, and the right node has a value always greater than the parent node. The class overrides methods insert(E e) and
 * contains(E d) from abstract class BinaryTree.
 *
 * @author Padmanabh Kaushik
 * @version 4/16/2024
 */
public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E>
{
    
    /**
     * Constructor for class BinarySearchTree
     */
    public BinarySearchTree()
    {
        root  = null;
    }

    /**
     * Overrides the method insert for abstract class BinaryTree. If insertion of an element is successful true is returned. Else false is returned.
     * @param e the iterm to be inserted into the binary serach tree
     * @return bool boolean value depending on if the insertion was successful
     * 
     * Note: Insertion is done such that every parent node has two nodes: left and right. The left node has a value always lesser than the parent 
     * node, and the right node has a value always greater than the parent node.
     */
    @Override
    public boolean insert(E e){
        BinaryNode<E> toInsert = new BinaryNode(e);
        
        if(this.contains(e)){
            return false;
        }
        
        if(root == null){
            root = toInsert;
            return true;
        }
        else{
            BinaryNode<E> current = root;
            while(current != null){
                //if value of toInsert is less than value of current node 
                if(toInsert.getVal().compareTo(current.getVal())<0){
                    if(current.getLeft() == null){
                        //insert to left
                        //return true
                        current.setLeft(toInsert);
                        return true;
                    }
                    else{
                        //else keep on moving to the left
                        current = current.getLeft();
                    }
                }
                else{
                    if(current.getRight() == null){
                        //insert to right
                        //return true
                        current.setRight(toInsert);
                        return true;
                    }
                    else{
                        //else move to the right
                        current = current.getRight();
                    }
                }
            }
        }
        //otherwise return false
        return false;
    }
    
    /**
     * Determines if an element in present in  the binary search tree
     * @param e item to be searched for in the binary search tree
     * @return bool true if the element is found in the BST, else returns false
     * 
     * Note: This method overrides the contains(E e) of the BinaryTree, and operates on the specific principle that for a parent node,
     * the chuild with lesser value is the left node, and child with a greater value is the right node.
     * 
     * Note: The method calls helper method contains(NinaryNode<E> current, E target)
     */
    @Override
    public boolean contains(E d){
        return contains(root, d);
    }
    
    /**
     * It is a helper method that is recursively called to check the left and right branches of each subtree present in the BST.
     * @param current root node of the Binary Search Tree
     * @param target element to be searched for in the Binary Search Tree
     * @return bool true if the element is found in one of the subtrees, else returns false
     */
    private boolean contains(BinaryNode<E> current, E target){
        
        if(current == null) return false;
        else if (current.getVal().equals(target)){
            return true;
        }
        else if( current.getVal().compareTo(target) <0){
            return contains(current.getRight(), target);
        }
        else{
            return contains(current.getLeft(), target);
        }
    }
}
