import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

/**
 * CS 150 Lab 1:
 * Description: The public class Lab1 calls the main method. The main method uses a scanner to take multiple lines of input from the
 * user by going through a while(true) loop. After the user gives an input, the the program checks what the user entered is
 * not a blank line. Following this, the program uses another scanner and a while loop to count the total number of words
 * and characters in a given segment of user input. The program exits the while(true) loop is the user enters a blank line. If
 * a blank line is entered, the summary of the total lines, words, and characters is printed in the console, as well as the same
 * information is saved in the txt file. For creating and writing data into a text file, FileWriter() and BufferedWriter() are used
 * respectively.
 * 
 * @author Padmanabh Kaushik
 * @version 1/25/24
 */

public class Lab1
{
    /**
     * The main method uses a scanner to take multiple lines of input from the user by going through a while(true) loop. 
     * After the user gives an input, the the program checks what the user entered is not a blank line. 
     * Following this, the program uses another scanner and a while loop to count the total number of words and characters 
     * in a given segment of user input. The program exits the while(true) loop is the user enters a blank line. If a blank 
     * line is entered, the summary of the total lines, words, and characters is printed in the console, as well as the same
     * information is saved in the txt file. For creating and writing data into a text file, FileWriter() and BufferedWriter() 
     * are used respectively.
     * 
     * @param args Required for the general syntax to call the main method. Doesn't perform any specific function in this program.
     * 
     */
    public static void main(String [] args) throws IOException{

        //Used for counting total no. of lines
        int totalLine = 0;
        //Used for counting total no. of words
        int totalWords = 0;
        //Used for counting total number of characters
        int totalChars = 0;

        //Variables used for counting words, lines, and characters in an individual entry
        int line = 0;
        int word = 0;
        int characters = 0;
        
        //Create a new txt file using a FileWriter
        FileWriter newFile = new FileWriter("data.txt");
        //Create a BufferedWriter object to write data into the txt file
        BufferedWriter writeData = new BufferedWriter(newFile);

        while(true){
            Scanner s = new Scanner(System.in);
            String userInput = s.nextLine();

            if(!userInput.isEmpty()){
                //Print an error message that system is continuing into the loop, i.e.
                //the user input is not a blank line
                System.err.println("Continuing to loop >>"+ userInput+ "<<");
                //Print the sentence/input line entered by the user
                System.out.println(userInput);
                //Write the user input line into the txt file, followed by a new line
                writeData.write(userInput);
                writeData.newLine();
                //Increment the no of lines
                line = line+1;

                //Create a second scanner to read the userInput as a String
                Scanner wordScanner = new Scanner(userInput);
                
                // Initialize a integer a, to count the number of times the code runs through
                // the while loop for an input line entered by the user
                int a = 0;
                //The while loop uses a scanner object to read words in userInput separated by 
                // spaces. wordScanner.next() identifies individual words in the scanner object
                // The while loop runs until all words in the input line are counted
                while(wordScanner.hasNext()){
                    String w = wordScanner.next();
                    System.out.println(w);
                    characters = w.length();
                    //totalChars = totalChars + characters;
                    a = a + 1;
                }
                
                //Calculation of total characters and total words
                totalChars = totalChars + userInput.length();
                totalWords = totalWords + a;
            }
            //The program breaks out of the while(true) loop if the user enters a blank line
            else if(userInput.isEmpty()){
                System.err.println("Exiting loop");
                break;
            }
            //Closes the scanner
            s.close();
        }
        
        //Prints output to the console
        System.out.println();
        System.out.println();
        System.out.println();
        //Adds blank lines to the txt file
        writeData.newLine();
        writeData.newLine();
        writeData.newLine();
        //Prints output to the console
        System.out.println("=======================================");
        System.out.println("Line Count: "+ line);
        System.out.println("Word Count: "+ totalWords);
        System.out.println("Char Count: "+ totalChars);
        //Writes output to the txt file
        writeData.write("=======================================");
        writeData.newLine();
        writeData.write("Line Count: "+ line);
        writeData.newLine();
        writeData.write("Word Count: "+ totalWords);
        writeData.newLine();
        writeData.write("Char Count: "+ totalChars);
        writeData.newLine();
        //Closes the bufferedWriter
        writeData.close();

    }
}

