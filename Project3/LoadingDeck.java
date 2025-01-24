
/**
 * LoadinfDeck class stores a stuck, and implemenst various methods to load and unload from a truck. The class implements methods hasTruck(),
 * loadTruck(), unloadTruck(), getTruck(), removeTruck(), and setTruck().
 *
 * @author Padmanabh Kaushik
 * @version 5/3/2024
 */
public class LoadingDeck
{
    //instance variables
    Truck truck;
    WareHouse warehouse;

    /**
     * Constructor for objects of class LoadingDeck. This constructor sets a truck to null
     */
    public LoadingDeck()
    {
        truck = null;
    }

    /**
     * Second constructor for the Loading Deck
     * @param truck the truck to be docked in the loadind deck
     * @param house the warehouse where the loading deck is situated
     */
    public LoadingDeck(Truck truck, WareHouse house){
        this.truck = truck;
        warehouse = house;
    }

    /**
     * Determines if there is an empty space in the loading deck
     * @return true if the loading station has a truck, false if the loading station is empty
     */
    public boolean hasTruck(){
        if(truck == null){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Loads shipments into a truck as per the available spaces in the truck
     * @param truckLoad ArrayBasedStack containing truck array to load
     * @return bool true if the loading is successful; false if the loading is unsuccessful or the truck is filled
     */
    public boolean loadTruck(TruckStack truckLoad){
        if(truck.hasSpace()){
            Shipment temp = (Shipment) warehouse.getToDeliver().pop();
            truckLoad.add(temp);
            return true;
        }
        else if( !truck.hasSpace() && !(((Shipment)truck.getStorage().peek()).getDestination()[0] == warehouse.getLocation()[0] && ((Shipment)truck.getStorage().peek()).getDestination()[1] == warehouse.getLocation()[1]  )){
            //if there is nothing to load or unload, then remove the truck
            truck = null;
        }
        else{
            truck = null;
        }
        return false;
    }

    /**
     * Unloads shipments off a truck 
     * @param truckUnload ArrayBasedStack for a truck to be unloaded
     */
    public boolean unloadTruck(TruckStack truckUnload){
        if(truckUnload.getSize()>=1){    
            if((truckUnload.peek()).getCurrLoc()[0] == truck.currLoc[0] && ((Shipment)truckUnload.peek()).getCurrLoc()[1] == truck.currLoc[1]){
                Shipment temp = (Shipment) truckUnload.pop();
                warehouse.getDelivered().addExpandable(temp);
                return true;
            }
        }
        return false;  
    }

    /**
     * Returns the truck stored in the loading deck
     * @return truck truck stored in the warehouse
     */
    public Truck getTruck(){
        return truck;
    }
    
    /**
     * Removes a truck stored in the loading deck
     */
    public void removeTruck(){
        truck = null;
    }
    
    /**
     * Sets the truck in the warehouse for loading/unloading purposes
     * @param truck the truck to be docked in the loading deck
     */
    public void setTruck(Truck truck){
        this.truck = truck;
    }
}
