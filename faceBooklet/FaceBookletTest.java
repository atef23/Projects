
import student.*;

// -------------------------------------------------------------------------
/**.
 *  Tests methods of the FaceBooklet class
 * 
 *  @author  atef
 *  @version 2010.10.01
 */
public class FaceBookletTest
    extends TestCase
{

    private FaceBooklet testFaceBooklet;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FaceBookletTest test object.
     */
    public FaceBookletTest()
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
        testFaceBooklet = new FaceBooklet();
    }


    // ----------------------------------------------------------
    /**.
     * Tests the getCurrentUser method 
     * 
     */
    public void testGetCurrentUser()
    {
        testFaceBooklet.createUser("newUser", "secret");
        testFaceBooklet.login("newUser", "secret");
        UserProfile testProfile = testFaceBooklet.getCurrentUser();
        assertEquals(testProfile.getName(), "newUser");
    }
    
    /**.
     * Tests the createUser method 
     * 
     */
    public void testCreateUser()
    {
        FaceBooklet testFB2 = new FaceBooklet();
        assertEquals(testFB2.createUser("newUser2", "superSecret"), false);
        
        assertEquals(testFB2.createUser("newUser2", "superSecret1"), false);
    }
    
    /**.
     * Tests the login method 
     * 
     */
    public void testLogin()
    {
        testFaceBooklet.createUser("newUser3", "superDuperSecret");
        assertEquals(testFaceBooklet.login("newUser3",
            "superDuperSecret"), true);
        
        assertEquals(testFaceBooklet.login("newUser323",
            "superDuperSecret"), false);
    }
    
    /**.
     * Tests the login feedback return 
     * method 
     */
    public void testGetLoginFeedback()
    {
        testFaceBooklet.createUser("newUser4", "superDuperSecret1");
        testFaceBooklet.login("newUser4", "superDuperSecret1");
        assertEquals("Login Successful", testFaceBooklet.getLoginFeedback());
    }
    
    /**.
     * Tests the hasNoCurrentUser 
     * method 
     */
    public void testHasNoCurrentUser()
    {
        testFaceBooklet.createUser("newUser5", "superDuperSecret5");
        testFaceBooklet.login("newUser5", "superDuperSecret5");
        assertEquals(false, testFaceBooklet.hasNoCurrentUser());
    }
    
    /**.
     * Tests the logout 
     * method 
     */
    public void testLogout()
    {
        testFaceBooklet.createUser("newUser3", "superDuperSecret");
        testFaceBooklet.login("newUser3", "superDuperSecret");
        testFaceBooklet.logout();
        assertEquals(true, testFaceBooklet.hasNoCurrentUser());
    }
    
    /**.
     * Tests the storeCurrentUserChanges 
     * method 
     */
    public void testStoreCurrentUserChanges()
    {
        testFaceBooklet.createUser("newUser3", "superDuperSecret");
        testFaceBooklet.login("newUser3", "superDuperSecret");
        testFaceBooklet.storeCurrentUserChanges();
        assertEquals(testFaceBooklet.getCurrentUser().getName(), "newUser3");
    }
    
    /**.
     * Tests the cancelCurrentUserChanges 
     * method 
     */
    public void testCancelCurrentUserChanges()
    {
        testFaceBooklet.createUser("newUser3", "superDuperSecret");
        testFaceBooklet.login("newUser3", "superDuperSecret");
        testFaceBooklet.getAProfile("newUser3").setName("newUser6");
        testFaceBooklet.cancelCurrentUserChanges();
        assertEquals(testFaceBooklet.getCurrentUser().getName(), "newUser6");
    }
    
    /**.
     * Tests the goToLoginIfNecessary 
     * method 
     */
    public void testGoToLoginIfNecessary()
    {
        testFaceBooklet.goToLoginIfNecessary();
        assertEquals("https://cloudspace.cs.vt.edu/"
                + "work/Fall2010/CS1114/atef/program5",
                testFaceBooklet.getCurrentPageName());
    }
    
    /**.
     * Tests the createACalendar
     * method 
     */
    public void testCreateCalendar()
    {
        testFaceBooklet.createCalendar("ctest");
        assertEquals(testFaceBooklet.getACalendar("ctest").getCalendarName(),
            "ctest");
    }
    
    /**.
     * Tests the getACalendar 
     * method 
     */
    public void testGetACalendar()
    {
        testFaceBooklet.createCalendar("ctest2");
        assertEquals(testFaceBooklet.getACalendar("ctest2").getCalendarName(),
            "ctest2");
    }
    
    
        
        
        
        

}
