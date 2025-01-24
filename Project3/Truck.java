import java.util.Arrays;

/**
 * The class determines determines the functionality of a truck. A truck, ideally, takes in the location of all warehouses and determines where
 * to move next. It performs loading and unloading actiions through action(). There are helper methods, calculateDist() and findNextDest() to 
 * help th etruck identify its next destination.
 *
 * @author Padmanabh Kaushik
 * @version 5/3/2024
 */
public class Truck implements Schedule
{
    // instance variables
    private int x;
    public float[] currLoc;
    private TruckStack storage;
    private int capacity;
    private int speed;
    private int occupancy = 0;
    private float[] nextDest;
    private float[] nextDropOff = null;
    private float[][] destinations;
    private float distToDest;
    private String state = "moving";
    private WareHouse[] warehouses;
    private String id;

    // action counter
    private int j;
    private int cycles;

    /**
     * Constructor for objects of class Truck
     * @param load load of the strck
     * @param currLoc current location of the truck
     * @param destinations array of all destinations of warehouses
     * @param warehouses array of all created warehouses
     * @param id id of the truck
     */
    public Truck(int load, float[] currLoc, float[][] destinations, WareHouse[] warehouses, String id)
    {
        storage = new TruckStack(load);
        capacity = load;
        speed = 6 - load;
        this.currLoc = currLoc;
        nextDest = findNearestDestination(destinations, currLoc, new float[] {Float.MAX_VALUE, Float.MAX_VALUE});
        this.destinations = destinations;
        this.warehouses = warehouses;
        this.id = id;
    }

    /**
     * This contructor is used for testing purposes only.
     * @param load load of the truck
     * @param id id of the truck
     */
    public Truck(int load, String id){
        storage = new TruckStack(load);
        capacity = load;
        speed = 6-load;
        this.id = id;
    }

    /**
     * This is a constructor developed for tseting purposes only
     * @param load load of the truck
     * @param id id of the struck
     * @param filled no of filled slots in the TruckStack
     * @param dest the final destination of the shipments in the truck
     */
    public Truck(int load, String id, int filled, float[] dest){
        storage = new TruckStack(load);
        capacity = load;
        speed = 6-load;
        this.id = id;
        for(int i = 0; i<filled; i++){
            Shipment s1 = new Shipment(1, "W3", i, dest, new float[] {0, 0}, dest);
            storage.add(s1);
        }
    }

    /**
     * Constructor for the truck object. Used in implementation.
     * @param load the load of the truck
     * @param currLoc the current location of the truck
     * * @param destinations array of all destinations of warehouses
     * @param warehouses array of all created warehouses
     * @param id id of the truck
     * @param dest the next destination truck is heading to
     */
    public Truck(int load, float[] currLoc, float[][] destinations, WareHouse[] warehouses, String id, int filled, float[] dest)
    {
        storage = new TruckStack(load);
        capacity = load;
        speed = 6 - load;
        this.currLoc = currLoc;
        nextDest = findNearestDestination(destinations, currLoc, new float[] {Float.MAX_VALUE, Float.MAX_VALUE});
        this.destinations = destinations;
        this.warehouses = warehouses;
        this.id = id;
        for(int i = 0; i<filled; i++){
            Shipment s1 = new Shipment(1, "W3", i, dest, new float[] {3, 4}, dest);
            storage.add(s1);
        }
    }

    /**
     * Determines if the internal stack of the truck has space
     * @return bool true if the stack has space, else returns false
     */
    public boolean hasSpace(){
        //get the occupancy of the of the truck
        occupancy = getOccupancy();
        Shipment[] storage_copy = (Shipment[])storage.getArray();
        //check is any spot is empty, or if the truck is not filled upto its full load
        for(int i = 0; i< capacity; i++){
            if(storage_copy[i] == null){
                return true;
            }
        }
        return false;
    }

    /**
     * Determines the current occupany of a truck
     * @return occupancy the current occupancy of a truck
     */
    private int getOccupancy(){
        Shipment[] storage_copy = (Shipment[])storage.getArray();
        for(int i = 0; i< capacity; i++){
            if(storage_copy[i] != null){
                occupancy = occupancy + storage_copy[i].getSize(); 
            }
        }
        return occupancy;
    }

    /**
     * Returns the internal stack of the truck
     * @return storage the internal stack of the truck
     */
    public TruckStack getStorage(){
        return storage;
    }

    /**
     * Notes the per-cycle status of the truck
     * @return line the log status of the truck
     */
    public String log_status(){
        String line = "Truck ID: " + id + " Status: " + state + " TruckStack: " + this.toArrayString();
        return line;
    }

    /**
     * Initiates the loading, unloading, and motion of the truck. Determines the next destination after a loading/unloading operation has been 
     * done.
     */
    public void action(){
        //when a new destination is set for the first time
        if(j == 0){
            if(((Shipment)storage.peek()) != null){
                nextDropOff = ((Shipment)storage.peek()).getDestination();
            }
            else if(storage.getSize() == 0){
                nextDropOff = new float[] {Float.MAX_VALUE, Float.MAX_VALUE};
            }
            nextDest = findNearestDestination(destinations, currLoc, nextDropOff);
            cycles = noCyclesToDest();
            state = "Moving To New Destination: " + "("  + nextDest[0] + "," + nextDest[1] + ") |||||||" + cycles + "Miles To Destination Left";
            j++;
        }
        else if( j < cycles){
            //while destination is not reached
            distToDest = calculateDistance(currLoc, nextDest) - j*speed;
            //update state
            state = "Moving To New Destination: " + "("  + nextDest[0] + "," + nextDest[1] + ") |||||||" + distToDest + "Miles To Destination Left";
            //increment j
            j++;
        }
        else if(j >= cycles){ // truck is at a pickup or dropOff location
            if(this.hasSpace() || (((Shipment)storage.peek()).getDestination()[0] == nextDest[0] && ((Shipment)storage.peek()).getDestination()[1] == nextDest[1] )){
                state = "Loading/Unloading at: " + "("  + nextDest[0] + "," + nextDest[1] + ") |||||||" + 0 + "Miles To Destination Left";
                if(j == cycles){
                    warehouses[findWHIndex()].addTruck(this);
                }
                currLoc = nextDest;
                updateCurrentLocLoad();
                System.out.println(j);
                //j++;

            }
            j++;
            //As a design choice, a truck cannot stay at the deck for more than 5 hours
            if( j >= cycles + 5){
                //if there is nothing to drop off or pick up, then move to another destination
                System.out.println("I'm here");
                currLoc = nextDest;
                updateCurrentLocLoad();
                if((Shipment)storage.peek() != null){
                    nextDropOff = ((Shipment)storage.peek()).getDestination();
                }else{
                    nextDropOff = new float[] {Float.MAX_VALUE, Float.MAX_VALUE};
                }
                nextDest = findNearestDestination(destinations, currLoc, nextDropOff);
                j = 0;
            }
        }
    }

    /**
     * Identifies the nearest location to go to
     * @param destinations coordinates of the destinations to go to
     * @param currLoc current location coordinates
     * @param otherDest coordinate of the next dropOff location
     */
    public float[] findNearestDestination(float[][] destinations, float[] currLoc, float[] otherDest) {
        float minDistance = Float.MAX_VALUE;
        float[] nearestDestination = null;

        // Iterate over all destinations and other destination
        //Nearest destination to pick-up
        for (float[] destination : destinations) {
            // Skip currLoc
            if (Arrays.equals(destination, currLoc)) {
                continue;
            }

            float distance = calculateDistance(currLoc, destination);
            if (distance < minDistance) {
                minDistance = distance;
                nearestDestination = destination;
            }
        }

        //nearest distance to dropOff
        float distanceToOtherDest = calculateDistance(currLoc, otherDest);

        if(occupancy == capacity){
            //then the truck must frop -off
            return nearestDestination;
        }
        else{

            //Check if the drofOff location is closer than the pickup, then drop off location is chosen
            //If there is no dropOff location
            if(otherDest == null){
                return null;
            }
            else if (distanceToOtherDest < minDistance) {
                nearestDestination = otherDest;
            }
            return nearestDestination;
        }
    }

    /**
     * Calculates the number of cycles needed to reach the destination
     * @return cycles no. of action() cycles needed to reach destination
     */
    public int noCyclesToDest(){
        float distance = calculateDistance(currLoc, nextDest);
        if(distance%speed != 0){
            return (int)(distance/speed) + 1;
        }
        else{
            return (int)(distance/speed);
        }
    }

    /**
     * Calculates the distance between two points
     * @param point1 array containing x, y coordinates of the first point
     * @param point2 array containing x, y coordinates of the second point
     * @return distance distance between two points
     */
    public float calculateDistance(float[] point1, float[] point2) {
        // Extract coordinates from the arrays
        float x1 = point1[0];
        float y1 = point1[1];
        float x2 = point2[0];
        float y2 = point2[1];

        // Calculate the difference in coordinates
        float deltaX = x2 - x1;
        float deltaY = y2 - y1;

        // Calculate the square of the differences
        float deltaXSquare = deltaX * deltaX;
        float deltaYSquare = deltaY * deltaY;

        // Calculate the sum of the squares
        float sumOfSquares = deltaXSquare + deltaYSquare;

        // Calculate the square root of the sum
        float distance = (float) Math.sqrt(sumOfSquares);

        return distance;
    }

    /**
     * If the truck determines that its next destination warehouse, the method identifies the index of the warehouse from the array of warehouses
     */
    public int findWHIndex(){
        for(int i = 0; i< warehouses.length; i++){
            if(nextDest[0] == warehouses[i].getLocation()[0] && nextDest[1] == warehouses[i].getLocation()[1]){
                return i;
            }
        }
        return 0;
    }

    /**
     * Returns the ID of each truck
     */
    @Override
    public String toString(){
        return id;
    }

    /**
     * Returns the string expression of the internal stack of the truck
     * @return line the string expression for the internal stack of the truck
     */
    public String toArrayString(){
        StringBuilder line = new StringBuilder();
        Shipment[] storage_copy = (Shipment[])storage.getArray();
        for(int i = 0; i< capacity; i++){
            if(storage_copy[i] != null){
                line.append(storage_copy[i].toShortString());
                line.append(" ");
            }
            else{
                line.append("- ");
            }
        }
        return line.toString();

    }

    /**
     * Updates the current location of the truck. Works depending on the locction of the warehouse where the truck is located
     */
    private void updateCurrentLocLoad(){
        for(int i  = 0; i< storage.getSize(); i++){
            if(storage.getArray()[i] != null){
                storage.getArray()[i].setCurrLoc(currLoc);
            }
        }
    }

    /**
     * Returns the next destination for the trucl
     * @return nextDest the next destination for the truck
     */
    public float[] getNextDest(){
        return nextDest;
    }
}
