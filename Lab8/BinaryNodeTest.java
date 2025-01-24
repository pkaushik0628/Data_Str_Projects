

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test class contains test methods for BinaryNode namely getVal(), setVal(), getLeft(), setLeft(), getRight(), setRight()
 *
 * @author  Padmanabh Kaushik
 * @version 4/16/2024
 */
public class BinaryNodeTest
{
    /**
     * Default constructor for test class BinaryNodeTest
     */
    public BinaryNodeTest()
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
     * This is a test method for getVal()
     */
    @Test
    public void testGetVal(){
        BinaryNode<Integer> node1 = new BinaryNode(2);
        assertEquals(2, node1.getVal());
        
        BinaryNode<String> node2 = new BinaryNode("Here");
        assertEquals("Here", node2.getVal());
    }
    
    /**
     * This is a test method for setVal()
     */
    @Test
    public void testSetVal(){
        BinaryNode<Integer> node1 = new BinaryNode(2);
        node1.setVal(5);
        assertEquals(5, node1.getVal());
        
        BinaryNode<String> node2 = new BinaryNode("Here");
        node2.setVal("There");
        assertEquals("There", node2.getVal());
    }
    
    /**
     * This is a test method for getRight()
     */
    @Test
    public void testGetRight(){
        BinaryNode<Integer> node1 = new BinaryNode(2);
        BinaryNode<Integer> node2 = new BinaryNode(5);
        
        node1.setRight(node2);
        assertEquals(5, node1.getRight().getVal());
        
        BinaryNode<String> node3 = new BinaryNode("La La La");
        BinaryNode<String> node4 = new BinaryNode("Ha ha ha");
        
        node4.setRight(node3);
        assertEquals("La La La", node4.getRight().getVal());
        
    }
    
    /**
     * This is a test method for setRight()
     */
    @Test
    public void testSetRight(){
        BinaryNode<Integer> node1 = new BinaryNode(7);
        BinaryNode<Integer> node2 = new BinaryNode(25);
        
        node1.setRight(node2);
        assertEquals(25, node1.getRight().getVal());
        
        BinaryNode<String> node3 = new BinaryNode("El puerta del sol");
        BinaryNode<String> node4 = new BinaryNode("Esta aqui");
        
        node4.setRight(node3);
        assertEquals("El puerta del sol", node4.getRight().getVal());
    }
    
    /**
     * This is a test method for getLeft()
     */
    @Test
    public void testGetLeft(){
        BinaryNode<Integer> node1 = new BinaryNode(12);
        BinaryNode<Integer> node2 = new BinaryNode(95);
        
        node1.setLeft(node2);
        assertEquals(95, node1.getLeft().getVal());
        
        BinaryNode<String> node3 = new BinaryNode("abc");
        BinaryNode<String> node4 = new BinaryNode("xyz");
        
        node4.setLeft(node3);
        assertEquals("abc", node4.getLeft().getVal());
    }
    
    /**
     * This is test method for setLeft()
     */
    @Test
    public void testSetLeft(){
        BinaryNode<Integer> node1 = new BinaryNode(0);
        BinaryNode<Integer> node2 = new BinaryNode(45);
        
        node1.setLeft(node2);
        assertEquals(45, node1.getLeft().getVal());
        
        BinaryNode<String> node3 = new BinaryNode("thn");
        BinaryNode<String> node4 = new BinaryNode("lnh");
        
        node4.setLeft(node3);
        assertEquals("thn", node4.getLeft().getVal());
    }
}
