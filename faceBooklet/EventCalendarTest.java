import java.util.*;
import student.*;

// -------------------------------------------------------------------------
/**.
 *  Tests Methods of the eventCalendar class
 * 
 *  @author  atef
 *  @version 2010.11.20
 */
public class EventCalendarTest
    extends TestCase
{
    //~ Constructor ...........................................................
    private EventCalendar testCalendar; 

    // ----------------------------------------------------------
    /**.
     * Creates a new eventCalendarTest test object.
     */
    public EventCalendarTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**.
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        testCalendar = new EventCalendar("January Music Events");
    }


    // ----------------------------------------------------------
    
    /**.
     * tests the getCalendarName method
     */
    public void testGetCalendarName()
    {
        assertEquals(testCalendar.getCalendarName(), "January Music Events");
    }
    
    /**.
     * tests the getDaysEvents methods
     */
    public void testGetDaysEvents()
    {
        testCalendar.addEvent("testCreator", "testEvent",
            "testInfo", "01152011"); 
        // Tests the getDaysEvents(int inMonth, int inDay, int inYear) method 
        assertEquals(testCalendar.getDaysEvents(01, 15, 2011).get("testEvent")
        .getInfo(), "testInfo");        
        assertEquals(testCalendar.getDaysEvents(01, 16, 2011), null);

        // Tests the getDaysEvents(String inMonth, String inDay, String inYear) 
        // method 
        assertEquals(testCalendar.getDaysEvents("01", "15", "2011")
            .get("testEvent").getInfo(), "testInfo");
        assertEquals(testCalendar.getDaysEvents("01", "16", "2011"), null);
    }
    
    /**.
     * tests the addEvent methods
     */
    public void testAddEvent()
    {
        // Tests for cases of the addEvent(Event inEvent) method
        Event testEvent = new Event("the governator", "vote or die",
            "just vote..", "12302010");
        testCalendar.addEvent(testEvent);       
        assertEquals(testCalendar.getDaysEvents("12", "30", "2010")
            .get("vote or die").getInfo(), "just vote..");
        
        Event testEvent2 = new Event("the governator", "vote or die afterparty",
            "its gonna be good", "12302010");
        testCalendar.addEvent(testEvent2);       
        assertEquals(testCalendar.getDaysEvents("12", "30", "2010")
            .get("vote or die afterparty").getInfo(), "its gonna be good");
        
        // Test for cases of the addEvent(String inCreator, String 
        // inEventName, String inInfo, String dateScheduled) method
        testCalendar.addEvent("testCreator", "testEvent",
            "testInfo", "01182011"); 
        assertEquals(testCalendar.getDaysEvents(01, 18, 2011)
            .get("testEvent").getInfo(), "testInfo");
        
        testCalendar.addEvent("testCreator", "testEvent2",
            "testInfo2", "01182011"); 
        assertEquals(testCalendar.getDaysEvents(01, 18, 2011)
            .get("testEvent2").getInfo(), "testInfo2");
    }
    
    /**.
     * tests the formatDateToString method
     */
    public void testFormatDateToString()
    {
        assertEquals(testCalendar.formatDateToString(1, 1, 2010), "01012010");
        assertEquals(testCalendar.formatDateToString(12, 11, 2010), "12112010");
    }
    
    public void testGetDays()
    {
        Event testEvent = new Event("the governator", "vote or die",
            "just vote..", "12302010");
        testCalendar.addEvent(testEvent);
        assertTrue(!testCalendar.getDays().isEmpty());
    }
        
   
}
