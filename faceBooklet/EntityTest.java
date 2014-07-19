
import student.*;
import student.web.*;
import java.util.*;

// -------------------------------------------------------------------------
/**.
 *  Tests methods from the entity class
 *  tests setter and accessor methods for the name and pictureUrl fields
 *  of the entity superclass
 * 
 *  @author  atef
 *  @version 2010.09.13
 */
public class EntityTest
    extends TestCase
{
    //~ Constructor ...........................................................
    private Entity myEntity;

    // ----------------------------------------------------------
    /**
     * Creates a new EntityTest test object.
     */
    public EntityTest()
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
        myEntity = new Entity();
    }


    // ----------------------------------------------------------

    /**.
     * Tests the getName method 
     * 
     */
    public void testGetName()
    {
        myEntity.setName("test name");
        assertEquals("test name", myEntity.getName());
    }
    
    /**.
     * Tests the setName method  
     * 
     */
    public void testSetName()
    {
        myEntity.setName("test name");
        assertEquals("test name", myEntity.getName());
    }
    
    /**.
     * Tests the getPictureUrl method 
     * 
     */
    public void testGetPictureUrl()
    {
        myEntity.setPictureUrl("test Url");
        assertEquals("test Url", myEntity.getPictureUrl());
    }
    
    /**.
     * Tests the setPictureUrl method
     * 
     */
    public void testSetPictureUrl()
    {
        myEntity.setPictureUrl("test Url");
        assertEquals("test Url", myEntity.getPictureUrl());
    }
    
    /**.
     * Tests the getFriends method
     * 
     */
    public void testGetFriends()
    {
        myEntity.addFriend("testFriend");
        assertTrue(myEntity.getFriends().contains("testFriend"));
    }
    
    /**.
     * Tests the addFriends method
     * 
     */
    public void testAddFriend()
    {
        myEntity.addFriend("testFriend");
        assertTrue(myEntity.getFriends().contains("testFriend"));
        
        myEntity.addFriend("testFriend");
        assertTrue(myEntity.getFriends().contains("testFriend"));
    }
        

}
