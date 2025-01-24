import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
/**
 * The class calls the main method to read in the stopwords using the method extractTokens(String filePath). extractTokens(String filePath) returns
 * an array list of stopWords, which is used as an input parameter for extractTokens(String filePath, ArrayList<String> stopWords). The 
 * extractTokens(String filePath, ArrayList<String> stopWords) reads in the txt file Pride_and_Prejudice and creates an array list of Word objcts
 * excluding the word mentioned in stopwords. The words are then put into a WordList, which is further used to extract the 5 most frequenct words
 * and print the output into the console. The words in the document are written into a txt file using a fileWriter and a buferedWriter.
 *
 * @author Padmanabh Kaushik
 * @version 2/20/2024
 */
public class Lab4
{
    public static void main(String[] args) throws IOException{
        FileWriter newFile = new FileWriter("Lab4.txt");
        //Create a BufferedWriter object to write data into the txt file
        BufferedWriter writeData = new BufferedWriter(newFile);
        
        //Create array list of stopwords
        ArrayList<String> stopWords = new ArrayList<>();
        stopWords = extractTokens("stopwords.txt");
        //Extract all words in the text
        ArrayList<String> wordsInText = new ArrayList<>();
        wordsInText = extractTokens("Pride_and_Prejudice.txt", stopWords);
        
        //Initialize a new word list
        WordList list1 = new WordList();
        
        //Add elements to the word list
        for(int i = 0; i< wordsInText.size(); i++){
            list1.addWord(wordsInText.get(i), stopWords);
        }
        
        for (int i = 0; i< list1.getWordFrequency().size(); i++){
            writeData.write(list1.getWordFrequency().get(i).toString());
            writeData.newLine();
        }
        
        System.out.println("Total words: " + list1.getWordFrequency().size());
        System.out.println("Top 5 most frequent words: ");
        Word[] top5 = list1.topKMostFrequent(5);
        
        for (int i = 0; i<top5.length; i++){
            System.out.println(top5[i].toString());
        }

    }

    /**
     * The method reads the file at filepath using a scanner, splits the text into an array of string based on [\\W]+ as a deliminator, 
     * converts all strings to lowercase, and if not present in the array list of stopWords, add these to an array list of Strings called tokens.
     * 
     * @param filePath contains the path of the file of the processed
     * @return tokens list of words in the specified file path
     */
    private static ArrayList<String> extractTokens(String filePath){
        ArrayList<String> tokens = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split("[\\W]+");
                for (int i = 0; i<words.length; i++) {
                    words[i] = words[i].toLowerCase();
                    tokens.add(words[i]);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tokens;
    }

    /**
     * The method reads the file at filepath using a scanner, splits the text into an array of string based on [\\W]+ as a deliminator, 
     * converts all strings to lowercase, and if not present in the array list of stopWords, add these to an array list of Strings called tokens.
     * 
     * @param filepath path of the txt file of be processed
     * @param stopWords array list of stopWords
     * @return tokens list of words in the specified file path, excluding the stopwords.
     */
    private static ArrayList<String> extractTokens(String filePath, ArrayList<String> stopWords){
        ArrayList<String> tokens = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split("[\\W]+");
                for (int i = 0; i<words.length; i++) {
                    words[i] = words[i].toLowerCase();
                    if(!stopWords.contains(words[i]) && !words[i].isEmpty()){
                        tokens.add(words[i]);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tokens;
    }
}

