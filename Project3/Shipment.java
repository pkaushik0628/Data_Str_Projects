
/**
 * The class describes a shipment. The shipment stores information like the load, wareHouse id of where it is generated, serial number, 
 * coordinates of the destination, current location, and source coordinates. The class implements methods setStatus(), toString(), getDestination(),
 * getCurrLoc(), setCurrLoc(), and getSize().
 *
 * @author Padmanabh Kaushik
 * @version 5/3/2024
 */
public class Shipment
{
    // instance variables
    private int size;
    private float[] destination;
    private String id;
    private float[] source;
    private String status;
    private float[] currLoc;

    /**
     * Constructor for objects of class Shipment
     * @param load size of the shipment
     * @param wareHouseID ID of the warehouse where the shipment is produced
     * @param shipmentNo serial no. of the shipment
     * @param destination array of size 2 with the x,y coordinates of the destination for the shipment
     * @param destination array of size 2 with the x,y coordinates of the source for the shipment
     * @param destination array of size 2 with the x,y coordinates of the current location for the shipment
     */
    public Shipment(int load, String warehouseID, int shipmentNo, float[] destination, float[] source, float[] currLoc)
    {
       this.size = load;
       id = warehouseID + "-" + shipmentNo;
       this.destination = destination;
       this.source = source;
       this.currLoc = currLoc;
       status = setStatus();
    }
    
    /**
     * This construcot is used for testing purposes only. 
     * @param id id of the shipment
     */
    public Shipment(String id){
        this.id = id;
    }
    
    /**
     * The method determines if the shipment has been delivered, it is on the way to its destination, or is awaiting pickup
     * @return status status of the shipment
     */
    private String setStatus(){
        if(currLoc[0] == source[0] && currLoc[1] == source[1]){
 
            return "Waiting Pickup";
        }
        else if (currLoc[0] == destination[0] && currLoc[1] == destination[1]){
            return "Delivered";
        }
        else{
            return "On The Way";
        }
    }
    
    
    /**
     * Prints the current log of the shipment
     * @return log current log of the shipment
     */
    @Override
    public String toString(){
        return id + ": Size:" + size + " : Destination: (" + destination[0] + "," + destination[1] + "), Status: " + status;
    }
    
    /**
     * Returns the current location of the shipment
     * @return current location of the array
     */
    public float[] getCurrLoc(){
        return currLoc;
    }
    
    /**
     * Used to set the current location of the shipment
     * @param loc the current location of the shipment
     */
    public void setCurrLoc(float[] loc){
        currLoc = loc;
    }
    
    /**
     * Returns the size of the shipment
     * @return size size of the shipment
     */
    public int getSize(){
        return size;
    }
    
    /**
     * Used to obtain the destination of the shipment
     * @return destination the final destination of the shipment
     */
    public float[] getDestination(){
        return destination;
    }
    
    /**
     * Returns the id of the shipment
     * @return id the id of the shipment
     */
    public String toShortString(){
        return id;
    }
    
    

    
}
