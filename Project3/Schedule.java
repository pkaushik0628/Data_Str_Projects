
/**
 * The interface is used to ensure that the trucks and the locations for pickup/drop-off implement the correct methods, in sync with the clock.
 *
 * @author Padmanabh Kaushik
 * @version 05/01/2024
 */
public interface Schedule
{
    /**
     * Called each hour, allowing the object to perform an action. 
     */
    public void action();
    
    /**
     * Will store the object’s current information into a log file.
     * @return time no of times a log has been registered
     */
    public String log_status();
}
