
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is a test class which tests methods simpleInfixToPostfix(), infixToPostfix(), evaluatePostfix(), and evaluateInfix().
 *
 * @author  Padmanabh Kaushik
 * @version 3/26/2024
 */
public class Lab7Test
{
    /**
     * Default constructor for test class Lab7Test
     */
    public Lab7Test()
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
     * This is a test method for simpleInfixToPostfix() method 
     */
    @Test
    public void testSimpleInfixToPostfix(){
        //Expression 1: operators of same and different precedence
        String test1 = "3 + 4 * 5 - 11 * 2";
        assertEquals("3 4 5 * + 11 2 * - ", Lab7.simpleInfixToPostfix(test1));
        //Operators of same and different precedence
        String test2 = "3 + 4 * 7";
        assertEquals("3 4 7 * + ", Lab7.simpleInfixToPostfix(test2));
    }

    /**
     * This is a test method for infixToPostfix() method
     */
    @Test
    public void testInfixToPostfix(){
        //Double bracket and exponent
        String test1 = "( 1 + 2 ) * ( ( 3 + 5 ) ^ 5 )";
        assertEquals("1 2 + 3 5 + 5 ^ * ", Lab7.infixToPostfix(test1));
        //Single bracket and double exponent
        String test2 = "5 ^ ( 2 ^ 1 )";
        assertEquals("5 2 1 ^ ^ ", Lab7.infixToPostfix(test2));
    }

    /**
     * This is a test method for evaluatePostfix() method
     */
    @Test
    public void testPostFix() throws ExpressionFormatException{
        //Bracketed infix expression
        String test1 = "1 2 + 3 7 + *";
        assertEquals(30, Lab7.evaluatePostFix(test1));
        //Non bracketed infix expression
        String test2 = "3 4 7 * + ";
        assertEquals(31, Lab7.evaluatePostFix(test2));
    }

    /**
     * This is a test method for evaluateInfix()
     */
    @Test
    public void testEvaluateInflix(){
        //Double bracket
        String test1 = "( 1 + 2 ) * ( 3 + 7 )";
        assertEquals(30, Lab7.evaluateInfix(test1));
        //Double exponent and bracket
        String test2 = "5 ^ ( 2 ^ 1 )";
        assertEquals(25, Lab7.evaluateInfix(test2));
        //Operators of different priority
        String test3 = "4 * 3 + 2 - 1";
        assertEquals(13, Lab7.evaluateInfix(test3));
    }
}
