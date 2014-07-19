import student.*;
import java.util.*;

// -------------------------------------------------------------------------
/**.
 *  This class contains information about events that are created by 
 *  users
 * 
 *  @author  atef
 *  @version 2010.11.17
 */
public class Event
{
    //~ Instance/static variables .............................................
    private String creator;
    private String info;
    private Date dateCreated;
    private String dateScheduled;
    private String eventName;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**.
     * Creates a new Event object.
     * @param inCreator the event's creator
     * @param inEventName the name of the event
     * @param inInfo the event info
     * @param inDateScheduled the date the event is
     * scheduled for mmddyyyy
     */
    public Event(String inCreator, String inEventName, 
        String inInfo, String inDateScheduled)
    {
        creator = inCreator;
        info = inInfo;
        dateScheduled = inDateScheduled;
        eventName = inEventName;
        
        Date currentDate = Calendar.getInstance().getTime();
        dateCreated = currentDate;
    }

    //~ Methods ...............................................................
    
    /**.
     * Accessor for creator of the event 
     * @return creator the user who created the event
     */
    public String getCreator()
    {
        return creator;
    }
    
    /**.
     * Accessor for the event information
     * @return info the information
     */
    public String getInfo()
    {
        return info;
    }
    
    /**.
     * Accessor the date created field
     * @return dateCreated the date that the
     * event was created
     */
    public Date getDateCreated()
    {
        return dateCreated;
    }
    
    /**.
     * Accessor scheduled date of the event
     * @return dateScheduled the scheduled date
     */
    public String getDateScheduled()
    {
        return dateScheduled;
    }
    
    /**.
     * Accessor for the event name
     * @return eventName the scheduled date
     */
    public String getEventName()
    {
        return eventName;
    }
}
