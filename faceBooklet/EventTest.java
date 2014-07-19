import java.util.*;
import student.*;

// -------------------------------------------------------------------------
/**.
 *  Tests methods of the event class
 * 
 *  @author  atef
 *  @version 2010.11.20
 */
public class EventTest
    extends TestCase
{
    //~ Constructor ...........................................................
    private Event testEvent;
    private Date testDate;

    // ----------------------------------------------------------
    /**.
     * Creates a new EventTest test object.
     */
    public EventTest()
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
        testEvent = new Event("testCreator", 
            "testName", "testInfo", "12201989");
        Date currentDate = Calendar.getInstance().getTime();
        testDate = currentDate;
    }
    
    // ----------------------------------------------------------
    
    /**.
     * Tests the getCreator method
     */
    public void testGetCreator()
    {
        assertEquals(testEvent.getCreator(), "testCreator");
    }
    
    /**.
     * Tests the getInfo method
     */
    public void testGetInfo()
    {
        assertEquals(testEvent.getInfo(), "testInfo");
    }
    
    /**.
     * Tests the getDateCreated method
     */
    public void testGetDateCreated()
    {
        assertEquals(testEvent.getDateCreated(), testDate);
    }
    
    /**.
     * Tests the getDateScheduled method
     */
    public void testGetDateScheduled()
    {
        assertEquals(testEvent.getDateScheduled(), "12201989");
    }
    
    /**.
     * Tests the getEventName method
     */
    public void testGetEventName()
    {
        assertEquals(testEvent.getEventName(), "testName");
    }
    
    
    

}
