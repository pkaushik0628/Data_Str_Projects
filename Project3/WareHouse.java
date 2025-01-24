import java.util.Random;

/**
 * The class describes the functioning of a warehouse. On being created, a warehouse initializes the a number of loading stations and shipments between
 * . Thereafter, as trucks ae added to the loading stations, the warehouse loads and unloads the trucks into the warehouses.
 *
 * @author Padmanabh Kaushik
 * @version 5/5/2024
 */
public class WareHouse implements Schedule
{
    private ArrayBasedStack<Shipment> toDeliver; //stack of shipments to deliver
    private ArrayBasedStack<Shipment> received; // shipments to receive
    private ArrayBasedStack<Truck> waitLine; // wait line
    private String id; // id of the warehouse
    private float[] currLoc; // current location of the warehouse
    private LoadingDeck[] loadStations; // loading decks array
    //Initialized just for testing purposes
    float[][] destinations = {new float[]{356, 78}, new float[]{234, 675}, new float[]{567, 879}};

    /**
     * Constructor for objects of class WareHouse
     * @param id id of the warehouse
     * @param currLoc current location if the warehouse floar[] (x, y)
     * @param noDocks no of loading docks in the warehouse
     * @param shipToDeliver no of shipments to deliver
     * @param destinations array of all warehouse locations
     */
    public WareHouse(String id,float[] currLoc, int noDocks, int shipToDeliver, float[][] destinations)
    {
        Random random = new Random();
        this.id = id;
        this.currLoc = currLoc;
        generateLoadingDecks(noDocks);
        this.destinations = destinations;
        generateShipments(shipToDeliver, random.nextInt(destinations.length));
        waitLine = new ArrayBasedStack(1);
        received = new ArrayBasedStack(1);
    }

    /**
     * This constructor is used for testing purposes only. This is a constructor for a warehouse.
     */
    public WareHouse(String id,float[] currLoc, int noDocks, int shipToDeliver, float[][] destinations, int no)
    {
        this.id = id;
        this.currLoc = currLoc;
        generateLoadingDecks(noDocks);
        this.destinations = destinations;
        generateShipments(shipToDeliver, no);
        waitLine = new ArrayBasedStack(1);
        received = new ArrayBasedStack(1);
    }

    
    /**
     * Logs the status of the warehouse
     * @return line status of the warehouse
     */
    public String log_status(){
        String line = "Warehouse: " + id + " Occupancy: " + toString();
        return line;
    }

    /**
     * Performs loading and unloading operations at all loading stations, one package at a clock cycle
     */
    public void action(){
        for(int i = 0; i<loadStations.length; i++){
            if(loadStations[i].hasTruck()){
                if(loadStations[i].getTruck().getStorage().getSize() != 0 && loadStations[i].getTruck().getStorage().peek() != null){
                    if( loadStations[i].getTruck().getStorage().peek().getDestination()[0] == currLoc[0] && loadStations[i].getTruck().getStorage().peek().getDestination()[1] == currLoc[1]){
                        loadStations[i].unloadTruck(loadStations[i].getTruck().getStorage());
                        loadStations[i].removeTruck();
                    }
                    else if (loadStations[i].getTruck().hasSpace()){
                        loadStations[i].loadTruck(loadStations[i].getTruck().getStorage());
                        loadStations[i].removeTruck();
                    }
                    else{
                        loadStations[i].removeTruck();
                    }
                }
                else if (loadStations[i].getTruck().getStorage().hasSpace()){
                    loadStations[i].loadTruck(loadStations[i].getTruck().getStorage());
                    //loadStations[i].removeTruck();
                }
                else{
                    loadStations[i].removeTruck();
                }
            }
            else if( waitLine.peek() != null){
                loadStations[i].setTruck((Truck)waitLine.pop());
            }
        }
    }

    /**
     * Generates i number of loading docks
     * @param num number of loading decks to be generated
     * this method should be called only once when the warehouse setup is being simulated at the beginning
     */
    private void generateLoadingDecks(int num){
        //generate nnum number of loading decks
        loadStations = new LoadingDeck[num];
        //fill in the array with new loading decks which are empty
        for(int i = 0; i<num; i++){
            loadStations[i] = new LoadingDeck();
        }
    }

    /**
     * Determines if the WareHouse can take in one additional truck
     * @return int the position of the empty loading deck. If all decks are occupied, -1 is returned
     */
    public int hasSpace(){
        for(int i = 0; i< loadStations.length; i++){
            if(!loadStations[i].hasTruck()){
                return i;
            }
        }
        return -1;
    }

    /**
     * Generates an array based stack of shipments at the beginning while the warehouse is being created
     * @param noShip number of shipments to be delivered to be generated
     */
    private void generateShipments(int noShip, int no){
        //int load, String warehouseID, int shipmentNo, float[] destination, float[] source, float[] currLoc
        //create the array containing the shipments to be delivered
        toDeliver = new ArrayBasedStack(noShip);
        //create random number generators
        Random random = new Random();
        Random random1 = new Random();

        for(int i = 0; i< noShip; i++){
            //generate a shipment
            Shipment shipment = new Shipment(1, id, i, destinations[no], currLoc, currLoc);
            //add it to the array based stack toDeliver
            toDeliver.add(shipment);
        }

    }

    /**
     * Adds a truck to the warehouse, either to the wait line or to the loading deck
     * @param truck truck to be added to the warehouse
     */
    public void addTruck(Truck truck){
        int test = hasSpace();
        if(test == -1){
            //add to the wait line
            waitLine.addExpandable(truck); 
        }
        else{
            //else add to the empty position of the load station
            if(waitLine.peek() == null){
                loadStations[test] = new LoadingDeck(truck, this);
            }
            else{
                loadStations[test] = new LoadingDeck((Truck)waitLine.pop(), this);
                waitLine.add(truck);
            }
        }

    }

    /**
     * Retutns the toDeliver array based stack
     * @return ArrayBasedStack toDeliver
     */
    public ArrayBasedStack<Shipment> getToDeliver(){
        return toDeliver;
    }

    /**
     * Returns the array of delivered items
     * @return received ArrayBasedStack of received items
     */
    public ArrayBasedStack<Shipment> getDelivered(){
        return received;
    }

    /**
     * Returns the current location
     * @return (x,y) float[2] array of coordinates
     */
    public float[] getLocation(){
        return currLoc;
    }

    /**
     * Returns the string action of the warehouse
     * @rturn line the string expression of the warehouse loading stations
     */
    public String toString(){
        StringBuilder line = new StringBuilder();

        for(int i = 0; i< loadStations.length; i++){
            if(loadStations[i].getTruck() != null){
                line.append(loadStations[i].getTruck().toString());
                line.append(" ");
            }
            else{
                line.append("-");
                line.append(" ");
            }
        }
        return line.toString();
    }

    /**
     * Returns the waitline of the warehouse
     * @return waitLine waitlist for the loading docks
     */
    public ArrayBasedStack<Truck> getWaitLine(){
        return waitLine;
    }

}
