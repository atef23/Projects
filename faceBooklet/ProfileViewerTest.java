
import student.*;

// -------------------------------------------------------------------------
/**.
 *  Tests the various methods of the ProfileViewer class
 * 
 *  @author  atef
 *  @version 2010.10.28
 */
public class ProfileViewerTest
    extends TestCase
{

    private ProfileViewer testProfileViewer;
    private FaceBooklet testFaceBooklet;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**.
     * Creates a new ProfileViewerTest test object.
     */
    public ProfileViewerTest()
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
        testFaceBooklet = new FaceBooklet();
        testProfileViewer = new ProfileViewer(testFaceBooklet);
    }


    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    
    /**.
     * Tests the getCurrentViewerObj method
     */
    public void testGetCurrentViewerObj()
    {
        assertEquals(testProfileViewer.getCurrentViewerObj(), testFaceBooklet);
    }
    
    /**.
     * Tests the getProfileToView method
     */
    public void testGetProfileToView()
    {
        testFaceBooklet.createUser("testUser", "testPassword");
        testProfileViewer.setNameToView("testUser");
        UserProfile testProfile = testProfileViewer.getProfileToView();
        assertEquals(testProfile.getName(), 
            testFaceBooklet.getAProfile("testUser").getName());
            
        testFaceBooklet.createUser("testUser", "testPassword");
        testFaceBooklet.login("testUser", "testPassword");
        testProfileViewer.clear();
        assertEquals(testProfileViewer.getProfileToView(),
            testFaceBooklet.getCurrentUser());
    }
    
    /**.
     * Tests the setNameToView method
     */
    public void testSetNameToView()
    {
        testFaceBooklet.createUser("testUser", "testPassword");
        testProfileViewer.setNameToView("testUser");
        UserProfile testProfile = testProfileViewer.getProfileToView();
        assertEquals(testProfile.getName(), 
            testFaceBooklet.getAProfile("testUser").getName());
            
        testFaceBooklet.createUser("testUser", "testPassword");
        testFaceBooklet.login("testUser", "testPassword");
        testProfileViewer.setNameToView("fdsf");
        assertEquals(testProfileViewer.getProfileToView(),
            testFaceBooklet.getCurrentUser());
    }
    
    /**.
     * Tests the getNameToView method
     */
    public void testGetNameToView()
    {
        testFaceBooklet.createUser("testUser", "testPassword");
        testProfileViewer.setNameToView("testUser");
        assertEquals(testProfileViewer.getNameToView(), "testUser");
        
        testProfileViewer.clear();
        assertEquals(testProfileViewer.getNameToView(), null);
    }
    
    /**.
     * Tests the isViewingCurrentUser method
     */
    public void testIsViewingCurrentUser()
    {
        testFaceBooklet.createUser("testUser", "testPassword");
        testProfileViewer.setNameToView("testUser");
        assertEquals(testProfileViewer.isViewingCurrentUser(), false);
        
        testProfileViewer.clear();
        assertEquals(testProfileViewer.isViewingCurrentUser(), true);
    }
    
    /**.
     * Tests the isViewingDifferentUser method
     */
    public void testIsViewingDifferentUser()
    {
        testFaceBooklet.createUser("testUser", "testPassword");
        testProfileViewer.setNameToView("testUser");
        assertEquals(testProfileViewer.isViewingDifferentUser(), true);
        
        testProfileViewer.clear();
        assertEquals(testProfileViewer.isViewingDifferentUser(), false);
    }
    
    /**.
     * Tests the getFaceBooklet method
     */
    public void testGetFaceBooklet()
    {
        assertEquals(testProfileViewer.getFaceBooklet(), testFaceBooklet);
    }
    
    /**.
     * Tests the clear method
     */
    public void testClear()
    {
        testFaceBooklet.createUser("testUser", "testPassword");
        testProfileViewer.setNameToView("testUser");
        assertEquals(testProfileViewer.isViewingDifferentUser(), true);
        
        testProfileViewer.clear();
        assertEquals(testProfileViewer.isViewingDifferentUser(), false);
    }
    
    /**.
     * Tests the addViewedProfileAsFriend
     * method
     */
    public void testAddViewedProfileAsFriend()
    {
        testFaceBooklet.createUser("testUser", "testPassword");
        testFaceBooklet.login("testUser", "testPassword");
        testFaceBooklet.createUser("testUser2", "testPassword");
        testProfileViewer.setNameToView("testUser2");
        testProfileViewer.addViewedProfileAsFriend();
        assertTrue(testFaceBooklet.getCurrentUser().getFriends()
            .contains("testUser2"));
    }
        
        
        
        
        
        
        

}
