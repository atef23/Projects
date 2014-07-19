
import student.*;

// -------------------------------------------------------------------------
/**.
 *  Provides methods that allow for viewing profiles and 
 *  adding friends
 * 
 *  @author  atef
 *  @version 2010.10.27
 */
public class ProfileViewer
    extends FaceBooklet
{
    //~ Instance/static variables .............................................
    private FaceBooklet viewerFB;
    private UserProfile profileToView;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ProfileViewer object.
     * @param inputFB the tag for the fb
     */
    public ProfileViewer(FaceBooklet inputFB)
    {
        viewerFB = inputFB;
    }


    //~ Methods ...............................................................
    
    /**.
     * Method for retrieving current facebooklet
     * object
     * @return viewerFB the object
     */
    public FaceBooklet getCurrentViewerObj()
    {
        return viewerFB;
    }
    
    /**.
     * Accessor for profileToView
     * @return profileToView
     */
    public UserProfile getProfileToView()
    {
        if (profileToView == null)
        {
            return viewerFB.getCurrentUser();
        }
        
        else
        {
            return profileToView;
        }
    }
    
    /**.
     * Mutator for profile name
     * @param inputName the name to set the profile
     * to
     */
    public void setNameToView(String inputName)
    {      
        if (!hasSharedObject(inputName))
        {
            profileToView = null;
        }
        
        else
        {
            profileToView = getSharedObject(inputName, UserProfile.class);
        }
    }
    
    /**.
     * Accessor for name
     * @return profileToView.getName()the name of 
     * the profile
     */
    public String getNameToView()
    {    
        if (profileToView != null)
        {
            return profileToView.getName();
        }
        else
        {
            return null;
        }
    }
    
    /**.
     * Accessor viewer status
     * @return boolean the status of viewership
     */
    public boolean isViewingCurrentUser()
    {
        if (profileToView == null)
        {
            return true;
        }
        
        else 
        {
            return false;
        }
    }
    
    /**.
     * Accessor viewer status
     * @return boolean the status of viewership
     */
    public boolean isViewingDifferentUser()
    {
        if (profileToView != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**.
     * Mutator for profileToView field
     */
    public void clear()
    {
        profileToView = null;
    }
    
    /**.
     * Mutator for friends list
     */
    public void addViewedProfileAsFriend()
    {
        if (viewerFB.getCurrentUser() != profileToView)
        {
            viewerFB.getCurrentUser().addFriend(profileToView.getName());
        }
    }
    
    /**.
     * Accessor for the FB object
     * @return viewerFB tag for the fb
     */
    public FaceBooklet getFaceBooklet()
    {
        return viewerFB;
    }
 
}
