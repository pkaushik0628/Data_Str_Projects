import java.util.Scanner;
import java.util.EmptyStackException;

/**
 * Write a description of class Lab7 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab7
{
    

    

    /**
     * Takes a postflix notation and returns the corresponding result
     *
     * @param  postflix postflix string
     * @return   result result of the postflix expression
     */
    public int evaluatePostFix(String postflix)
    {
       Scanner scanner = new Scanner(text);
        BasicStack<Integer> s = new ArrayBasedStack<Integer>();
        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                // if token is an operand, push it on the stack
                s.push(scanner.nextInt());
            } else {
                // otherwise, perform the operation on the top two elements
                Operator op = getOperator(scanner.next());
                try{
                    // note the order is important
                    int rhs = s.pop();
                    int lhs = s.pop();
                    s.push(doOperation(op, lhs, rhs));
                }catch (EmptyStackException e){
                    // there weren't two operands on the stack
                    throw new ExpressionFormatException("Missing operand for " + op);
                }
            }
        } 
        // result should be the only item on
        // the stack
        if (s.size() != 1){
            throw new ExpressionFormatException("Unused operands");
        }
        return s.pop();
    }
    
    /**
     * Converts the given String to its corresponding Operator value.
     * 
     * @param op String to convert
     * @return corresponding Operator
     * @throws IllegalArgumentException if op is not a supported operator
     */
    public static Operator getOperator(String op) {
        switch (op) {
            case "+": return Operator.PLUS;
            case "-": return Operator.MINUS;
            case "*": return Operator.TIMES;
            case "/": return Operator.DIVIDE;
            case "^": return Operator.POWER;
            default: throw new IllegalArgumentException();
        }
    }
    
    /**
     * Applies the given operator to the given ints.
     * 
     * @param op operator to apply
     * @param lhs left operand
     * @param rhs right operand
     * @return evaluated value
     */
    public static int doOperation(Operator op, int lhs, int rhs) {
        switch (op) {
            case PLUS: return lhs + rhs;
            case MINUS: return lhs - rhs;
            case TIMES: return lhs * rhs;
            case DIVIDE: return lhs / rhs;
            case POWER: return (int) java.lang.Math.pow(lhs, rhs);
            default: throw new IllegalStateException(); // should never happen
        }
    }
    
    /**
     * Takes in an inflix expression without parenthesis or exponents and converts it to an inflix expression
     * @param inflix inflix expression to be converted to a postflix expression
     * @return postflix resultant postflix expression 
     */
    public String simpleInflixToPostflix(String inflix){
        return "returned";
    }
    
    /**
     * Takes in an inflix expression with parenthesis or exponents and converts it to an inflix expression
     * @param inflix inflix expression to be converted to a postflix expression
     * @return postflix resultant postflix expression 
     */
    public String inflixToPostflix(){
        return "returned";
    }
    
    /**
     * Takes in an inflix expression and computes the result
     * @param inflix inflix expression whose result is to be calculated
     * @return result result of the inflix expression
     */
    public int evaluateInflix(String inflix){
        return 0;
    }
    
    
    
}
