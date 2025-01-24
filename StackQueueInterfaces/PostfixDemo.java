import java.util.Scanner;
import java.util.EmptyStackException;

/**
 * The stack based approach to evaluating postfix expressions.
 *
 * @author Jon Dahl
 * @version 1
 */
public class PostfixDemo
{
    /**
     * Evaluates given String according to postfix rules, assuming
     * delimination by whitespace and int values.
     * 
     * @param text expression to be evaluated
     * @return evaluated value according to int arithmetic
     * @throws ExpressionFormatExpression if text is not a valid postfix expression
     */
    public static int evaluate(String text) throws ExpressionFormatException{
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
}
