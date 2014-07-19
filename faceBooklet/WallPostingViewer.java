import student.*;
import java.util.*;
import java.text.*;

// -------------------------------------------------------------------------
/**.
 *  Allows for the viewing of wall posts
 * 
 *  @author  atef
 *  @version 2010.11.08
 */
public class WallPostingViewer
{
    //~ Instance/static variables .............................................
    private WallPosting postToView;
    private FaceBooklet wallFaceBooklet;
    private String friendToShow;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**.
     * Creates a new WallPostingViewer object.
     * @param inFaceBooklet the facebooklet
     */
    public WallPostingViewer(FaceBooklet inFaceBooklet)
    {
        wallFaceBooklet = inFaceBooklet;
    }


    //~ Methods ...............................................................
    /**.
     * Accessor method for wallFaceBooklet
     * @return wallFaceBooklet the associated
     * FaceBooklet
     */
    public FaceBooklet getWallFaceBooklet()
    {
        return wallFaceBooklet;
    }
    
    /**.
     * Mutator method for postToView
     * @param inPosting the input wall post
     */
    public void setPostToView(WallPosting inPosting)
    {
        postToView = inPosting;
    }
    
    /**.
     * Accessor method for postToView
     * @return postToView the post
     */
    public WallPosting getPostToView()
    {
        return postToView;
    }
    
    /**.
     * Accessor method for formattedPost
     * @return formattedPost the post
     */
    public String formatPost()
    {
        String formattedPost = new String();
        UserProfile poster = 
            wallFaceBooklet.getAProfile(postToView.getAuthor());
        String formattedDate = 
            DateFormat.getDateInstance().format(postToView.getDate());
        
        if (poster.getPictureThumbUrl() != null)
        {
            formattedPost = "<p></p>" 
                +  "<img src=\"" 
                + poster.getPictureUrl() 
                + "\" height=\"50px\" width=\"50px\">" 
                + "<p></p>" + "<b>" 
                + postToView.getAuthor() + "</b>" + "<p></p>" + "<i>" 
                + postToView.getMessage() + "</i>" + "<p></p>" + "<i>" 
                + formattedDate + "</i><p></p>";
        }
        
        else 
        {
            formattedPost = "<p></p>" + postToView.getAuthor() 
                + "</b>" + "<p></p>" + "<i>" 
                + postToView.getMessage() + "</i>" + "<p></p>" + "<i>" 
                + formattedDate + "</i><p></p>";
        }
        
        return formattedPost;
            
    }
    
    /**.
     * Mutator method for friendToShow field
     * @param inFriendToShow the friend
     */
    public void setFriendToShow(String inFriendToShow)
    {
        friendToShow = inFriendToShow;
    }
    
    /**.
     * Accessor method for friendToShow field
     * @return this.friendToShow the friend
     */
    public String getFriendToShow()
    {
        return this.friendToShow;
    }
    
    /**.
     * Accessor method for HTML formatted friend 
     * information
     * @return formattedFriend the information
     */
    public String formatFriend()
    {
        String formattedFriend = new String();
        UserProfile friend = 
            wallFaceBooklet.getAProfile(friendToShow);
        
        if (!friend.getPictureUrl().equals(null))
        {
            formattedFriend = "<p></p>" 
                +  "<img src=\"" 
                + friend.getPictureUrl() 
                + "\" height=\"50px\" width=\"50px\">" 
                + "<p></p>" + friendToShow;
        }
        
        else 
        {
            formattedFriend = "<p></p>" + friendToShow + "<p></p>";
        }
        
        return formattedFriend;
            
    }
    

}
