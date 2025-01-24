import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The class Lab 5 defines a main method to read in words from a txt files, and creates an array list of Word Objects. 
 * It defines three methods to perform sorting on the array list: selection sort, insertion sort, and bubble sort.
 *
 * @author Padmanabh Kaushik
 * @version 3/5/2024
 */
public class Lab5
{

    /**
     * The method bubble sorts a genetic <T> list, by using a comparator
     *
     * @param  list  a generic list to be sorted
     * @param comp a comparator to be used for sorting
     * @return  iterations total number of swaps performed during bubble sort
     */

    public static <T> int bubbleSort( List <T> list, Comparator <? super T> comp){
        //get the list length
        int n = list.size();
        //set iterations to 0
        int iteration = 0;

        for (int out = list.size()-1; out >=1; out --){
            for (int in = 0; in < out; in++){
                if(comp.compare(list.get(in), list.get(in + 1)) < 0){
                    //Make a swap
                    T temp = list.get(in);
                    list.set(in, list.get(in+1));
                    list.set(in+1, temp);
                    //Record the number of iterations for the inner loop, indicating the numbers of swaps made
                    iteration ++;
                }
            }
        }
        //Return the total number of swaps
        return iteration;

    }

    /**
     * The method selection sorts a genetic <T> list, by using a comparator
     * @param  list  a generic list to be sorted
     * @param comp a comparator to be used for sorting
     * @return  iterations total number of swaps performed during selection sort
     */
    public static <T> int selectionSort( List <T> list, Comparator <? super T> comp){
        //get list size
        int n = list.size();
        //initialize the number of itirations
        int iterations = 0;

        for (int i  = 0; i<n; i++){
            //Initialize that position i is the maxIndex with i starting from 0
            int maxIndex = i;
            for(int j = i+1; j<n; j++){
                //If any other number in the array is found greater than maxIndex, then set that index to maxIndex
                if( comp.compare(list.get(j), list.get(maxIndex)) > 0){
                    maxIndex = j;
                }
            }
            //Make a swap between maxIndex and i
            T temp = list.get(i);
            list.set(i, list.get(maxIndex));
            list.set(maxIndex, temp);
            iterations++;
        }
        return iterations;  
    }

    /**
     * The method does insertionSort on a genetic <T> list, by using a comparator
     * @param  list  a generic list to be sorted
     * @param comp a comparator to be used for sorting
     */
    public static <T> int insertionSort( List <T> list, Comparator <? super T> comp){
        //Get the the size of the list
        int n = list.size();
        //Set the number of iterations to zero
        int iteration = 0;

        for (int out = 1; out<n; out++){
            T temp = list.get(out);
            int in = out;

            while( in>0 && comp.compare(list.get(in-1), temp) <= 0 ){
                list.set(in, list.get(in-1));
                in--;
            }
            list.set(in, temp);
            iteration ++;
        }

        return iteration;

    }
    
    /**
     * The main method reads the worlds from a txt file using extractTokens method, and initialized 4 new word lists. The main does implements
     * sorting in  ways: without using sorting method (based on lab4), using bubble sort, using selection sort, and using insertion sort. The
     * sorting results for k = 15 are printed into the console for comparison.
     * 
     * @param args default agrs parameter for main
     */
    public static void main(String[] args){
        //Set k to 15
        int k = 15;
        
        //Create array list of stopwords
        ArrayList<String> stopWords = new ArrayList<>();
        stopWords = extractTokens("stopwords.txt");
        //Extract all words in the text
        ArrayList<String> wordsInText = new ArrayList<>();
        wordsInText = extractTokens("Pride_and_Prejudice.txt", stopWords);
        
        //Initialize 4 new word lists
        WordList list1 = new WordList();
        WordList list2 = new WordList();
        WordList list3 = new WordList();
        WordList list4 = new WordList();
        
        //Add elements to each word list
        for(int i = 0; i< wordsInText.size(); i++){
            list1.addWord(wordsInText.get(i), stopWords);
            list2.addWord(wordsInText.get(i), stopWords);
            list3.addWord(wordsInText.get(i), stopWords);
            list4.addWord(wordsInText.get(i), stopWords);
        }
        
        
        //System.out.println("Without using sorting methods");
        //System.out.println("Total words: " + list1.getWordFrequency().size());
        //System.out.println("Top 15 most frequent words: ");
        Word[] top15 = list1.topKMostFrequent(15);
        
        System.out.println("Without using sorting methods");
        for (int i = 0; i<top15.length; i++){
            System.out.println(top15[i].toString());
        }
        
        
        System.out.println();
        System.out.println();
        System.out.println("Using Freq Comparator and Bubble Sort");
        //Initialize a comparator
        FreqComparator comp1 = new FreqComparator();
        ArrayList<Word> freqList = new ArrayList<>();
        //extract the array list from the wordList
        freqList = list2.getWordFrequency();
        //perform bubble sort
        int n1 = bubbleSort(freqList, comp1);
        
        for (int i = 0; i<k; i++){
            System.out.println(freqList.get(i).toString());
        }
        //Add space
        System.out.println();
        System.out.println();
        System.out.println("Using Length Comparator and Selection Sort");
        //Initialize a comparator
        LengthComparator comp2 = new LengthComparator();
        ArrayList<Word> lengthList = new ArrayList<>();
        //extract the array list from the wordList
        lengthList = list3.getWordFrequency();
        //perform selection sort
        int n2 = selectionSort(lengthList, comp2);
        
        for (int i = 0; i<k; i++){
            System.out.println(lengthList.get(i).toString());
        }
        //Add space
        System.out.println();
        System.out.println();
        System.out.println("Using Word Comparator and Insertion Sort");
        //Initialize a comparator
        WordComparator comp3 = new WordComparator();
        ArrayList<Word> wordList = new ArrayList<>();
        //extract the array list from the wordList
        wordList = list4.getWordFrequency();
        //perform insertion sort
        int n3 = insertionSort(wordList, comp3);
        
        for (int i = 0; i<k; i++){
            System.out.println(wordList.get(i).toString());
        }
        
        //Add space
        System.out.println();
        System.out.println();
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
