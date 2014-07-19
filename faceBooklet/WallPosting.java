
import student.*;
import java.util.*;

// -------------------------------------------------------------------------
/**.
 *  Contains methods for users to post on other users' walls
 * 
 *  @author  atef
 *  @version 2010.11.08
 */
public class WallPosting
{
    //~ Instance/static variables .............................................
    private String author;
    private String message;
    private Date date;
    private boolean postLove;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WallPosting object.
     * @param inAuthor the author
     * @param inMessage the message
     */
    public WallPosting(String inAuthor, String inMessage)
    {
        author = inAuthor;
        message = inMessage;
        
        Date currentDate = Calendar.getInstance().getTime();
        date = currentDate;
        postLove = false;
    }


    //~ Methods ...............................................................
    
    /**.
     * Accessor for author field
     * @return author the author of the post
     */
    public String getAuthor()
    {
        return author;
    }
    
    /**.
     * Accessor for message field
     * @return message the content of the post
     */
    public String getMessage()
    {
        return message;
    }
    
    /**.
     * Accessor for date field
     * @return date the time of the post
     */
    public Date getDate()
    {
        return date;
    }
    
    /**.
     * Accessor for postLove field
     * @return postLove the love
     */
    public boolean getPostLove()
    {
        return postLove;
    }
    
    /**.
     * Mutator for postLove field
     */
    public void setPostLove()
    {
        postLove = true;
    }

}
