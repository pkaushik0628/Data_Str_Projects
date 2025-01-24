

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test class contains test methods for BinarySearchTree namely insert(), preOrderString(), postOrderString(), inOrderString(), empty(),
 * isEmpty(), and contains().
 *
 * @author  Padmanabh Kaushik
 * @version 4/16/2024
 */
public class BinarySearchTreeTest
{
    /**
     * Default constructor for test class BinarySearchTreeTest
     */
    public BinarySearchTreeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    /**
     * This is a test method for insert(E e)
     */
    @Test
    public void testInsert(){
        //test insert using a binary tree that stores Integers
        BinarySearchTree<Integer> tree = new BinarySearchTree();
        tree.insert(25);
        assertEquals("25 ", tree.preOrderString());
        tree.insert(14);
        tree.insert(36);
        //print out the string
        assertEquals("25 14 36 ", tree.preOrderString());
        tree.insert(9);
        tree.insert(15);
        tree.insert(35);
        tree.insert(38);
        //print out the string
        assertEquals("25 14 9 15 36 35 38 ", tree.preOrderString());
        //test insert using an binary tree that stores string
        BinarySearchTree<String> tree2 = new BinarySearchTree();
        tree2.insert("Here");
        tree2.insert("There");
        tree2.insert("All it takes");
        //Check if all the elements were inserted
        assertTrue(tree2.contains("Here"));
        assertTrue(tree2.contains("There"));
        assertTrue(tree2.contains("All it takes"));
        
    }
    
    /**
     * This is a test method for inOrderString() method.
     */
    @Test
    public void testInOrder(){
        //test inOrderString using an binary tree that stores Integers
        BinarySearchTree<Integer> tree = new BinarySearchTree();
        tree.insert(25);
        tree.insert(14);
        tree.insert(36);
        assertEquals("14 25 36 ", tree.inOrderString());
        tree.insert(9);
        tree.insert(15);
        tree.insert(35);
        tree.insert(38);
        assertEquals("9 14 15 25 35 36 38 ", tree.inOrderString());
        //test inOrderString using an binary tree that stores string
        BinarySearchTree<String> tree2 = new BinarySearchTree();
        tree2.insert("b");
        tree2.insert("c");
        tree2.insert("a");
        assertEquals("a b c ", tree2.inOrderString());
    }
    
    /**
     * This is a test method for postOrderString() method.
     */
    @Test
    public void testPostOrder(){
        //test postOrderString using an binary tree that stores Integers
        BinarySearchTree<Integer> tree = new BinarySearchTree();
        tree.insert(25);
        tree.insert(14);
        tree.insert(36);
        //test a 3 element tree
        assertEquals("14 36 25 ", tree.postOrderString());
        tree.insert(9);
        tree.insert(15);
        tree.insert(35);
        tree.insert(38);
        assertEquals("9 15 14 35 38 36 25 ", tree.postOrderString());
        //test postOrderString() using an binary tree that stores string
        BinarySearchTree<String> tree2 = new BinarySearchTree();
        tree2.insert("b");
        tree2.insert("c");
        tree2.insert("a");
        assertEquals("a c b ", tree2.postOrderString());
    }
    
    /**
     * This is a test method for preOrderString() method
     */
    @Test
    public void testPreOrder(){
        //test preOrderString() using an binary tree that stores Integers
        BinarySearchTree<Integer> tree = new BinarySearchTree();
        tree.insert(25);
        tree.insert(14);
        tree.insert(36);
        //test a three element tree
        assertEquals("25 14 36 ", tree.preOrderString());
        tree.insert(9);
        tree.insert(15);
        tree.insert(35);
        tree.insert(38);
        assertEquals("25 14 9 15 36 35 38 ", tree.preOrderString());
        //test preOrderString() using an binary tree that stores String
        BinarySearchTree<String> tree2 = new BinarySearchTree();
        tree2.insert("b");
        tree2.insert("c");
        tree2.insert("a");
        assertEquals("b a c ", tree2.preOrderString());
    }
    
    /**
     * This is a test method for contains(E e)
     */
    @Test
    public void testContains(){
        //test contains() using an binary tree that stores Integers
        BinarySearchTree<Integer> tree = new BinarySearchTree();
        tree.insert(25);
        tree.insert(14);
        tree.insert(36);
        tree.insert(9);
        tree.insert(15);
        tree.insert(35);
        tree.insert(38);
        //check contains for multiple elements
        assertTrue(tree.contains(25));
        assertTrue(tree.contains(38));
        //check with an element that is not present
        assertFalse(tree.contains(71));
        //test contains() using an binary tree that stores String
        BinarySearchTree<String> tree2 = new BinarySearchTree();
        tree2.insert("b");
        tree2.insert("c");
        tree2.insert("a");
        assertTrue(tree2.contains("a"));
        assertTrue(tree2.contains("b"));
        assertFalse(tree2.contains("z"));
    }
    
    /**
     * This is a test method for isEmpty()
     */
    @Test
    public void testIsEmpty(){
        //test empty() using an binary tree that stores Integers
       BinarySearchTree<Integer> tree = new BinarySearchTree();
       assertTrue(tree.isEmpty());
       tree.insert(45);
       tree.insert(35);
       assertFalse(tree.isEmpty());
       //test empty() using an binary tree that stores Strings
       BinarySearchTree<String> tree2 = new BinarySearchTree();
       assertTrue(tree2.isEmpty());
       tree2.insert("a");
       //tree with an element should return false
       assertFalse(tree2.isEmpty());
    }
    
    /**
     * This is a test method for empty()
     */
    @Test
    public void testEmpty(){
        BinarySearchTree<Integer> tree = new BinarySearchTree();
        //empty an empty tree and check results
        tree.empty();
        //check by calling the preorder string
        assertEquals("", tree.preOrderString());
        //add multiple elements
        tree.insert(25);
        tree.insert(14);
        tree.insert(36);
        tree.insert(9);
        tree.insert(15);
        tree.insert(35);
        tree.insert(38);
        //empty the list
        tree.empty();
        assertEquals("", tree.preOrderString());
        //Check empty(0 on a binary search tree that stores Strings
        BinarySearchTree<String> tree2 = new BinarySearchTree();
        tree2.empty();
        assertEquals("", tree2.preOrderString());
        //add elements
        tree2.insert("b");
        tree2.insert("c");
        tree2.insert("a");
        //check the expected and predicted results
        tree2.empty();
        assertEquals("", tree2.preOrderString());
    }
}
