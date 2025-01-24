import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 
 * The Clock class serves as the coordinator of the trcuk simulation system, designed to model the operations of warehouses and trucks
 * over simulated time cycles. This class initializes the system by reading input data from the "input.txt" file, setting up warehouses
 * and trucks with their respective parameters. It then creates the simulation, executing actions for each truck, warehouse, and shipment
 * in synchronized time steps using a while loop.The status of each truck and warehouse is logged at each cycle into the "Output.txt" file. 
 *
 * @author Padmanabh Kaushik
 * @version 5/5/2025
 */
public class Clock implements Schedule
{
    //instance variables
    public static int time = 0;
    public static WareHouse[] warehouses;
    public static Truck[] trucks;
    public static FileWriter file;
    
    /**
     * Constructor for the clock class
     * @param warehouse array of all warehouses
     * @param trucks array of all trucks
     */
    public Clock(WareHouse[] warehouse, Truck[] trucks){
        this.warehouses = warehouse;
        this.trucks = trucks;
        time = 0;
    }
    
    
    /**
     * The main methods reads in all the data from input.txt, initialized the warehouses and trucks, and creates the simulation by calling
     * in the clock for certain number for clock cycle. The results of simulation at each clock cycle are stored in an output file called
     * output.txt
     * 
     * Note: The input.txt should be gerenrated before running this main method.
     * 
     * @param args standard command line input for main method
     */
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;
            int warehouseCount = 0;
            int truckCount = 0;
            file = new FileWriter("Output.txt");
            
            // First, count the number of warehouses and trucks in the file
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("W")) {
                    warehouseCount++;
                } else if (line.startsWith("T")) {
                    truckCount++;
                }
            }

            // Initialize arrays for warehouses and trucks
            warehouses = new WareHouse[warehouseCount];
            trucks = new Truck[truckCount];

            // Reset the reader to the beginning of the file
            reader.close();
            reader = new BufferedReader(new FileReader("input.txt"));

            int warehouseIndex = 0;
            int truckIndex = 0;

            // Read the file again to initialize warehouses and trucks
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (line.startsWith("W")) {
                    // Initialize warehouse
                    String id = parts[0];
                    float[] currLoc = {Float.parseFloat(parts[1]), Float.parseFloat(parts[2])};
                    int noDocks = Integer.parseInt(parts[3]);
                    int shipToDeliver = Integer.parseInt(parts[4]);
                    float[][] destinations = parseDestinations(parts[5]);
                    warehouses[warehouseIndex] = new WareHouse(id, currLoc, noDocks, shipToDeliver, destinations);
                    warehouseIndex++;
                } else if (line.startsWith("T")) {
                    // Initialize truck
                    String id = parts[0];
                    int load = Integer.parseInt(parts[1]);
                    float[] currLoc = {Float.parseFloat(parts[2]), Float.parseFloat(parts[3])};
                    trucks[truckIndex] = new Truck(load, currLoc, getWarehouseDestinations(warehouses), warehouses, id);
                    truckIndex++;
                }
            }

            // Close the reader
            reader.close();
            //Initiate the clock
            Clock clk = new Clock(warehouses, trucks);
            //Simulate the clock for 200 cycles
            clk.simulate(200);
            
        } catch (IOException e) {
            System.out.println("Error is here");
            e.printStackTrace();
        }
    }

    /**
     * Helper method used to parse destinationd for warehouses
     * @param destinationsString string expressiuon of a destination
     */
    private static float[][] parseDestinations(String destinationsString) {
        String[] destinationsArray = destinationsString.split("[()]");
        int count = destinationsArray.length / 2;
        float[][] destinations = new float[count][2];
        int index = 0;
        for (int i = 0; i < count; i++) {
            String[] coordinates = destinationsArray[index + 1].split(",");
            destinations[i][0] = Float.parseFloat(coordinates[0]);
            destinations[i][1] = Float.parseFloat(coordinates[1]);
            index += 2;
        }
        return destinations;
    }

    /**
     * Helper method to get destinations array for trucks
     * @param warehouses array of warehouses generated by the system
     */
    private static float[][] getWarehouseDestinations(WareHouse[] warehouses) {
        float[][] destinations = new float[warehouses.length][2];
        for (int i = 0; i < warehouses.length; i++) {
            destinations[i] = warehouses[i].getLocation();
        }
        return destinations;
    }
    
    
    /**
     * Logs the status of the system at each clock cycle (trucks, warehouses)
     * @return null (The log expression is stored in output.txt).
     */
    public String log_status(){
        //Store log expression for all warehouses
        for(int i = 0; i<warehouses.length; i++){
            try
            {
                file.write(warehouses[i].log_status());
                file.write("\n");
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
            
        }
        //Store log expression for all trucks
        for(int i = 0; i<trucks.length; i++){
            try
            {
                file.write(trucks[i].log_status());
                file.write("\n");
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
            
        }
        return null;
    }
    
    /**
     * Uodates the state of all trucks and warehouses at the start of each clock cycle
     */
    public void action(){
        //update all warehouses
        for(int i = 0; i<warehouses.length; i++){
            warehouses[i].action();
        }
        //update all trucks
        for(int i = 0; i<trucks.length; i++){
            trucks[i].action();
        }
    }
    
    /**
     * Increments the time counter of the clock
     */
    public static void incr(){
        time++;
    }
    
    /**
     * Simulates the system for a given number of cycles. Calls log_status() and action().
     * @param cycles no. of cycles for which the simulation is to be carried out
     */
    public void simulate(int cycles){
        int counter = 0;
        
        while(counter<cycles){
            action();
            log_status();
            incr();
            counter++;
        }
    }
    
}
