
import java.util.Scanner;
import java.util.EmptyStackException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/**
 * The class Lab 7 calls a main method, which uses a scanner class to read an input file with infix operations. These infix operations are then
 * processed and evaluated using the evaluateInfix() method. The class Lab 7 also defines methods evaluatePostFix() [evaluates a postfix expression],
 * infixToPostfix() [converts an infix to postfix expression], and simpleInfixToPostfix() [converts an an infix without powers and brackets to postfix].
 * Helper methods like getOperator(), doOperation(), getInputPerc(), getStackPer(), and getSymbol() have been defined to facilitate infix to postfix
 * conversion and performing postfix calculations.
 *
 * @author Padmanabh Kaushik
 * @version 3/26/2024
 */
public class Lab7
{   

    /**
     * Main method uses a scanner class to read an input file with infix operations. These infix operations are then
     * processed and evaluated using the evaluateInfix() method.
     * @param args command line input
     */
    public static void main(String[] args) throws IOException{
        try {
            //Specify a fale location
            File file = new File(args[0]);
            //Use scanner to read the file
            Scanner sc = new Scanner(file);
            //Call a file writer
            FileWriter newFile = new FileWriter(args[1]);
            //Create a BufferedWriter object to write data into the txt file
            BufferedWriter writeData = new BufferedWriter(newFile);
            //while the scanner has more lines
            while (sc.hasNextLine()) {
                //process the fnfix expression
                String line = sc.nextLine();
                System.out.println(line);
                try {
                    //Evaluate the infix expression
                    int result = evaluateInfix(line);
                    //write data to the output file
                    writeData.write(line + " = " + result);
                    writeData.newLine();

                } catch (Exception e) {
                    //If there is an expression, write the data to the output file
                    writeData.write(line + " = " + e.getMessage());
                    writeData.newLine();
                } 
            }
            //close the scanner and buffered writer
            sc.close();
            writeData.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes a postflix notation and returns the corresponding result
     *
     * @param  postflix postflix string
     * @return   result result of the postflix expression
     */
    public static int evaluatePostFix(String postflix) throws ExpressionFormatException
    {
        Scanner scanner = new Scanner(postflix);
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
     * Takes in an inflix expression without parenthesis or exponents and converts it to an inflix expression
     * @param inflix inflix expression to be converted to a postflix expression
     * @return postflix resultant postflix expression 
     */
    public static String simpleInfixToPostfix(String infix){
        Scanner scanner = new Scanner(infix);
        BasicStack<Operator> s = new ArrayBasedStack<Operator>();
        StringBuilder postflix = new StringBuilder();

        while(scanner.hasNext()){
            //If there is a next integer, append it into the postflix expression
            if(scanner.hasNextInt()){
                postflix.append(scanner.nextInt() + " ");
            }
            else{
                //otherwise the input must be an operator
                String operv = scanner.next();
                Operator oper = getOperator(operv);
                while( !s.isEmpty() && getSimplePrecedence(oper) <= getSimplePrecedence(s.peek())){
                    //append the operator to expression
                    postflix.append(getSymbol(s.pop())); 
                    postflix.append(" "); 
                }
                //push the operator to stack
                s.push(oper);
            }
        }
        while(!s.isEmpty()){
            postflix.append(getSymbol(s.pop()));
            postflix.append(" "); 
        }
        return postflix.toString();
    }

    /**
     * Takes in an inflix expression with parenthesis or exponents and converts it to an inflix expression
     * @param inflix inflix expression to be converted to a postflix expression
     * @return postflix resultant postflix expression 
     */
    public static String infixToPostfix(String infix){
        Scanner scanner = new Scanner(infix);
        BasicStack<Operator> s = new ArrayBasedStack<Operator>();
        StringBuilder postfix = new StringBuilder();
        Operator operator = null;

        while(scanner.hasNext()){
            //Check if the input is an integer/number
            if(scanner.hasNextInt()){
                postfix.append(scanner.nextInt() + " ");
            }
            //If it is an operator, operations have to be done on the stack
            else{
                //Obtain the operator
                //operv is the string expression for the operator
                String operv = scanner.next();
                operator = getOperator(operv);
                //All operators are treated equal, except close bracket
                if (!operator.equals(Operator.CLOSEBRACKET)){
                    while(!s.isEmpty() && getInputPerc(operator) <= getStackPerc(s.peek())){
                        if(!operator.equals(Operator.OPENBRACKET)){
                            postfix.append(getSymbol(s.pop())); 
                            postfix.append(" ");
                        }
                    }
                    //Push the operator to the stack
                    s.push(operator);
                }
                //If the close operator is a close bracket, append from the stack until an open bracket is encountered
                //and pop the open bracket to exclude it from the resultant string expression
                else if(operator.equals(Operator.CLOSEBRACKET)){
                    while(!s.isEmpty() && !s.peek().equals(Operator.OPENBRACKET)){
                        postfix.append(getSymbol(s.pop())); 
                        postfix.append(" ");  
                    }
                    s.pop();
                }
            }
        }
        //Process remnaining operators on the stack
        while(!s.isEmpty()){
            postfix.append(getSymbol(s.pop()));
            postfix.append(" "); 
        }
        //return the postfix expression
        return postfix.toString();
    }

    /**
     * Takes in an infix expression and computes the result
     * @param inflix inflix expression whose result is to be calculated
     * @return result result of the inflix expression
     */
    public static int evaluateInfix(String inflix){
        //Stage1: Convert the infix to postfix
        String stage1 = infixToPostfix(inflix);
        int result = 0;
        //Obtain the results for the postfix expression
        try
        {
            result = evaluatePostFix(stage1);
        }
        catch (ExpressionFormatException efe)
        {
            efe.printStackTrace();
        }
        return result;
    }

    /**
     * Returns the precedence of an operatot for an expressions without exponents
     * and parenthesis
     * @param op Operator whose precedence is to be determined
     * @return precedence precedence of the operatot
     */
    private static int getSimplePrecedence(Operator op){
        switch(op){
            case PLUS: return 1;
            case MINUS: return 1;
            case TIMES: return 2;
            case DIVIDE: return 2;
            default: throw new IllegalArgumentException();
        }
    }

    /**
     * The methods gives the input precedence of an operator
     * @param op operator whose input precedence is to be obtained
     * @return inputPrec an integer value defining the input precedence
     */
    private static int getInputPerc(Operator op){
        switch(op){
            case PLUS: return 1;
            case MINUS: return 1;
            case TIMES: return 2;
            case DIVIDE: return 2;
            case OPENBRACKET: return 5;
            case CLOSEBRACKET: return 0;
            case POWER: return 4;
            default: throw new IllegalArgumentException();
        }
    }

    /**
     * The methods gives the stack precedence of an operator
     * @param op operator whose stack precedence is to be obtained
     * @return stackPrec an integer value defining the stack precedence
     */
    private static int getStackPerc(Operator op){
        switch(op){
            case PLUS: return 1;
            case MINUS: return 1;
            case TIMES: return 2;
            case DIVIDE: return 2;
            case OPENBRACKET: return -1;
            case CLOSEBRACKET: return 0;
            case POWER: return 3;
            default: throw new IllegalArgumentException();
        }
    }

    /**
     * Converts the given String to its corresponding Operator value.
     * 
     * @param op String to convert
     * @return corresponding Operator
     * @throws IllegalArgumentException if op is not a supported operator
     */
    private static Operator getOperator(String op) {
        switch (op) {
            case "+": return Operator.PLUS;
            case "-": return Operator.MINUS;
            case "*": return Operator.TIMES;
            case "/": return Operator.DIVIDE;
            case "^": return Operator.POWER;
            case "(": return Operator.OPENBRACKET;
            case ")": return Operator.CLOSEBRACKET;
            default: throw new IllegalArgumentException();
        }
    }

    /**
     * The method takes in a operator and gives back the symbol for that operator
     * @param op Operator whose symbol is to be obtained
     * @return symbol string symbol for the operator
     */
    private static String getSymbol(Operator op) {
        switch (op) {
            case PLUS: return "+";
            case MINUS: return "-";
            case TIMES: return "*";
            case DIVIDE: return "/";
            case POWER: return "^";
            case OPENBRACKET: return "(";
            case CLOSEBRACKET: return ")";
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
    private static int doOperation(Operator op, int lhs, int rhs) {
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