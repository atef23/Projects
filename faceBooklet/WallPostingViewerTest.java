
import student.*;
import java.util.*;
import java.text.*;

// -------------------------------------------------------------------------
/**.
 *  Tests methods of the WallPostingViewer class
 * 
 *  @author  atef
 *  @version 2010.11.09
 */
public class WallPostingViewerTest
    extends TestCase
{
    //~ Constructor ...........................................................
    private WallPostingViewer testWallPostingViewer;
    private FaceBooklet testFaceBooklet;

    // ----------------------------------------------------------
    /**.
     * Creates a new WallPostingViewerTest test object.
     */
    public WallPostingViewerTest()
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
        testWallPostingViewer = new WallPostingViewer(testFaceBooklet);
    }


    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    
    /**.
     * Tests the getWallFaceBooklet method
     */
    public void testGetWallFaceBooklet()
    {
        assertEquals(testWallPostingViewer.getWallFaceBooklet(), 
            testFaceBooklet);
    }
    
    /**.
     * Tests the setPostToView method
     */
    public void testSetPostToView()
    {
        testWallPostingViewer.setPostToView(new WallPosting("testAuthor",
            "testMessage"));
        assertEquals(testWallPostingViewer.getPostToView().getAuthor(),
            "testAuthor");
        assertEquals(testWallPostingViewer.getPostToView().getMessage(),
            "testMessage");        
    }
    
    /**.
     * Tests the getPostToView method
     */
    public void testGetPostToView()
    {
        testWallPostingViewer.setPostToView(new WallPosting("testAuthor",
            "testMessage"));
        assertEquals(testWallPostingViewer.getPostToView().getAuthor(),
            "testAuthor");
        assertEquals(testWallPostingViewer.getPostToView().getMessage(),
            "testMessage");        
    }
    
    /**.
     * Tests the formatPost method
     */
    public void testFormatPost()
    {
        testFaceBooklet.createUser("testUser", "testPassword");
        testFaceBooklet.login("testUser", "testPassword");
        UserProfile testProfile = testFaceBooklet.getCurrentUser();
        testProfile.setPictureThumbUrl("testUrl");
        WallPosting testPost = new WallPosting(testProfile.getName(),
            "testMessage");
        testWallPostingViewer.setPostToView(testPost);
        String formattedDateTest = 
            DateFormat.getDateInstance().format(testPost.getDate());
                
        assertEquals(testWallPostingViewer.formatPost(),
            "<p></p>" 
                +  "<img src=\"" 
                + testProfile.getPictureUrl() 
                + "\" height=\"50px\" width=\"50px\">" 
                + "<p></p>" + "<b>" 
                + testPost.getAuthor() + "</b>" + "<p></p>" + "<i>" 
                + testPost.getMessage() + "</i>" + "<p></p>" + "<i>" 
                + formattedDateTest + "</i><p></p>");
                
        testProfile.setPictureThumbUrl(null);
        WallPosting testPost2 = new WallPosting(testProfile.getName(),
            "testMessage");
        testWallPostingViewer.setPostToView(testPost2);
        String formattedDateTest2 = 
            DateFormat.getDateInstance().format(testPost2.getDate());
        
        assertEquals(testWallPostingViewer.formatPost(),
            "<p></p>" + testPost2.getAuthor() 
                + "</b>" + "<p></p>" + "<i>" 
                + testPost2.getMessage() + "</i>" + "<p></p>" + "<i>" 
                + formattedDateTest2 + "</i><p></p>");
                     
    }
    
    /**.
     * Tests the setFriendToShow method
     */
    public void testSetFriendToShow()
    {
        testWallPostingViewer.setFriendToShow("testName");
        assertEquals(testWallPostingViewer.getFriendToShow(), "testName");
    }
    
    /**.
     * Tests the getFriendToShow method
     */
    public void testGetFriendToShow()
    {
        testWallPostingViewer.setFriendToShow("testName");
        assertEquals(testWallPostingViewer.getFriendToShow(), "testName");
    }
    
    /**.
     * Tests the formatFriend method
     */
    public void testFormatFriend()
    {
        testFaceBooklet.createUser("testUser", "testPassword");
        testFaceBooklet.login("testUser", "testPassword");
        UserProfile testProfile = testFaceBooklet.getCurrentUser();
        testProfile.setPictureUrl("testUrl");
        testWallPostingViewer.setFriendToShow("testUser");
        assertEquals(testWallPostingViewer.formatFriend(), "<p></p>" 
                +  "<img src=\"" 
                + "testUrl" 
                + "\" height=\"50px\" width=\"50px\">" 
                + "<p></p>" + "testUser");              
    }
    
    /**.
     * Tests the formatFriend method
     * for null pictureURL
     */
    public void testFormatFriend2()
    {
        testFaceBooklet.createUser("testUser5", "testPassword");
        testWallPostingViewer.setFriendToShow("testUser5");
        assertEquals(testWallPostingViewer.formatFriend(), "<p></p>" 
            + "testUser5" + "<p></p>");
    }
        
}
