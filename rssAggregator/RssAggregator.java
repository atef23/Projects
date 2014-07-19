
import student.*;
import student.web.*;
import java.util.*;

// -------------------------------------------------------------------------
/**.
 *  The class for the ArrayList of Rss Feeds
 * 
 *  @author  atef ajs09
 *  @version 2010.09.23
 */
public class RssAggregator
{
    //~ Instance/static variables .............................................
    private ArrayList < RssEntry > entries;
    private String keyword;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new RssAggregator object.
     */
    public RssAggregator()
    {
        entries = new ArrayList < RssEntry > ();
        keyword = "";
    }


    //~ Methods ...............................................................
    /**.
     * Accessor method for the array
     * @return entries entries of the array
     */
    public ArrayList < RssEntry > getEntries()
    {
        return entries;
    }
 
    /**.
     * The method to add entries from the feed to the array.
     * @param feed The feed that goes to the method
     */ 
    public void addFromFeed(RssFeed feed)
    {
        for (RssEntry newEntry : feed.getEntries())
        {
            if (newEntry.getTitle().contains(keyword))
            {
                entries.add(newEntry);    
            }
        }
        
    }

    /**.
     * Accessor method for the keyword
     * @return keyword the keyword
     */
    public String getKeyword()
    {
        return keyword;        
    }
 
    /**.
     * The mutator method for the keyword field
     * @param newKeyword the input keyword
     */ 
    public void setKeyword(String newKeyword)
    {
        keyword = newKeyword;
    }
    
    
    
    
    
    
        
}
