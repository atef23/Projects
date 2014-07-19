import java.util.*;
import student.*;

// -------------------------------------------------------------------------
/**.
 *  Tests methods of the CalendarViewer class
 * 
 *  @author  atef
 *  @version 2010.12.01
 */
public class CalendarViewerTest
    extends TestCase
{
    //~ Constructor ...........................................................
    private CalendarViewer testCV;
    private FaceBooklet testFB;

    // ----------------------------------------------------------
    /**
     * Creates a new CalendarViewerTest test object.
     */
    public CalendarViewerTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        testFB = new FaceBooklet();
        testCV = new CalendarViewer(testFB);
    }
    
    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    
    /**.
     * Tests the setCalendarToView 
     * method
     */
    public void testSetCalendarToView()
    {
        testCV.setCalendarToView(new EventCalendar("testC"));
        assertEquals(testCV.getCalendarToView().getCalendarName(),
            "testC");
    }
    
    /**.
     * Tests the getCalendarToView
     * method
     */
    public void testGetCalendarToView()
    {
        testCV.setCalendarToView(new EventCalendar("testC2"));
        assertEquals(testCV.getCalendarToView().getCalendarName(),
            "testC2");
    }
    
    /**.
     * Tests the getCalendarFaceBooklet method
     */
    public void testGetCalendarFaceBooklet()
    {
        assertEquals(testCV.getCalendarFaceBooklet(), 
            testFB);
    }       

}
