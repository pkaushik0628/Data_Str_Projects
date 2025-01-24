
/**
 * Defines class VIPcustomerReview and its various methods - getCustomerName(), getLatestReview(),  toString(), equals(), and hashCode(). 
 * A VIPcustomerReview object can be created using two inputs - customer's name and the customer's latest input, both for which should 
 * be strings.
 *
 * @author Padmanabh Kaushik
 * @version 2/15/2024
 */
public class VIPCustomerReview
{
     // instance variables - replace the example below with your own
    private String customerName;
    private String latestReview;
    /**
     * Constructor for objects of class CustomerReview
     * 
     * @param customerName takes in the VIP customer's name
     * @param latestReview takes in the latest review for that VIP customer
     */
    public VIPCustomerReview(String customerName, String latestReview)
    {
        // initialise instance variables
        this.customerName = customerName;
        this.latestReview = latestReview;
    }

    /**
     * Returns the name of the customer
     * 
     * @return VIP customer name
     */
    public String getCustomerName()
    {
        return customerName;
    }

    /**
     * Returns the latest review given by a customer
     * 
     * @return latest review given by a VIP customer 
     */
    public String getLatestReview()
    {
        return latestReview;
    }

    /**
     * Converts a VIPCustomerReview object to string
     */
    @Override
    public String toString(){
        String a  = "Name: " + customerName + " Review: " + latestReview;
        return a;
    }

    /**
     * Checks if an object is a VIPCustomerReview object and if the names match. Returns true in that case, otherwise returns false
     * 
     * @param o an object of any method
     * @return true is the object type and customerNames match, else false.
     */
    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        VIPCustomerReview that = (VIPCustomerReview) o;
        return customerName.equals(that.customerName);
    }
    
    /**
     * Returns a hashcode based on the customerName. The method should return the same hash code for equal customerName.
     * 
     * @return hashcode for customerName
     */
    @Override
    public int hashCode(){
        return customerName.hashCode();
    }
}
