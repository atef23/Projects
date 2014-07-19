
import student.*;
import student.web.*;
import java.util.*;

// -------------------------------------------------------------------------
/**.
 *  Tests preloaded aggregator
 * 
 *  @author  atef ajs09
 *  @version 2010.09.23
 */
public class PreloadedAggregatorTest
    extends TestCase
{
    //~ Constructor ...........................................................

    private RssAggregator testArray;
    private RssFeed rssFeeder;
    private RssFeed rssFeeder2;

    // ----------------------------------------------------------
    /**
     * Creates a new PreloadedAggregatorTest test object.
     */
    public PreloadedAggregatorTest()
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
        RssFeed("http://rss.cnn.com/rss/cnn_topstories.rss");
        rssFeeder2 = new 
        RssFeed("http://rss.news.yahoo.com/rss/topstories");
    }


    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void testGetKeyword()
    {
        testArray.setKeyword("hi");
        assertEquals(testArray.getKeyword(), "hi");
    }
    
        /**.
     * Tests the addFromFeed method
     * 
     */
    public void testAddFromFeed1()
    {
        testArray.addFromFeed(rssFeeder);
        assertEquals(testArray.getEntries().size(), 9);             
    }
    
     /**.
     * Tests the addFromFeed method 
     * from 2
     * 
     */
    public void testAddFromFeed2()
    {
        testArray.addFromFeed(rssFeeder2);
        assertEquals(testArray.getEntries().size(), 20);             
    }
        

}
