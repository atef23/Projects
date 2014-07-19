import student.*;
import java.util.*;

// -------------------------------------------------------------------------
/**.
 *  Provides methods for adding entries and viewing events on a calendar
 *  There
 * 
 *  @author  atef
 *  @version 2010.11.17
 */
public class EventCalendar
{
    //~ Instance/static variables .............................................
    private Map < String, HashMap < String, Event > > scheduleOfEvents;
    private String calendarName;
    private Set < String > days;
    private Set < String > daysEventNames;
    private String currentDay;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**.
     * Creates a new eventCalendar object
     * @param inCalendarName the name of the this calendar
     */
    public EventCalendar(String inCalendarName)
    {
        scheduleOfEvents = 
            new HashMap < String, HashMap < String, Event > > ();       
        this.calendarName = inCalendarName;
    }

    //~ Methods ...............................................................
    
    /**.
     * Accessor for name of the calendar
     * @return calendarName the name
     */
    public String getCalendarName()
    {
        return calendarName;
    }
    
    /**.
     * Accessor for an event in the Calendar
     * @param inMonth the month of the event mm int
     * @param inDay the day of the event dd int
     * @param inYear the year of the event yyyy int
     * @return currentEvent the corresponding event
     */
    public HashMap < String, Event >
    getDaysEvents(int inMonth, int inDay, int inYear)
    {
        
        String inKey = formatDateToString(inMonth, inDay, inYear);
        
        if (scheduleOfEvents.containsKey(inKey))
        {
            return scheduleOfEvents.get(inKey);
        }
        
        else
        {
            return null;
        }
    }
    
        /**.
     * Accessor for an event in the Calendar
     * @param inMonth the month of the event mm String   
     * @param inDay the day of the event dd String
     * @param inYear the year of the event yyyy String
     * @return currentEvent the corresponding event
     */
    public HashMap < String, Event >
    getDaysEvents(String inMonth, String inDay, String inYear)
    {
        
        String inKey = inMonth + inDay + inYear;
        
        if (scheduleOfEvents.containsKey(inKey))
        {
            return scheduleOfEvents.get(inKey);
        }
        
        else
        {
            return null;
        }
    }
    
    /**.
     * Mutator for the scheduleOfEvents
     * @param inEvent the event to be added 
     * to the calendar
     */
    public void addEvent(Event inEvent)
    {
        String date = inEvent.getDateScheduled();
        
        if (!scheduleOfEvents.containsKey(date))
        {
            HashMap < String, Event > obj = new HashMap < String, Event > ();
            obj.put(inEvent.getEventName(), inEvent);
            scheduleOfEvents.put(date, obj);            
        }
        
        else
        {
            HashMap < String, Event > obj = scheduleOfEvents.get(date);
            obj.put(inEvent.getEventName(), inEvent);
            scheduleOfEvents.put(date, obj);
        }
    }
    
    /**.
     * Mutator for the scheduleOfEvents
     * @param inCreator the event's creator
     * @param inEventName the event's name
     * @param inInfo the event info
     * @param inDateScheduled the scheduled date for the event
     */
    public void addEvent(String inCreator, String inEventName, 
        String inInfo, String inDateScheduled)
    {
        Event eventToAdd = 
            new Event(inCreator, inEventName, inInfo, inDateScheduled);
        String date = eventToAdd.getDateScheduled();
        
        if (!scheduleOfEvents.containsKey(date))
        {
            HashMap < String, Event > obj = new HashMap < String, Event > ();
            obj.put(eventToAdd.getEventName(), eventToAdd);
            scheduleOfEvents.put(date, obj);
        }
        
        else
        {
            HashMap < String, Event > obj = scheduleOfEvents.get(date);
            obj.put(eventToAdd.getEventName(), eventToAdd);
            scheduleOfEvents.put(date, obj);
        }
    }
    
    /**.
     * Returns a formatted date String in the form of
     * mmddyyyy from given integer parameters 
     * @param inMonth the month of the date
     * @param inDay the day of the event
     * @param inYear the year of the event
     * @return formattedString the formatted date String
     */
    public String formatDateToString(int inMonth, int inDay, int inYear)
    {
        String monthString = new String();
        String dayString = new String();
        if (inMonth < 10)
        {
            monthString = "0" + Integer.toString(inMonth);
        }
        
        else
        {
            monthString = Integer.toString(inMonth);
        }
        
        if (inDay < 10)
        {
            dayString = "0" + Integer.toString(inDay);
        }
        
        else
        {
            dayString = Integer.toString(inDay);
        }
        
        String formattedString = monthString 
            + dayString + Integer.toString(inYear);
        return formattedString;
    }
    
    public Set < String > getDays()
    {
        days = scheduleOfEvents.keySet();
        return days;
    }
    
    
    public HashMap < String, Event >
    getDaysEvents(String indate)
    {
        
        String inKey = indate;
        
        if (scheduleOfEvents.containsKey(inKey))
        {
            return scheduleOfEvents.get(inKey);
        }
        
        else
        {
            return null;
        }
    }
    
    public Set < String > getDaysEventNames()
    {
        daysEventNames = getDaysEvents(currentDay).keySet();
        return daysEventNames;
    }
    
    public void setCurrentDay(String inDay)
    {
        currentDay = inDay;
    }
    
    
  
}
