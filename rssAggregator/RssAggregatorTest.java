
import student.*;
import student.web.*;
import java.util.*;

// -------------------------------------------------------------------------
/**.
 *  Tests RssAggregator accessor method
 * 
 *  @author  atef ajs09
 *  @version 2010.09.23
 */
public class RssAggregatorTest
    extends TestCase
{
    //~ Constructor ...........................................................
    private RssAggregator testArray;
    private RssFeed rssFeeder;

    // ----------------------------------------------------------
    /**
     * Creates a new RssAggregatorTest test object.
     */
    public RssAggregatorTest()
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
        testArray = new RssAggregator();
        rssFeeder = new 
        RssFeed("http://courses.cs.vt.edu/~cs1114/practice/slashdot.rss");
        
    }


    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    
     /**.
     * Tests the size of the array
     * 
     */
    public void testSize()
    {
        assertEquals(testArray.getEntries().size(), 0);
    }

    /**.
     * Tests the addFromFeed method
     * 
     */
    public void testAddFromFeed()
    {
        testArray.addFromFeed(rssFeeder);
        assertEquals(testArray.getEntries().size(), 15);             
    }
 
    /**.
     * Tests the addFromFeed method
     * with a keyword "government"
     * 
     */
    public void testKeyWordAddFromFeed1()
    {
        testArray.setKeyword("government");
        testArray.addFromFeed(rssFeeder);
        assertEquals(testArray.getEntries().size(), 0);
          
    }
    
    /**.
     * Tests the addFromFeed method
     * with a keyword "Germany"
     * 
     */
    public void testKeyWordAddFromFeed2()
    {
        testArray.setKeyword("Germany");
        testArray.addFromFeed(rssFeeder);
        assertEquals(testArray.getEntries().size(), 1);
          
    }   
   
    /**.
     * Tests the getKeyword method
     * with a keyword "hello"
     * 
     */
    public void testGetKeyword()
    {
        testArray.setKeyword("hello");
        assertEquals(testArray.getKeyword(), "hello");
    }
    
    

}
