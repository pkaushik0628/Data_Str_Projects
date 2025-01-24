import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * 
 * This class is responsible for generating input data. It generates input data for warehouses and trucks, which are essential components 
 * of the contructors needed for initialization. The randomly generated data includes information such as warehouse identifiers, current locations, 
 * number of docks, shipments to deliver, truck identifiers, load capacities, and current locations.
 * 
 * Limits: The class ensures that the generated locations fall within a specified range (0-100) to simulate a bounded environment.
 * The number of warehouses and trucks generated is also randomized within predefined limits (0-20 each) to provide variability in the input data.
 * 
 * After generating the input data, it writes the information to a text file named "input.txt" 
 * This txt file is to be used by the clock class of the project. The generated input file serves
 * as the basis for initializing warehouse and truck objects in the project simulation.
 * 
 * Notes:
 * 1. The user must run main method of this class to generate input data. Otherwise there wil be no data points to for the simulation.
 * 2. Check the "input.txt" file for the generated input data.
 *
 * @author Padmanabh Kaushik
 * @version 5/5/2024
 */
public class GenerateInput
{
    public static void main(String[] args) {
        Random random = new Random();
        Random random1 = new Random();
        int numTrucks = random1.nextInt(16) + 5; // Generate between 5 and 20 trucks
        int numWarehouses = random.nextInt(16) + 5; // Generate between 5 and 20 warehouses
        float[][] warehouseCoordinates = new float[numWarehouses][2];

        try {
            FileWriter writer = new FileWriter("input.txt");
            //Generatwe the warehouse inputs
            for (int i = 0; i < numWarehouses; i++) {
                String id = "W" + (i + 1);
                float[] currLoc = {random.nextInt(101), random.nextInt(101)};
                int noDocks = random.nextInt(3) + 1; // Generate between 1 and 3 docks
                int shipToDeliver = random.nextInt(16); // Generate between 0 and 15 shipments
                warehouseCoordinates[i] = currLoc;

                writer.write(id + " ");
                writer.write(currLoc[0] + " " + currLoc[1] + " ");
                writer.write(noDocks + " ");
                writer.write(shipToDeliver + " ");
                writer.write("(" + random.nextInt(101) + "," + random.nextInt(101) + ")");
                writer.write("\n");
            }
            
            //Generate the trucks
            for (int i = 0; i < numTrucks; i++) {
                String id = "T" + (i + 1);
                int load = random.nextInt(4) + 2; // Generate between 2 and 5 load
                float[] currLoc = {random.nextInt(101), random.nextInt(101)}; // Generate x, y coordinates
                writer.write(id + " ");
                writer.write(load + " ");
                writer.write(currLoc[0] + " " + currLoc[1] + "\n");
            }
            
            writer.close();
            //System.out.println("Input written to input.txt successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
    
    

    

}
