import student.*;
import java.util.*;
import java.text.*;

// -------------------------------------------------------------------------
/**.
 *  Allows for the viewing of calendars
 * 
 *  @author  atef
 *  @version 2010.12.01
 */
public class CalendarViewer
{
    //~ Instance/static variables .............................................
    private EventCalendar calendarToView;
    private FaceBooklet calendarFaceBooklet;
    private String formattedCalendar;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**.
     * Creates a new CalenderViewer object.
     * @param inFaceBooklet the facebooklet
     */
    public CalendarViewer(FaceBooklet inFaceBooklet)
    {
        calendarFaceBooklet = inFaceBooklet;
    }


    //~ Methods ...............................................................
    
    /**.
     * Mutator method for calendarToView
     * @param inCal the input calendar
     */
    public void setCalendarToView(EventCalendar inCal)
    {
        calendarToView = inCal;
    }
    
    /**.
     * Accessor method for calendarToView field
     * @return calendarToView the post
     */
    public EventCalendar getCalendarToView()
    {
        return calendarToView;
    } 
    
    /**.
     * Accessor method for calendarFaceBooklet field
     * @return calendarFaceBooklet the FB
     */
    public FaceBooklet getCalendarFaceBooklet()
    {
        return calendarFaceBooklet;
    }
    
    public void formatCalendar()
    {

            for (String date : calendarToView.getDays() )
            {
                formattedCalendar += "<p></p><b>" + date.substring(0,2) + "/" + 
                date.substring(2,4) + "/" + date.substring(4,8) + "<p>";
            
                for (String eventName : calendarToView.getDaysEvents(date).keySet())
                {
                    formattedCalendar += eventName + "</b> - <i>" + calendarToView.getDaysEvents(date).get(eventName).getInfo() + "</i></p>";
                }
            }   
    }
    
    public String getFormattedCalendar()
    {
        return formattedCalendar;
    }
    
        

}