
import student.*;
import java.util.*;

// -------------------------------------------------------------------------
/**.
 *  Tests methods of the WallPosting class
 * 
 *  @author  atef
 *  @version 2010.11.09
 */
public class WallPostingTest
    extends TestCase
{
    //~ Constructor ...........................................................
    private WallPosting testWallPosting;
    private Date testDate;

    // ----------------------------------------------------------
    /**.
     * Creates a new WallPostingTest test object.
     */
    public WallPostingTest()
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
        testWallPosting = new WallPosting("testAuthor", "testMessage");
        testDate = Calendar.getInstance().getTime();
    }


    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    
    /**.
     * Tests the getAuthor method
     */
    public void testGetAuthor()
    {
        assertEquals(testWallPosting.getAuthor(), "testAuthor");
    }
    
    /**.
     * Tests the getMessage method
     */
    public void testGetMessage()
    {
        assertEquals(testWallPosting.getMessage(), "testMessage");
    }
    
    /**.
     * Tests the getDate method
     */
    public void testGetDate()
    {
        assertEquals(testWallPosting.getDate(), testDate);
    }
    
    /**.
     * Tests the getPostLove method
     */
    public void testGetPostLove()
    {
        assertFalse(testWallPosting.getPostLove());
    }
    
    /**.
     * Tests the setPostLove method
     */
    public void testSetPostLove()
    {
        testWallPosting.setPostLove();
        assertTrue(testWallPosting.getPostLove());
    }
        

}
