
import student.*;

// -------------------------------------------------------------------------
/**.
 *  Tests the various methods of the userProfile class
 * 
 *  @author  atef
 *  @version 2010.09.13
 */
public class UserProfileTest
    extends TestCase
{
    //~ Constructor ...........................................................
    private UserProfile myUserProfile;
    
    
    // ----------------------------------------------------------
    /**
     * Creates a new UserProfileTest test object.
     */
    public UserProfileTest()
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
        myUserProfile = new UserProfile();
    }


    // ----------------------------------------------------------
    
     /**.
     * Tests the getPassword method 
     * 
     */
    public void testGetPassword()
    {
        myUserProfile.setPassword("secret password");
        assertEquals("secret password", myUserProfile.getPassword());
    }
    
    /**.
     * Tests the getEmail method 
     * 
     */
    public void testGetEmail()
    {
        myUserProfile.setEmail("myEmail@superEmailClient.com");
        assertEquals("myEmail@superEmailClient.com", myUserProfile.getEmail());
    }
    
    /**.
     * Tests the getPictureThumbUrl method 
     * 
     */
    public void testGetPictureThumbUrl()
    {
        myUserProfile.setPictureThumbUrl("defaultThumbnailUrl");
        assertEquals("defaultThumbnailUrl", myUserProfile.getPictureThumbUrl());
    }
    
    /**.
     * Tests the getNickName method 
     * 
     */
    public void testGetNickName()
    {
        myUserProfile.setNickName("bo");
        assertEquals("bo", myUserProfile.getNickName());
    }
    
    /**.
     * Tests the getStatus method 
     * 
     */
    public void testGetStatus()
    {
        myUserProfile.setStatus("available");
        assertEquals("available", myUserProfile.getStatus());
    }
    
    /**.
     * Tests the getAge method 
     * 
     */
    public void testGetAge()
    {
        myUserProfile.setAge(22);
        assertEquals(22, myUserProfile.getAge());
    }
      
    /**.
     * Tests the setPassword method 
     * 
     */
    public void testSetPassword()
    {
        myUserProfile.setPassword("testsecretpw");
        assertEquals("testsecretpw", myUserProfile.getPassword());
    }
    
    /**.
     * Tests the setEmail method 
     * 
     */
    public void testSetEmail()
    {
        myUserProfile.setEmail("testEmail@client.com");
        assertEquals("testEmail@client.com", myUserProfile.getEmail());
    }
    
    /**.
     * Tests the setPictureThumbUrl method 
     * 
     */
    public void testSetPictureThumbUrl()
    {
        myUserProfile.setPictureThumbUrl("testUrl");
        assertEquals("testUrl", myUserProfile.getPictureThumbUrl());
    }
    
    /**.
     * Tests the setNickName method 
     * 
     */
    public void testSetNickName()
    {
        myUserProfile.setNickName("testNick");
        assertEquals("testNick", myUserProfile.getNickName());
    }
    
    /**.
     * Tests the setStatus method 
     * 
     */
    public void testSetStatus()
    {
        myUserProfile.setStatus("testStat");
        assertEquals("testStat", myUserProfile.getStatus());
    }
    
    /**.
     * Tests the setAge method 
     * 
     */
    public void testSetAge()
    {
        myUserProfile.setAge(23);
        assertEquals(23, myUserProfile.getAge());
    }
    
    /**.
     * Tests the postToWall method 
     * 
     */
    public void testPostToWall()
    {
        myUserProfile.postToWall("atef", "hello");
        assertEquals(myUserProfile.getWall().get(0).getAuthor(), "atef");
        assertEquals(myUserProfile.getWall().get(0).getMessage(), "hello");
        
        // Tests the case for wall size of 20
        myUserProfile.postToWall("atef", "hello1");
        myUserProfile.postToWall("atef", "hello2");
        myUserProfile.postToWall("atef", "hello3");
        myUserProfile.postToWall("atef", "hello4");
        myUserProfile.postToWall("atef", "hello5");
        myUserProfile.postToWall("atef", "hello6");
        myUserProfile.postToWall("atef", "hello7");
        myUserProfile.postToWall("atef", "hello8");
        myUserProfile.postToWall("atef", "hello9");
        myUserProfile.postToWall("atef", "hello10");
        myUserProfile.postToWall("atef", "hello11");
        myUserProfile.postToWall("atef", "hello12");
        myUserProfile.postToWall("atef", "hello13");
        myUserProfile.postToWall("atef", "hello14");
        myUserProfile.postToWall("atef", "hello15");
        myUserProfile.postToWall("atef", "hello16");
        myUserProfile.postToWall("atef", "hello17");
        myUserProfile.postToWall("atef", "hello18");
        myUserProfile.postToWall("atef", "hello19");
        myUserProfile.postToWall("atef", "hello20");
        
        assertEquals(myUserProfile.getWall().get(0).getMessage(),
            "hello20");
        assertEquals(myUserProfile.getWall().get(19).getMessage(),
            "hello1");        
    }
    
    /**.
     * Tests the getWall method 
     * 
     */
    public void testGetWall()
    {
        myUserProfile.postToWall("atef", "hello");
        assertEquals(myUserProfile.getWall().get(0).getAuthor(), "atef");
        assertEquals(myUserProfile.getWall().get(0).getMessage(), "hello");
    }
    
    /**.
     * Tests the loveAPost method 
     * 
     */
    public void testLoveAPost()
    {
        myUserProfile.postToWall("atef", "hello");
        myUserProfile.loveAPost(0);
        assertTrue(myUserProfile.getWall().get(0).getPostLove());
    }
    
    /**.
     * Tests the addPhoto method 
     * 
     */
    public void testAddPhoto()
    {
        String testSource = "testSrc";
        myUserProfile.addPhoto(testSource);
        assertEquals(testSource, myUserProfile.getPhotoAlbum().get(0));
    }
    
    /**.
     * Tests the getPhotoAlbum method 
     * 
     */
    public void testGetPhotoAlbum()
    {
        String testSource = "testSrc";
        String testSource2 = "testSrc2";        
        myUserProfile.addPhoto(testSource);
        myUserProfile.addPhoto(testSource2);
        
        assertEquals(testSource, myUserProfile.getPhotoAlbum().get(0));
        assertEquals(testSource2, myUserProfile.getPhotoAlbum().get(1));
    }
    
    /**.
     * Tests the deletePhoto method 
     * 
     */
    public void testDeletePhoto()
    {
        String testSource = "testSrc";
        String testSource2 = "testSrc2";        
        myUserProfile.addPhoto(testSource);
        myUserProfile.addPhoto(testSource2);
        
        myUserProfile.deletePhoto(0);
        assertEquals(
            testSource2, myUserProfile.getPhotoAlbum().get(0));        
    }
        
    
    
        
        

}
