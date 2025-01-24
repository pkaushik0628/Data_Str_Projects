import java.util.Scanner;

/**
 * This class simulates the river ecosystem. It uses scanner to take in user inputs about the size of the river and the
 * number of cycles to be simulated. The class creates a river - an array of objects of Animal, and updates the river for the
 * numbwe of cycles specified by the user. 
 *
 * @author Padmanabh kaushik
 * @version 2/11/24
 */
public class RiverSimulator
{
    public static void main (String[] args){
        System.out.println("CS150 River Ecosystem");
        Scanner scanner = new Scanner(System.in);  

        while(true){
            System.out.println();
            System.out.println();
            System.out.println("CS150 River Ecosystem");
            System.out.println("Please choose: 1 (random river) 2 (exit)");
            //Scanner for reading 1 or 2
            int input1 = scanner.nextInt();
            System.out.println("River Ecosystem Simulator");
            System.out.println("Please choose: 1 (random river) 2 (exit)");
            //Prints an error message if the entered value is not 1 or 2
            if (input1 != 1 && input1 != 2){
                System.out.println("Invalid Selection. Please try again");
                continue;
            }
            //If entered value is equal to 1, a random river ecosystem is generated
            else if(input1 ==1){
                System.out.println("Creating a river.....");
                //Scanner for entering the length of the river
                System.out.println("Enter the length of the river (an integer bigger than 0)");
                int riverLength = 0;
                //Scanner for entering the number of cycles
                Scanner scanner2 = new Scanner(System.in);
                if(scanner2.hasNextInt()){
                    riverLength = scanner2.nextInt();
                }
                //Creates a random river ecosystem for a specified length
                River river  = new River(riverLength);
                System.out.println("Enter the number of cycles (an integer bigger than 0)");
                Scanner scanner3 = new Scanner(System.in);
                int cycles = 0;
                if(scanner3.hasNextInt()){
                    cycles = scanner3.nextInt();
                }
                
                //Mave the river ecosystem go through cycles

                for(int i = 0; i<cycles; i++){
                    System.out.println("River after cycle " + (i+1));
                    System.out.println(river.toString());
                    river.updateRiver();
                }
            }
            //If input is 2, the program should exit
            else if (input1 ==2){
                break;
            }
        }
    }
}
